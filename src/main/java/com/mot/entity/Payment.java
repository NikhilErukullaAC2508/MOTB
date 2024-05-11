package com.mot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Payment.java


@Entity
public class Payment {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String cardNumber;
 private String expiry;
 private String cvv;
 private String name;
 private Double amount;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCardNumber() {
	return cardNumber;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
public String getExpiry() {
	return expiry;
}
public void setExpiry(String expiry) {
	this.expiry = expiry;
}
public String getCvv() {
	return cvv;
}
public void setCvv(String cvv) {
	this.cvv = cvv;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}


}
