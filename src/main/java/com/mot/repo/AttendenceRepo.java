package com.mot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mot.entity.AttendanceEntity;
import java.util.Date;

@Repository
public interface AttendenceRepo extends JpaRepository<AttendanceEntity, Long> {

	List<AttendanceEntity> findByUserID(Long userID);
	
	List<AttendanceEntity> findAllUserById(Long userId);

	List<AttendanceEntity> findByDate(Date date);
	
	AttendanceEntity findByUserIDAndFirstName(Long id,String fname); 

}
