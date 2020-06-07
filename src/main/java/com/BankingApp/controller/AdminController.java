package com.BankingApp.controller;

import com.BankingApp.dto.BankAdmin;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.Transactions;
import com.BankingApp.exception.BankingException;
import com.BankingApp.service.impl.GenericBankService;
import com.BankingApp.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankadmin")
@Slf4j
public class AdminController {
    @Autowired
    IAdminService adminService;
    @Autowired
    GenericBankService genericBankService;

    @PostMapping(value = "/adminlogin")
    public ResponseEntity<String> loginAdmin(@RequestBody BankAdmin bankAdmin) {
        if(adminService.validateAdmin(bankAdmin))
            return ResponseEntity.ok().body("Admin Logged in Successfully");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Admin Log in Failed");
    }

    @GetMapping(value = "/cnfusrreq")
    public List<ServiceTracker> cnfUserReq() {
        return adminService.getUserReq();
    }


    @DeleteMapping(value = "/rejectrequest")
    public ResponseEntity<String> delReq(@RequestBody String serviceId) {
        try {
            adminService.rejectServiceByServiceID(serviceId);
            return ResponseEntity.ok().body("Request Deleted");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Deletion Failed!");
        }
    }

    @GetMapping(value = "/viewallcustomers")
    public List<Customer> viewCust() {
        return adminService.getCustInfo();
    }

    @PostMapping(value = "/viewcustomer")
    public Customer viewCust(@RequestBody String customerId) {
        return adminService.getCust(customerId);
    }

    @PostMapping(value = "/getlog")
    public List<Transactions> getLog(@RequestParam("accountId") String accountId) {
        return genericBankService.getStatements(accountId);
    }

    @GetMapping(value = "/getalllogs")
    public List<Transactions> getAllLogs() {
        return adminService.getAllLogs();
    }

    @PostMapping(value="/registerAdmin")
    public ResponseEntity<String>regsierAdmin(@RequestBody BankAdmin bankAdmin)
    {
        try
        {
            adminService.registerAdmin(bankAdmin);
            return ResponseEntity.ok().body("Admin Registered");
        }
        catch (BankingException e)
        {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Admin Not Registered");
        }
    }
}
