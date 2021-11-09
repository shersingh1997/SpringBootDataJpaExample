package com.Springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.Services.MobileService;
import com.Springboot.entity.Mobile;
import com.Springboot.entity.User;

@RestController
public class MobileController 
{
	@Autowired
	MobileService service1;
	
	@GetMapping("/operator")
	public List<Mobile> operator(@RequestBody Mobile mobile)
	{
		String op=mobile.getOperator();
		return service1.findByOperator(op);
	}


}
