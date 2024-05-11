package com.mot.entity;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance_tbl")
public class AttendanceEntity {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date date;
  private Long userID;
  private String firstName;
  private String lastName;
  private String status;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}
public Long getUserID() {
	return userID;
}
public void setUserID(Long userID) {
	this.userID = userID;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
//public String getUserEmail() {
//	return UserEmail;
//}
//public void setUserEmail(String userEmail) {
//	UserEmail = userEmail;
//}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@PrePersist
protected void onCreate() {
    // Set the current date before persisting the entity
    date = new Date();
}
  
}
