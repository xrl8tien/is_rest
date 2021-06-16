package com.is.issystem.service;

import com.is.issystem.dto.IllustrationDTO;
import com.is.issystem.dto.IllustrationItemOfList;
import com.is.issystem.entities.Illustration;
import com.is.issystem.entities.IllustrationMainBenifit;
import com.is.issystem.entities.IllustrationSubBenifit;
import com.is.issystem.repository.entity_dto_repository.IllustrationItemOfListRepository;
import com.is.issystem.repository.entity_repository.IllustrationMainBenifitRepository;
import com.is.issystem.repository.entity_repository.IllustrationRepository;
import com.is.issystem.repository.entity_repository.IllustrationSubBenifitRepository;
import com.is.issystem.repository.entity_repository.MainBenifitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class IllustrationService {
    @Autowired
    private IllustrationRepository illRepository;

    @Autowired
    private IllustrationItemOfListRepository illustrationItemOfListRepository;

    @Autowired
    private IllustrationMainBenifitRepository illustMainBenifitRepository;

    @Autowired
    private IllustrationSubBenifitRepository illustSubBenifitRepository;

    public List<IllustrationItemOfList> getAllIllustrationCustOwn(int id){
        return illustrationItemOfListRepository.listIllustrationCustomerOwn(id);
    }
    @Autowired
    private MainBenifitRepository mainBenifitRepository;

    public IllustrationDTO getDetailIllustration(Integer id){
        IllustrationDTO illustrationDTO = new IllustrationDTO();

        // lấy thông tin cơ bản của bản minh họa
        Optional<Illustration> illustration = illRepository.findById(id);
        illustrationDTO.setId(illustration.get().getId());
        illustrationDTO.setId_customer_info(illustration.get().getId_customer_info());
        illustrationDTO.setCreate_time(illustration.get().getCreate_time());
        illustrationDTO.setPayment_period_id(illustration.get().getPayment_period_id());
        illustrationDTO.setTotal_fee(illustration.get().getTotal_fee());



        // lấy thông tin người hưởng quyền lợi chính
        IllustrationMainBenifit illustrationMainBenifit = illustMainBenifitRepository.getIllustrationMainBenifitByillustID(id);
        illustrationDTO.setIllustrationMainBenifit(illustrationMainBenifit);
        illustrationDTO.setBenifit_name(mainBenifitRepository.findById(illustrationMainBenifit.getId_main_benifit()).get().getBenifit_name());

        // lấy thông tin các gói quyền lợi phụ của những người liên quan
        List<IllustrationSubBenifit> illustrationSubBenifits = illustSubBenifitRepository.getAllIllustrationSubByIllustID(id);
        illustrationDTO.setIllustrationSubBenifitList(illustrationSubBenifits);

        return illustrationDTO;
    }


    public List<IllustrationItemOfList> getAllIllustration(int id){
        return illustrationItemOfListRepository.listIllustrationCustomerOwn(id);
    }

    public List<IllustrationItemOfList> searchAllIllustration(int id,String dateFrom,String dateTo,String searchValue){
        return illustrationItemOfListRepository.searchListIllustrationCustomerOwn(id,dateFrom,dateTo,searchValue);
    }


    public void saveIllustration(IllustrationDTO illustrationDTO){
        Illustration illustration= new Illustration();
        illustration.setCreate_time(illustrationDTO.getCreate_time());
        illustration.setId_customer_info(illustrationDTO.getId_customer_info());
        illustration.setPayment_period_id(illustrationDTO.getPayment_period_id());
        illustration.setTotal_fee(illustrationDTO.getTotal_fee());

        illRepository.save(illustration);

        illustrationDTO.getIllustrationMainBenifit().setId_illustration(illustration.getId());

        illustMainBenifitRepository.save(illustrationDTO.getIllustrationMainBenifit());

        if(illustrationDTO.getIllustrationSubBenifitList() != null && illustrationDTO.getIllustrationSubBenifitList().size() != 0){
            for(IllustrationSubBenifit illustSub : illustrationDTO.getIllustrationSubBenifitList()){
                illustSub.setId_illustration(illustration.getId());
                illustSubBenifitRepository.save(illustSub  );
            }
        }
    }

    public boolean checkExistIllustration(IllustrationDTO illustrationDTO){
        return illustrationDTO.getId()== null  ? false : illRepository.existsById(illustrationDTO.getId());
    }

    public void updateIllustration(IllustrationDTO illustrationDTO){
        Optional<Illustration> illustration =  illRepository.findById(illustrationDTO.getId());
        illustration.get().setCreate_time(illustrationDTO.getCreate_time());
        illustration.get().setId_customer_info(illustrationDTO.getId_customer_info());
        illustration.get().setPayment_period_id(illustrationDTO.getPayment_period_id());
        illustration.get().setTotal_fee(illustrationDTO.getTotal_fee());

        illRepository.save(illustration.get());

        Optional<IllustrationMainBenifit> illustrationMainBenifit = illustMainBenifitRepository.findById(illustrationDTO.getIllustrationMainBenifit().getId());
        illustMainBenifitRepository.save(illustrationMainBenifit.get());

        if(illustrationDTO.getIllustrationSubBenifitList() != null && illustrationDTO.getIllustrationSubBenifitList().size() != 0){
            for(IllustrationSubBenifit item : illustrationDTO.getIllustrationSubBenifitList()){
                if(illustSubBenifitRepository.existsById(item.getId())){
                    Optional<IllustrationSubBenifit> illustrationSubBenifit = illustSubBenifitRepository.findById(item.getId());
                    illustSubBenifitRepository.save(illustrationSubBenifit.get());
                } else {
                    illustSubBenifitRepository.save(item);
                }
            }

        }
    }

}
