package com.mot.entity;


import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pays")
public class Pay {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> selectedCourses;

    private double selectedAmount;

    private String currency;

    private String cardNumber;

    private String cardHolder;

    private String expiryDate;

    private String cvv;

	public Pay(Long id, List<String> selectedCourses, double selectedAmount, String currency, String cardNumber,
			String cardHolder, String expiryDate, String cvv) {
		super();
		this.id = id;
		this.selectedCourses = selectedCourses;
		this.selectedAmount = selectedAmount;
		this.currency = currency;
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getSelectedCourses() {
		return selectedCourses;
	}

	public void setSelectedCourses(List<String> selectedCourses) {
		this.selectedCourses = selectedCourses;
	}

	public double getSelectedAmount() {
		return selectedAmount;
	}

	public void setSelectedAmount(double selectedAmount) {
		this.selectedAmount = selectedAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Pay() {
		super();
		// TODO Auto-generated constructor stub
	}   
    
}