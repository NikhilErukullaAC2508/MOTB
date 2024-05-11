package com.mot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mot.entity.HelpEntity;
import com.mot.repo.HelpRepository;

import java.util.List;

@Service
public class HelpService  implements HelpServices{
	@Autowired
    private  HelpRepository helpRepository;

    public List<HelpEntity> getAllHelpMessages() {
        return helpRepository.findAll();
    }

    public HelpEntity saveHelpMessage(HelpEntity help) {
        return helpRepository.save(help);
    }
}

