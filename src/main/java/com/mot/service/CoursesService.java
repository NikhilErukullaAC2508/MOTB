package com.mot.service;

import java.util.List;

import com.mot.entity.Courses;

public interface CoursesService {

    List<Courses> getAllCourses();

    Courses addCourse(Courses course);
//   
    
//	 public Courses addCourse(Courses course);
//	 public List<Courses> getAllMainCourses();
//	 public List<Courses> getAllSubCourses();
//	 public List<Courses> getSubCoursesByMainCourse(String  mainCourse);
}

