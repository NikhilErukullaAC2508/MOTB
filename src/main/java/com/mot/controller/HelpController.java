package com.mot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mot.entity.HelpEntity;
import com.mot.service.HelpService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/api/help")
public class HelpController {
	@Autowired
    private  HelpService helpService;
    @GetMapping("Support")
    public List<HelpEntity> getAllHelpMessages() {
        return helpService.getAllHelpMessages();
    }

    @PostMapping("help1")
    public HelpEntity sendHelpMessage(@RequestBody HelpEntity help) {

        return helpService.saveHelpMessage(help);
    }
}

