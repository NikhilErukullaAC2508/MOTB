package com.mot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.AttendanceEntity;
import com.mot.repo.AttendenceRepo;

@Service
public class AttendenceServiceImp implements AttendenceService {
	@Autowired
	private AttendenceRepo userRepo;

	@Override
	public String createAttendance(AttendanceEntity userEntity) {
//		List<AttendanceEntity> ae= userRepo.findAllUserById(userEntity.getId());

		System.out.println("-------" + userEntity.getDate());

		List<AttendanceEntity> date = userRepo.findByDate(userEntity.getDate());

		userRepo.save(userEntity);

		return "Marked "+userEntity.getStatus();

	}

	@Override
	public AttendanceEntity UpdateAttendance(AttendanceEntity userEntity) {
		return userRepo.save(userEntity);
	}

	@Override
	public List<AttendanceEntity> getAllAttendance() {
		return userRepo.findAll();
	}

	@Override
	public Optional<AttendanceEntity> getByMonth(String month) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteByMonth(String month) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AttendanceEntity> getAllUserById(Long userId) {
		return userRepo.findAllUserById(userId);
	}
}
