

package com.mot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mot.entity.Pay;
import com.mot.service.PayService;

import java.util.List;

@RestController
@RequestMapping("/api/pays")
@CrossOrigin(origins = "*") 
public class PayController {

    @Autowired
    private PayService payService;

 
    @GetMapping("/{id}")
    public ResponseEntity<Pay> getPayById(@PathVariable Long id) {
        Pay pay = payService.getPayById(id);
        if (pay != null) {
            return new ResponseEntity<>(pay, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/latest")
    public ResponseEntity<Pay> getLatestPay() {
        Pay latestPay = payService.getLatestPay();
        if (latestPay != null) {
            return new ResponseEntity<>(latestPay, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/payregistration")
    public ResponseEntity<Pay> createPay(@RequestBody Pay pay) {
        Pay createdPay = payService.createPay(pay);
        return new ResponseEntity<>(createdPay, HttpStatus.CREATED);
    }
}
