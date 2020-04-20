package com.BankingApp.controller;

import com.BankingApp.dto.BankAdmin;
import com.BankingApp.dto.Customer;
import com.BankingApp.dto.ServiceTracker;
import com.BankingApp.dto.Transactions;
import com.BankingApp.service.GenericBankService;
import com.BankingApp.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/BankAdmin")
@Slf4j
public class AdminController {
    @Autowired
    IAdminService adminService;
    @Autowired
    GenericBankService genericBankService;

    @PostMapping(value = "/adminLogin")
    public ResponseEntity<String> loginAdmin(@RequestBody BankAdmin bankAdmin) {
        if(adminService.validateAdmin(bankAdmin))
            return ResponseEntity.ok().body("Admin Logged in Succesfully");
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Admin Log in Falied");
    }

    @GetMapping(value = "/CnfUsrReq")
    public List<ServiceTracker> cnfUserReq() {
        return adminService.getUserReq();
    }

    @PostMapping(value = "/ConfirmReq")
    public boolean cnfReq(@RequestParam Integer serviceId) {
        return adminService.confirmServiceByServiceID(serviceId);
    }

    @DeleteMapping(value = "RejectRequest")
    public boolean delReq(@RequestParam Integer serviceId) {
        return adminService.rejectServiceByServiceID(serviceId);
    }

    @GetMapping(value = "/ViewAllCustomers")
    public List<Customer> viewCust() {
        return adminService.getCustInfo();
    }

    @PostMapping(value = "/ViewCustomer")
    public Customer viewCust(@RequestBody int customerId) {
        return adminService.getCust(customerId);
    }

    @PostMapping(value = "/getLog")
    public List<Transactions> getLog(@RequestParam("accountId") int accountId) {
        return genericBankService.getStatements(accountId);
    }

    @GetMapping(value = "/getAllLogs")
    public List<Transactions> getAllLogs() {
        return adminService.getAllLogs();
    }
}
