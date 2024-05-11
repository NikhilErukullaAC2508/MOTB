package com.mot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.Courses;
import com.mot.repo.CoursesRepository;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {

//	private final CoursesRepository courseRepository;
//
//	@Autowired
//	public CoursesServiceImpl(CoursesRepository courseRepository) {
//	    this.courseRepository = courseRepository;
//	}
//
//
//    public Courses addCourse(Courses course) {
//         return courseRepository.save(course);
//    }
//    @Override
//    public List<Courses> getAllMainCourses() {
//        return courseRepository.findAll();
//    }
//    @Override
//    public List<Courses> getAllSubCourses() {
//        return courseRepository.findAll();
//    }
//    @Override
//    public List<Courses> getSubCoursesByMainCourse(String mainCourse) {
//        return courseRepository.findByMainCourse(mainCourse);
//    }


     @Autowired
    private  CoursesRepository courseRepository;

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses addCourse(Courses course) {
        return courseRepository.save(course);
    }
}

