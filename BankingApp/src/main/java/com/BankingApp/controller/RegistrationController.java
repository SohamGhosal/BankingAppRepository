package com.BankingApp.controller;

import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.dto.SecurityQuest;
import com.BankingApp.service.IGenericBankService;
import com.BankingApp.service.IRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/register")
@Slf4j
public class RegistrationController {
    @Autowired
    IRegistrationService registrationService;
    @Autowired
    IGenericBankService genericBankService;

    @PostMapping(value = "/registerUser")
    public boolean registerUser(@RequestBody CustomerRequests customerRequests) {
        return registrationService.registerUser(customerRequests);
    }

    @GetMapping(value = "/getSecretQuestions")
    public List<SecurityQuest> getSecretQuest() {
        return genericBankService.getQuestionList();
    }

    @GetMapping(value = "/CnfUser")
    public List<CustomerRequests> cnfUser() {
        return registrationService.getCustReqList();
    }

    @PostMapping(value = "/ConfirmAcc")
    public boolean cnfAcc(@RequestBody Integer custReqId) {
        return registrationService.insertCustomer(custReqId);
    }
}
