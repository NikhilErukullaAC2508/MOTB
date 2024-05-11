package com.mot.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tutor_table2")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Long mobilenumber;
    private String email;
    private String password;
    private String confirmPassword;
	private String qualification;
    private String higherQualification;
    @ElementCollection
    private List<String> courses;
    private String address;
    private String gender;
    
    private Long findAllIds; 
	public Long getFindAllIds() {
		return findAllIds;
	}
	public void setFindAllIds(Long findAllIds) {
		this.findAllIds = findAllIds;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getHigherQualification() {
		return higherQualification;
	}
	public void setHigherQualification(String higherQualification) {
		this.higherQualification = higherQualification;
	}
	
	public String getAddress() {
		return address;
	}
	 public List<String> getCourses() {
	        return courses;
	    }

	    public void setCourses(List<String> courses) {
	        this.courses = courses;
	    }
	    
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	  public Long getMobilenumber() {
			return mobilenumber;
		}
		public void setMobilenumber(Long mobilenumber) {
			this.mobilenumber = mobilenumber;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
   
}

