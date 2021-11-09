package com.Springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.Repository.MobileRepository;
import com.Springboot.entity.Mobile;

@Service
public class MobileService
{
	@Autowired
	MobileRepository mobilerepo1;
	
public List<Mobile> findByOperator(String op) {
		
		return mobilerepo1.findByOperator(op);
	}

}
