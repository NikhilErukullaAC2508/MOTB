package com.mot.service;

import java.util.List;

import com.mot.entity.HelpEntity;

public interface HelpServices {
	public List<HelpEntity> getAllHelpMessages();
	public HelpEntity saveHelpMessage(HelpEntity help);
	

}
