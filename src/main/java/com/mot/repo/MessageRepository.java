//package com.mot.repo;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.mot.entity.MessageEntity;
//@Repository
//public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
//    
//}











package com.mot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mot.entity.MessageEntity;
@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

	List<MessageEntity> findByUserId(String userId);
	
	List<MessageEntity> findByCourseName(String courseName);
    
}
