package com.mot.service;

import com.mot.entity.Pay;

import java.util.List;

public interface PayService {

    Pay createPay(Pay pay);

    Pay getPayById(Long id);

    List<Pay> getAllPays();

    Pay getLatestPay();

	Pay createPay1(Pay pay);
}
