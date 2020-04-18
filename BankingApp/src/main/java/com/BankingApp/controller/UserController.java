package com.BankingApp.controller;

import com.BankingApp.dto.BankUser;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.Transactions;
import com.BankingApp.service.IGenericBankService;
import com.BankingApp.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/LoginUser")
@Slf4j
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    IGenericBankService genericBankService;

    @PostMapping(value = "/ChangePwd")
    public BankUser changePassword(@RequestBody BankUser bankUser) {
        return userService.changePassword(bankUser);
    }

    @PostMapping(value = "/Update")
    public Customer update(@RequestBody Customer customer) {
        return userService.updateDetails(customer);
    }

    @PostMapping(value = "/addrequest")
    public ServiceTracker addRequest(@RequestBody String accountId) {
        if (userService.checkPendingRequest(Integer.parseInt(accountId))) {
            return userService.addCheckRequest(Integer.parseInt(accountId));
        } else
            return null;
    }

    @GetMapping(value = "/byServiceid")
    public ServiceTracker getById(@RequestParam String serviceId) {
        ;
        return genericBankService.showServiceByID(Integer.parseInt(serviceId));
    }

    @PostMapping(value = "/displayacc")
    public List<ServiceTracker> getByAccId(@RequestBody String accountId) {
        return userService.showServiceByAccID(Integer.parseInt(accountId));
    }

    @PostMapping(value = "/getStatement")
    public List<Transactions> getStatement(@RequestBody String accountId) {
        return genericBankService.getStatements(Integer.parseInt(accountId));
    }

}
