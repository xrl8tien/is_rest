package com.is.issystem.service;

import com.is.issystem.dto.ContractDTO;
import com.is.issystem.dto.ProductDTO;
import com.is.issystem.entities.*;
import com.is.issystem.repository.entity_dto_repository.ContractDTORepository;
import com.is.issystem.repository.entity_dto_repository.ProductDTORepository;
import com.is.issystem.repository.entity_repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractDTORepository contractDTORepository;
    @Autowired
    private ContractChangeHistoryRepository contractChangeHistoryRepository;
    @Autowired
    private FeePaymentHistoryRepository feePaymentHistoryRepository;
    @Autowired
    private BenifitPaymentHistoryRepository benifitPaymentHistoryRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private ProductDTORepository productDTORepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private CustomerInfoRepository customerInfoRepository;
    @Autowired
    private NotificationSettingRepository notificationSettingRepository;
    @Autowired
    private CustomerAccService customerAccService;

    public List<ContractDTO> getAllContract(String code_em_support) {
        return contractDTORepository.getAllContractDTO(code_em_support);
    }

    public List<ContractDTO> getAllContractForCustomer(Integer id_cust_info) {
        return contractDTORepository.getAllContractDTOForCustomer(id_cust_info);
    }

    public List<ContractDTO> searchAllContractForCustomer(int id, String dateFrom, String dateTo, String searchValue) {
        return contractDTORepository.searchAllContractDTOForCustomer(id, dateFrom, dateTo, searchValue);
    }

    public List<ContractDTO> searchAllContract(String code_em_support, String dateFrom, String dateTo, String searchValue) {
        return contractDTORepository.searchAllContractDTO(code_em_support, dateFrom, dateTo, searchValue);
    }

    public Integer getCountNewContract(String code_em_support, Integer monthDate) {
        return contractRepository.getAllContractCount(code_em_support, monthDate);
    }

    public ContractDTO getDetailContractForSaler(Integer id) {
        return contractDTORepository.getDetailContractForSaler(id);
    }

    //sale executive
    public List<ContractDTO> getAllContractEx(List<String> codes_em_support) {
        return contractDTORepository.getAllContractDTOEx(codes_em_support);
    }

    public List<ContractDTO> searchAllContractEx(List<String> codes_em_support, String dateFrom, String dateTo, String searchValue) {
        return contractDTORepository.searchAllContractDTOEx(codes_em_support, dateFrom, dateTo, searchValue);
    }

    // lấy detail contract cho 1 khách hàng ở trang website của customer
    public ContractDTO getDetailContractForCustomer(Integer id) {
        return contractDTORepository.getDetailContractForCustomer(id);
    }

    public Optional<ContractChangeHistory> getDetailContractChange(int id) {
        return contractChangeHistoryRepository.findById(id);
    }

    public List<ContractChangeHistory> getAllContractHistory(int id) {
        return contractChangeHistoryRepository.getAllContractChange(id);
    }

    public List<FeePaymentHistory> getAllFeePaymentHistory(int id) {
        return feePaymentHistoryRepository.getAllFeePayment(id);
    }

    public List<BenifitPaymentHistory> getAllIntersetPaymentHistory(int id) {
        return benifitPaymentHistoryRepository.getAllIntersetPayment(id);
    }

    public void setUpdateContract(int id_contract, Integer id_request, String description, String approval_status) {
        Optional<Contract> contract = contractRepository.findById(id_contract);
        contract.get().setApproval_status(approval_status);
        switch (approval_status) {
            case "DD":
                contract.get().setStatus(true);
                break;
            case "CXD":
                contract.get().setStatus(false);
                break;
            case "DXD":
                contract.get().setStatus(false);
                break;
            case "TC":
                contract.get().setStatus(false);
                break;
            case "YCT":
                contract.get().setStatus(false);
                break;
        }

        contractRepository.save(contract.get());

        if (id_request != -1) {
            Optional<Request> request = requestRepository.findById(id_request);
            request.get().setDescription(description);
            request.get().setStatus(approval_status);
            requestRepository.save(request.get());
        }


    }


    public void updateContract(Contract cont) {
        Optional<Contract> oldContract = contractRepository.findById(cont.getId());

        ContractChangeHistory HistoryContract = new ContractChangeHistory();
        HistoryContract.setId_contract(oldContract.get().getId());
        HistoryContract.setCreate_time(oldContract.get().getStart_time());
        HistoryContract.setId_request(1);
        HistoryContract.setApproval_status(oldContract.get().getApproval_status());
        HistoryContract.setId_customer(oldContract.get().getId_customer());
        HistoryContract.setName_contract_owner(oldContract.get().getName_contract_owner());
        HistoryContract.setPayment_period_id(oldContract.get().getPayment_period_id());
        HistoryContract.setInsurance_type(oldContract.get().getInsurance_type());
        HistoryContract.setId_main_benifitt(oldContract.get().getId_main_benifit());
        HistoryContract.setId_illustration(oldContract.get().getId_illustration());
        HistoryContract.setStart_time(oldContract.get().getStart_time());
        HistoryContract.setEnd_time(oldContract.get().getEnd_time());
        HistoryContract.setStatus(oldContract.get().getStatus());
        HistoryContract.setContract_total_value(oldContract.get().getContract_total_value());
        HistoryContract.setCreate_time(oldContract.get().getCreate_time());
        HistoryContract.setCode_em_support(oldContract.get().getCode_em_support());
        contractChangeHistoryRepository.save(HistoryContract);


        oldContract.get().setContract_total_value(cont.getContract_total_value());
        oldContract.get().setName_contract_owner(cont.getName_contract_owner());
        oldContract.get().setCreate_time(cont.getCreate_time());
        oldContract.get().setEnd_time(cont.getEnd_time());
        oldContract.get().setPayment_period_id(cont.getPayment_period_id());
        oldContract.get().setId_illustration(cont.getId_illustration());
        oldContract.get().setInsurance_type(cont.getInsurance_type());
        oldContract.get().setId_main_benifit(cont.getId_illustration());

    }

    public List<ProductDTO> getAllProductDTO() {
        return productDTORepository.getAllProductDTO();
    }

    //hẹn 1 giờ sáng chạy hàm này
    @Scheduled(cron = "0 0 1 * * *")
    public void autoSendNotification() {
        List<Contract> listContracts = contractRepository.getAllContractApproved();
        List<CustomerInfo> listCustomerInfos = customerInfoRepository.getAllBirthday();
        listContracts.forEach(contract -> {
            NotificationSetting notificationSetting = notificationSettingRepository.getNotificationSettingByCode(contract.getCode_em_support());
            if (notificationSetting == null) {
                if (calculateDate(contract.getStart_time(), contract.getPayment_period_id()) <= 30
                        && calculateDate(contract.getStart_time(), contract.getPayment_period_id()) >= 0) {
                    sendNotification(contract);
                    customerAccService.notificationEmail(contract);
                }
            } else {
                if (calculateDate(contract.getStart_time(), contract.getPayment_period_id()) <= notificationSetting.getDate_setting()
                        && calculateDate(contract.getStart_time(), contract.getPayment_period_id()) >= 0) {
                    sendNotification(contract);
                    customerAccService.notificationEmail(contract);
                }
            }
        });
        listCustomerInfos.forEach(customerInfo -> {
            Notification notification = new Notification();
            notification.setId_customer(customerInfo.getId());
            notification.setId(0);
            notification.setTitle("Chúc mừng sinh nhật khách hàng");
            notification.setDescription("Chúc mừng Anh/Chị sinh nhật vui vẻ, nhiều sức khỏe và hạnh phúc. Chúc Anh/Chị thêm tuổi mới gặt hái được nhiều thành công trong sự nghiệp, gia đình hạnh phúc vui vẻ");
            notification.setUrl("");
            notification.setType(4);
            notification.setDate(new java.util.Date());
            notificationRepository.save(notification);
        });
    }

    private void sendNotification(Contract contract) {
        List<Notification> listNotifications = notificationRepository.checkNotification(contract.getId_customer(), "%" + contract.getId() + "%");
        if (listNotifications == null || listNotifications.isEmpty()) {
            Notification notification = new Notification();
            notification.setId_customer(contract.getId_customer());
            notification.setId(0);
            notification.setTitle("Nhắc nhở đóng tiền hợp đồng");
            notification.setDescription("Hợp đồng #HD" + contract.getId() + "-" + contract.getInsurance_type() + " của quý khách sắp đến hạn nộp tiền. Quý khách vui lòng đóng tiền đúng hạn theo hợp đồng!");
            notification.setUrl("contract-customerweb");
            notification.setType(2);
            notification.setDate(new java.util.Date());
            notificationRepository.save(notification);
        }
    }

    public long calculateDate(Date start_time, Integer payment_period) {
        LocalDate dateNow = LocalDate.now();
        LocalDate startTime = start_time.toLocalDate();
        LocalDate dateTo;
        if (payment_period == 1) {
            dateTo = startTime.plusYears(1);
        } else if (payment_period == 2) {
            dateTo = startTime.plusMonths(6);
        } else if (payment_period == 3) {
            dateTo = startTime.plusMonths(3);
        } else {
            dateTo = startTime.plusMonths(1);
        }
        return ChronoUnit.DAYS.between(dateNow, dateTo);
    }

    public void updateNotificationSetting(NotificationSetting notificationSetting) {
        NotificationSetting noti = notificationSettingRepository.getNotificationSettingByCode(notificationSetting.getCode_sale());
        if (noti == null) {
            NotificationSetting newNoti = new NotificationSetting();
            newNoti.setId(notificationSetting.getId());
            newNoti.setCode_sale(notificationSetting.getCode_sale());
            newNoti.setDate_setting(notificationSetting.getDate_setting());
            notificationSettingRepository.save(newNoti);
        } else {
            Optional<NotificationSetting> newNoti = notificationSettingRepository.findById(noti.getId());
            newNoti.get().setCode_sale(notificationSetting.getCode_sale());
            newNoti.get().setDate_setting(notificationSetting.getDate_setting());
            notificationSettingRepository.save(newNoti.get());
        }
    }

    public NotificationSetting getNotificationSetting(String code_sale) {
        return notificationSettingRepository.getNotificationSettingByCode(code_sale);
    }

}
