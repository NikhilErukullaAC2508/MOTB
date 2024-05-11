
package com.mot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mot.entity.Pay;
import com.mot.repo.PayRepository;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayRepository payRepository;

    @Override
    public List<Pay> getAllPays() {
        return payRepository.findAll();
    }

    @Override
    public Pay getPayById(Long id) {
        return payRepository.findById(id).orElse(null);
    }

    @Override
    public Pay createPay(Pay pay) {
        return payRepository.save(pay);
    }



	@Override
	public Pay createPay1(Pay pay) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 @Override
	    public Pay getLatestPay() {
	        return payRepository.findTopByOrderByIdDesc();
	    }


}
