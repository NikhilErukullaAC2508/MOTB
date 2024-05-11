package com.mot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mot.entity.Cash;
import com.mot.entity.CashRequest;
import com.mot.service.CashService;



@RestController
@CrossOrigin("*")
public class CashController {

    @Autowired
    private CashService cashService;

    @PostMapping("/cash")
    public ResponseEntity<String> processCashTransaction(@RequestBody CashRequest cashRequest) {
        String acknowledgmentNumber = cashService.processCashTransaction(cashRequest);
        return ResponseEntity.ok(acknowledgmentNumber);
    }
    @GetMapping("/cash/get/{acknowledgmentNumber}")
    public ResponseEntity<Cash> getCashTransactionAcknowledgment(@PathVariable String acknowledgmentNumber) {
        Cash c = cashService.getCashTransactionAcknowledgment(acknowledgmentNumber);
        System.out.println(c );
        if (c != null) {
            return ResponseEntity.ok(c);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
    
    @GetMapping("/cash/latest")
    public ResponseEntity<Cash> getLatestCashTransaction() {
        Cash latestCashTransaction = cashService.getLatestCashTransaction();
        if (latestCashTransaction != null) {
            return ResponseEntity.ok(latestCashTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
    @GetMapping("/getdata")
    public String getdata() {
    	
    	return "data";
    }
}