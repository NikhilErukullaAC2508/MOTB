package com.mot.service;

import java.util.List;
import java.util.Optional;

import com.mot.entity.AttendanceEntity;



public interface AttendenceService 
{
	String createAttendance(AttendanceEntity userEntity);
	
	AttendanceEntity UpdateAttendance(AttendanceEntity userEntity);
	
	List<AttendanceEntity> getAllAttendance();
	
	Optional<AttendanceEntity> getByMonth(String month);
	
	void deleteByMonth(String month);
	
	List<AttendanceEntity> getAllUserById(Long userId);
}
