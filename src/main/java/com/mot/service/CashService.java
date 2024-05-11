package com.mot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.Cash;
import com.mot.entity.CashRequest;
import com.mot.repo.CashRepository;



@Service
public class CashService {

	@Autowired
    private  CashRepository cashRepository;

    public CashService(CashRepository cashRepository) {
        this.cashRepository = cashRepository;
    }

    public String processCashTransaction(CashRequest cashRequest) {
    
        String acknowledgmentNumber = generateAcknowledgmentNumber();


        double gstAmount = calculateGST(cashRequest.getAmount());

      
        double grandTotal = cashRequest.getAmount() + gstAmount;

       
        Cash cash = new Cash();
        cash.setAcknowledgment(acknowledgmentNumber);
        cash.setAmount(cashRequest.getAmount());
        cash.setCurrency(cashRequest.getCurrency());
        cash.setCourses(cashRequest.getCourses());
        cash.setGst(gstAmount);
        cash.setGrandTotal(grandTotal);

        cashRepository.save(cash);

        return acknowledgmentNumber;
    }

    private String generateAcknowledgmentNumber() {
       
        return "ACK" + generateRandomNumber(1000000, 9999999); 
    }

    private int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    private double calculateGST(double amount) {
       
        double gstPercentage = 18.0;
        return amount * (gstPercentage / 100.0);
    }
    public Cash getCashTransactionAcknowledgment(String acknowledgmentNumber) {
        
    	System.out.println(acknowledgmentNumber);
    	
    	Cash c= cashRepository.findByAcknowledgment(acknowledgmentNumber);
    	
        if (c!=null) {
        	
            return c; 
        } else {
            return c; 
        }
    }
    
    
    	
    
    
    
    public Cash getLatestCashTransaction() {
        return cashRepository.findTopByOrderByIdDesc();
    }
}