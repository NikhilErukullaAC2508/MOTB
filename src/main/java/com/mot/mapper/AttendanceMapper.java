package com.mot.mapper;


import com.mot.entity.AttendanceEntity;
import com.mot.entity.User;

public class AttendanceMapper {
	
	public static AttendanceEntity mapToAttendance(User userEntity) {
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setUserID(userEntity.getId());
        attendanceEntity.setFirstName(userEntity.getFirstName());
        attendanceEntity.setLastName(userEntity.getLastName());
//        attendanceEntity.setUserEmail(userEntity.getEmail()); 
        
        attendanceEntity.setStatus(""); 
        return attendanceEntity;
    }

}

