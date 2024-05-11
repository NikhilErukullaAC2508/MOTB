package com.mot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mot.entity.AttendanceEntity;
import com.mot.repo.AttendenceRepo;
import com.mot.service.AttendenceService;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/user")
public class AttendenceController 
{
	@Autowired
	private AttendenceService userService;
	
	@Autowired
	private AttendenceRepo arepo;
	
	
	@PostMapping("/createAttendance")
    public ResponseEntity<String> createAttendance(@RequestBody AttendanceEntity userEntity) {
		System.out.println(userEntity.getStatus());
		String createdUser = userService.createAttendance(userEntity);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/updateAttendance")
    public ResponseEntity<AttendanceEntity> updateAttendance(@RequestBody AttendanceEntity userEntity) {
    	AttendanceEntity updatedUser = userService.UpdateAttendance(userEntity);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("/getAllAttendance")
    public ResponseEntity<List<AttendanceEntity>> getAllAttendance() {
        List<AttendanceEntity> allAttendance = userService.getAllAttendance();
        return new ResponseEntity<>(allAttendance, HttpStatus.OK);
    }

    @GetMapping("/getByMonth/{month}")
    public ResponseEntity<AttendanceEntity> getByMonth(@PathVariable String month) {
        Optional<AttendanceEntity> userByMonth = userService.getByMonth(month);
        return userByMonth.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteByMonth/{month}")
    public ResponseEntity<Void> deleteByMonth(@PathVariable String month) {
        userService.deleteByMonth(month);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AttendanceEntity>> getAllUserById(@PathVariable Long userId)
    {
    	
    	List<AttendanceEntity> ate= arepo.findByUserID(userId);
    	
    	if(!ate.isEmpty()) {
    		
    		return ResponseEntity.ok().body(ate);
    		
    	}
    	
    	
//    	List<AttendanceEntity> attendanceEntity = userService.getAllUserById(userId);
    	return ResponseEntity.ok().body(ate);
    }
}
