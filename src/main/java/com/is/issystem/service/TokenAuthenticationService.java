package com.is.issystem.service;

import com.is.issystem.commons.Ultility;
import io.jsonwebtoken.Jwts;
import org.json.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.util.Collections.emptyList;
public class TokenAuthenticationService {

    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";

    public static void addAuthentication(HttpServletResponse res, String username) throws IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        JSONObject obj = new JSONObject();
        obj.put("token_key", TOKEN_PREFIX + Ultility.generateTokenKey(username));
        out.print(obj.toString());
    }

    public static Authentication getAuthentication(HttpServletRequest request) throws IOException {
        String token = request.getParameter("token_key");
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
                    null;
        } else {
            return null;
        }

    }

    public static void FailAuthentication(HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        JSONObject obj = new JSONObject();
        obj.put("status_code", "not ok");
        out.print(obj.toString());
    }


}
