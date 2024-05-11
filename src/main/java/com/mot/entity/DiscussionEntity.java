//package com.tutor.entity;
//
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "discussion_table")
//public class DiscussionEntity {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;
//
// private String tutorName;
// private String userName;
// private Long userId;
// private String message;
//public Long getId() {
//	return id;
//}
//public void setId(Long id) {
//	this.id = id;
//}
//public String getTutorName() {
//	return tutorName;
//}
//public void setTutorName(String tutorName) {
//	this.tutorName = tutorName;
//}
//public String getUserName() {
//	return userName;
//}
//public void setUserName(String userName) {
//	this.userName = userName;
//}
//public Long getUserId() {
//	return userId;
//}
//public void setUserId(Long userId) {
//	this.userId = userId;
//}
//public String getMessage() {
//	return message;
//}
//public void setMessage(String message) {
//	this.message = message;
//}
//
// 
//}






















// DiscussionEntity.java
package com.mot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "discussion_table")
public class DiscussionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tutorName;
    private Long tutorId;
    private String userName;
    private Long userId;
    private String message;
    private Date date;

    // Getters and Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
