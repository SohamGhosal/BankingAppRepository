package com.BankingApp.controller;

import com.BankingApp.dto.CustomerRequests;
import com.BankingApp.dto.SecurityQuest;
import com.BankingApp.service.IGenericBankService;
import com.BankingApp.service.IRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
@Slf4j
public class RegistrationController {
    @Autowired
    IRegistrationService registrationService;
    @Autowired
    IGenericBankService genericBankService;

    @PostMapping(value = "/registeruser")
    public ResponseEntity<String> registerUser(@RequestBody CustomerRequests customerRequests) {
        try {
            registrationService.registerUser(customerRequests);
            return ResponseEntity.ok().body("Registration Successful");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Registration Failed");
        }
    }

    @GetMapping(value = "/getSecretquestions")
    public List<SecurityQuest> getSecretQuest() {
        return genericBankService.getQuestionList();
    }

    @GetMapping(value = "/cnfuser")
    public List<CustomerRequests> cnfUser() {
        return registrationService.getCustReqList();
    }

    @PostMapping(value = "/registeraccount")
    public ResponseEntity<String> registeraccount(@RequestBody String custReqId) {
        try {
            registrationService.insertCustomer(custReqId);
            return ResponseEntity.ok().body("Registration Successful");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Registration Failed");
        }
    }
}
