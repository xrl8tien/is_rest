package com.is.issystem.repository.entity_repository;
import com.is.issystem.dto.IllustrationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.is.issystem.entities.Illustration;

import java.util.List;

@Repository
public interface IllustrationRepository extends JpaRepository<Illustration,Integer> {

}
