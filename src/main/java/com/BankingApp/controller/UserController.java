package com.BankingApp.controller;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.Transactions;
import com.BankingApp.service.IGenericBankService;
import com.BankingApp.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/LoginUser")
@Slf4j
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    IGenericBankService genericBankService;

    @PostMapping(value = "/changepwd")
    public BankUser changePassword(@RequestBody BankUser bankUser) {
        return userService.changePassword(bankUser);
    }

    @PostMapping(value = "/updatecustomer")
    public ResponseEntity<String> update(@RequestBody Customer customer) {
         try{
             userService.updateDetails(customer);
             return ResponseEntity.ok().body("Customer Details Updated Successfully");
         }
         catch (Exception e)
         {
             return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Customer Details Not Updated");
         }
    }

    @PostMapping(value = "/addrequest")
    public ResponseEntity<String> addRequest(@RequestBody String accountId) {
        if (userService.checkPendingRequest(accountId)) {
            try {
                userService.addCheckRequest(accountId);
                return ResponseEntity.ok().body("Request Added Successfully");
            }
            catch (Exception e)
            {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Request Not Added");
            }
        }
        else
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Request Not Added");
    }

    @GetMapping(value = "/byserviceid")
    public ServiceTracker getById(@RequestParam String serviceId) {
        return genericBankService.showServiceByID(serviceId);
    }

    @PostMapping(value = "/displayacc")
    public List<ServiceTracker> getByAccId(@RequestBody String accountId) {
        return userService.showServiceByAccID(accountId);
    }

    @PostMapping(value = "/getstatement")
    public List<Transactions> getStatement(@RequestBody String accountId) {
        return genericBankService.getStatements(accountId);
    }
    @PostMapping(value="/login")
    public ResponseEntity<String> login(@RequestBody BankUser bankUser)
    {
        if(genericBankService.loginUser(bankUser))
            return ResponseEntity.ok().body("Logged in Successfully");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Log in Failed");
    }
}
