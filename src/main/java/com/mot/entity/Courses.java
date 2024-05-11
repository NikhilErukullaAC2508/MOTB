package com.mot.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

public class Courses {
//	 @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//
//	    @Column(nullable = false)
//	    private String mainCourse;
//
//	    @Column(nullable = false)
//	    private String subCourse;
//
//		public Long getId() {
//			return id;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}
//
//		public String getMainCourse() {
//			return mainCourse;
//		}
//
//		public void setMainCourse(String mainCourse) {
//			this.mainCourse = mainCourse;
//		}
//
//		public String getSubCourse() {
//			return subCourse;
//		}
//
//		public void setSubCourse(String subCourse) {
//			this.subCourse = subCourse;
//		}
//
// 


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courses;
    private String description;
    private float price;
    

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    

}

