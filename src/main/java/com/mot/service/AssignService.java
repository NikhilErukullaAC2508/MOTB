package com.mot.service;

import java.util.List;

import com.mot.entity.AssignTutor;
//import com.tutor.entity.User;

public interface AssignService {

	AssignTutor addTutor(AssignTutor assign_tutor);
	public AssignTutor updateGroup(AssignTutor training);
	public List<AssignTutor>getAllgAssigns();
	public AssignTutor getById(Long id);
//	public String deletegroup(Long id);
//	void addTutor(User user);
	
	
	AssignTutor getByEmail(String email);

}
