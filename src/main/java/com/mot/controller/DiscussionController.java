//package com.mot.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import com.mot.entity.DiscussionEntity;
//import com.mot.service.DiscussionServices;
//
//import java.util.List;
//
//
//
//@RestController
//@CrossOrigin(origins = "*")
//@Controller
//@RequestMapping("/api/discussion")
//public class DiscussionController {
//
//    @Autowired
//    private DiscussionServices discussionService;
//
//    @GetMapping("/getAll")
//    public List<DiscussionEntity> getAllDiscussions() {
//        return discussionService.getAllDiscussions();
//    }
//
//    @GetMapping("/getByUserId/{userId}")
//    public List<DiscussionEntity> getDiscussionsByUserId(@PathVariable Long userId) {
//        return discussionService.getDiscussionsByUserId(userId);
//    }
//
//    @GetMapping("/getByTutorId/{tutorId}")
//    public List<DiscussionEntity> getDiscussionsByTutorId(@PathVariable Long tutorId) {
//        return discussionService.getDiscussionsByTutorId(tutorId);
//    }
//}















package com.mot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mot.entity.DiscussionEntity;
import com.mot.service.DiscussionServices;

import java.util.List;



@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/api/discussion")
public class DiscussionController {

    @Autowired
    private DiscussionServices discussionService;

    @GetMapping("/getAll")
    public List<DiscussionEntity> getAllDiscussions() {
        return discussionService.getAllDiscussions();
    }

    @GetMapping("/getByUserId/{userId}")
    public List<DiscussionEntity> getDiscussionsByUserId(@PathVariable Long userId) {
        return discussionService.getDiscussionsByUserId(userId);
    }

    @PostMapping("/save")
    public DiscussionEntity saveDiscussion(@RequestBody DiscussionEntity discussion) {
        return discussionService.saveDiscussion(discussion);
    }
    @GetMapping("/getByTutorId/{tutorId}")
    public List<DiscussionEntity> getDiscussionsByTutorId(@PathVariable Long tutorId) {
        return discussionService.getDiscussionsByTutorId(tutorId);
    }
}
