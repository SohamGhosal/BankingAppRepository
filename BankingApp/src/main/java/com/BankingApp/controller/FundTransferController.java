package com.BankingApp.controller;

import com.BankingApp.dto.AccountMaster;
import com.BankingApp.dto.PayeeTable;
import com.BankingApp.exception.BankingException;
import com.BankingApp.service.IFundTransferService;
import com.BankingApp.service.IGenericBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fundtransfer")
@Slf4j
public class FundTransferController {
    @Autowired
    IFundTransferService fundTransferService;
    @Autowired
    IGenericBankService genericBankService;

    @PostMapping(value = "/fundtrans")
    public ResponseEntity<String> completeFundTransfer(@RequestBody PayeeTable trans) {
        long avlamt = 0;
        AccountMaster acc = genericBankService.getAccountDetails(trans.getAccId());
        if (acc.getAccountType().equalsIgnoreCase("current")) {
            avlamt = acc.getAccountBal() - 500;
        } else if (acc.getAccountType().equalsIgnoreCase("savings")) {
            if (acc.getChequeStatus().equalsIgnoreCase("R") || acc.getChequeStatus().equalsIgnoreCase("Y")) {
                avlamt = acc.getAccountBal() - 500;
            } else {
                avlamt = acc.getAccountBal() - 100;
            }
        }
        try {
            if (!fundTransferService.checkAccId(trans.getPayeeAccId())) {
                return ResponseEntity.badRequest().body("Wrong Payee info given");
            } else {
                if (trans.getAmount() <= avlamt) {
                    if (trans.getAmount() >= 100) {
                        try {
                            fundTransferService.transferFund(trans);
                            return ResponseEntity.ok().body("Fund Transfer Done Successfully");
                        } catch (BankingException e) {
                            return ResponseEntity.badRequest().body( "Error Occured!");
                        }

                    } else {
                        return ResponseEntity.badRequest().body( "Atleast amount of 100 has to be transferred");
                    }
                } else {
                    return ResponseEntity.badRequest().body( "Not Enough Balance");
                }
            }
        } catch (BankingException e) {
            log.error("Fund Transfer Failed");
            return ResponseEntity.badRequest().body( "Fund Transfer Failed");
        }

    }

}
