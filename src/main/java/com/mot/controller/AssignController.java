package com.mot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mot.entity.AssignTutor;
import com.mot.service.AssignService;
@RequestMapping("/admin")
@Controller
@RestController
@CrossOrigin(origins = "*")
public class AssignController {
	@Autowired
	private AssignService assignservice;
	
@PostMapping("/assign")
public  ResponseEntity<AssignTutor> addTutor(@RequestBody AssignTutor assign_tutor) {
	assignservice.addTutor(assign_tutor);
		return new  ResponseEntity<AssignTutor>(assign_tutor,HttpStatus.CREATED);
	}
@GetMapping("/show")
public List<AssignTutor> getAllgAssigns() {
List<AssignTutor> tutor=assignservice.getAllgAssigns();
	return tutor;
}



@GetMapping("/get/{email}")
public ResponseEntity<AssignTutor> getByEmail(@PathVariable String email) {
    AssignTutor tutor = assignservice.getByEmail(email);
    if (tutor != null) {
        return ResponseEntity.ok(tutor);
    } else {
        return ResponseEntity.notFound().build();
    }
}


}
