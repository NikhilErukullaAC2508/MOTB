package com.mot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.AssignTutor;
import com.mot.repo.AssignTutorRepository;
@Service
public class AssignServiceImpl implements AssignService {
	@Autowired
	private AssignTutorRepository repository;

	@Override
	public AssignTutor addTutor(AssignTutor assign_tutor) {
		
		return repository.save(assign_tutor);
	}

	@Override
	public AssignTutor updateGroup(AssignTutor training) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssignTutor> getAllgAssigns() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public AssignTutor getById(Long id) {
		Optional<AssignTutor>findById=repository.findById(id);
		if(findById.isEmpty()) {
			return null;
		}
		AssignTutor tutor=findById.get();
		return tutor;
	}
	

	 @Override
	    public AssignTutor getByEmail(String email) {
	        return repository.findByEmail(email);
	    }
	
	
}
