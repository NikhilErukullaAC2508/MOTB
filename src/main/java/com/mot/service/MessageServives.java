package com.mot.service;

import java.util.List;
import java.util.Optional;

import com.mot.entity.MessageEntity;

public interface MessageServives {
	 public Optional<MessageEntity> getMessagesByUserId(Long userId) ;
	 public MessageEntity saveMessage(MessageEntity message);
	 public List<MessageEntity> getAllMessage();
	 
}
