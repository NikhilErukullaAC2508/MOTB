//package com.mot.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.mot.entity.MessageEntity;
//import com.mot.repo.MessageRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MessageService  implements MessageServives{
//@Autowired
//    private  MessageRepository messageRepository;
//
//@Override
//    public Optional<MessageEntity> getMessagesByUserId(Long userId) {
//        return messageRepository.findById(userId);
//    }
//  @Override
//    public  MessageEntity saveMessage(MessageEntity message) {
//       return messageRepository.save(message);
//    }
//  @Override
//	public List<MessageEntity> getAllMessage() 
//	{
//		return messageRepository.findAll();
//	}
//}
//























package com.mot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.MessageEntity;
import com.mot.repo.MessageRepository;

import java.util.List;
import java.util.Optional;





@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<MessageEntity> getMessagesByUserId(String userId) {
        return messageRepository.findByUserId(userId);
    }

    public List<MessageEntity> getAllMessages(String courseName) {
    	
    	
    	
        return messageRepository.findByCourseName(courseName);
    }

    public Optional<MessageEntity> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    public MessageEntity saveMessage(MessageEntity message) {
        return messageRepository.save(message);
    }

    public MessageEntity updateMessage(Long id, MessageEntity updatedMessage) {
        Optional<MessageEntity> existingMessage = messageRepository.findById(id);
        if (existingMessage.isPresent()) {
            MessageEntity messageToUpdate = existingMessage.get();
            // Update fields based on your requirements
            messageToUpdate.setUserId(updatedMessage.getUserId());
            messageToUpdate.setTutorId(updatedMessage.getTutorId());
            messageToUpdate.setLiveLink(updatedMessage.getLiveLink());
            messageToUpdate.setTime(updatedMessage.getTime());
            messageToUpdate.setCourseName(updatedMessage.getCourseName());
            return messageRepository.save(messageToUpdate);
        } else {
            // Handle not found case
            return null;
        }
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}

