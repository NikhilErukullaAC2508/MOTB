package com.mot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mot.entity.Courses;
import com.mot.service.CoursesService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/api/admin")
public class CoursesController {
//
//	private final CoursesService courseService;
//
//	@Autowired
//	public CoursesController(CoursesService courseService) {
//	    this.courseService = courseService;
//	};
//    
//    
//    @PostMapping("/api/courses/add")
//    public ResponseEntity<String> addCourse(@RequestBody Courses course) {
//        // Map CourseDTO to Course entity and save it
////        Courses course = new Courses();
//        courseService.addCourse(course);
//        return ResponseEntity.ok("Course added successfully");
//    }
//    @GetMapping("/main-courses")
//    public ResponseEntity<List<Courses>> getAllMainCourses() {
//        List<Courses> mainCourses = courseService.getAllMainCourses();
//        return new ResponseEntity<>(mainCourses, HttpStatus.OK);
//    }
//
//    @GetMapping("/sub-courses")
//    public ResponseEntity<List<Courses>> getAllSubCourses() {
//        List<Courses> subCourses = courseService.getAllSubCourses();
//        return new ResponseEntity<>(subCourses, HttpStatus.OK);
//    }
//    @GetMapping("/main-courses/{mainCourse}/sub-courses")
//    public ResponseEntity<List<Courses>> getSubCoursesByMainCourse(@PathVariable String mainCourse) {
//        List<Courses> subCourses = courseService.getSubCoursesByMainCourse(mainCourse);
//        return new ResponseEntity<>(subCourses, HttpStatus.OK);
//    }

    @Autowired
   private  CoursesService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Courses>> getAllCourses() {
        List<Courses> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/add-course")
    public ResponseEntity<Courses> addCourse(@RequestBody Courses course) {
       Courses addedCourse = courseService.addCourse(course);
        return new ResponseEntity<>(addedCourse, HttpStatus.CREATED);
    }
}
