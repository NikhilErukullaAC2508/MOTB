package com.mot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mot.entity.Courses;
@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {

//	List<Courses> findByMainCourse(String mainCourse);

}

