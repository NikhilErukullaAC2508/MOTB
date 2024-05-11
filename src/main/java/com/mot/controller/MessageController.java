////package com.Message.Controller;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Controller;
////import org.springframework.web.bind.annotation.*;
////
////import com.Message.Entity.MessageEntity;
////import com.Message.Service.MessageService;
////
////import java.util.List;
////import java.util.Optional;
////
////@RestController 
////@Controller
////@CrossOrigin(origins = "*")
////@RequestMapping("/api/messages")
////public class MessageController {
////    @Autowired
////    private MessageService messageService;
////
////    
////
////    @GetMapping("/{userId}")
////    public Optional<MessageEntity> getMessagesByUserId(@PathVariable Long userId) {
////        return messageService.getMessagesByUserId(userId);
////    }
////
////    
////
////
////    
////    @GetMapping("/message")
////	public List<MessageEntity> getAllMessage() 
////	{
////		return messageService.getAllMessage();
////	}
////    
////    @PostMapping("/post")
////    public  MessageEntity postMessage(@RequestBody MessageEntity message) {
////         return messageService.saveMessage(message);
////    }
////}
////
//
//
//
//
////// MessageController.java
////package com.Message.Controller;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Controller;
////import org.springframework.web.bind.annotation.*;
////import com.Message.Entity.MessageEntity;
////import com.Message.Service.MessageService;
////
////import java.sql.Date;
////import java.util.List;
////import java.util.Optional;
////
////@RestController
////@Controller
////@CrossOrigin(origins = "*")
////@RequestMapping("/api/messages")
////public class MessageController {
////    @Autowired
////    private MessageService messageService;
////
////    @GetMapping("/{userId}")
////    public Optional<MessageEntity> getMessagesByUserId(@PathVariable Long userId) {
////        return messageService.getMessagesByUserId(userId);
////    }
////
////    @GetMapping("/message")
////    public List<MessageEntity> getAllMessage() {
////        return messageService.getAllMessage();
////    }
////
////    @PostMapping("/post")
////    public MessageEntity postMessage(@RequestBody MessageEntity message) {
////        message.setDate(new Date(26, 01, 2024)); // Set the current date
////        return messageService.saveMessage(message);
////    }
////}
////
//
//
//
//
//
//
//
//
//
//
//
//// MessageController.java
//package com.mot.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import com.mot.entity.MessageEntity;
//import com.mot.service.MessageService;
//
//import java.sql.Date;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@Controller
//@CrossOrigin(origins = "*")
//@RequestMapping("/api/messages")
//public class MessageController {
//    @Autowired
//    private MessageService messageService;
//
//    @GetMapping("/Get")
//    public Optional<MessageEntity> getMessagesByUserId(@PathVariable Long userId) {
//        return messageService.getMessagesByUserId(userId);
//    }
//
//    @GetMapping("/message")
//    public List<MessageEntity> getAllMessage() {
//        return messageService.getAllMessage();
//    }
//
//    @PostMapping("/post")
//    public MessageEntity postMessage(@RequestBody MessageEntity message) {
//        // Manually set the date and time
//       
//        // Set the course name (you can modify this based on your requirements)
//        return messageService.saveMessage(message);
//    }
//}
//
//

























package com.mot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.mot.entity.MessageEntity;
import com.mot.service.MessageService;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/messages")
public class MessageController {
	
    @Autowired
    private MessageService messageService;

    @GetMapping("/user/{userId}")
    public List<MessageEntity> getMessagesByUserId(@PathVariable String userId) {
        return messageService.getMessagesByUserId(userId);
    }

    @GetMapping("/message/{courseName}")
    public List<MessageEntity> getAllMessages(@PathVariable String courseName) {
    	System.out.println(courseName);
    	return messageService.getAllMessages(courseName);
    }

    @PostMapping("/post")
    public MessageEntity postMessage(@RequestBody MessageEntity message) {
     return messageService.saveMessage(message);
        // Your implementation
    }

    @GetMapping("/{id}")
    public Optional<MessageEntity> getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @PutMapping("/update/{id}")
    public MessageEntity updateMessage(@PathVariable Long id, @RequestBody MessageEntity updatedMessage) {
        return messageService.updateMessage(id, updatedMessage);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }
}




