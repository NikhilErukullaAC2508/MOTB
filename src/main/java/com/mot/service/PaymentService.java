package com.mot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.Payment;
import com.mot.repo.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
@Autowired
 private final PaymentRepository paymentRepository;


 public PaymentService(PaymentRepository paymentRepository) {
     this.paymentRepository = paymentRepository;
 }

 public List<Payment> getAllPayments() {
     return paymentRepository.findAll();
 }

 public Optional<Payment> getPaymentById(Long id) {
     return paymentRepository.findById(id);
 }

 public Payment savePayment(Payment payment) {
     return paymentRepository.save(payment);
 }
}

