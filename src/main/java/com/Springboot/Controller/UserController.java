package com.Springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.Repository.UserRepository;
import com.Springboot.Services.UserService;
import com.Springboot.entity.Mobile;
import com.Springboot.entity.User;


@RestController
public class UserController 
{
	@Autowired
	private UserService service;
	
	@PostMapping("register")
	public String adduser(@RequestBody User user)

	{
		
		User u= service.findByEmailid(user.getEmail());
	    
		if(u==null)
		{
			service.adduser(user);}
					
		else
		{
			return "email exist...";
		}
		
	return "user added successfully...";
	
 }

    @PostMapping("/login")
	public String login(@RequestBody User user)
	{

	User u= service.findByEmail(user.getEmail());
	if(u==null)
    	return "incorrect emailid...";
    
	if(u.getEmail().equals(user.getEmail()) && (u.getPassword().equals(user.getPassword())))
	return "login successfully...";
	
    if(!(u.getPassword().equals(user.getPassword())))
	return "password incorrect...";
	
	 return "something went wrong...";

	}


	@PostMapping("/adduser")
	   public String SaveUser(@RequestBody User user)
	   {
		service.adduser(user);
		return "user addedd suceefully...";
		
	   }

	@PostMapping("/addusers")
	public List<User> saveusers(@RequestBody List<User> user)
	{
	return service.SaveUsers(user);
	}

	@GetMapping("/users")
	public List<User> getallusers()
	{
	 
	return service.getUser();
    }


	@GetMapping("/user/{id}")
	public User getbyid(@PathVariable int id)
	{
	return service.GetUserById(id);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteuser(@PathVariable int id)
	{
	return service.deletebyid(id);
	}

	@DeleteMapping("/deleteall")
	public String deleteuser()
	{
	return service.deleteall();
	}

	@PutMapping("/update/{id}")
	public User updateuser(@PathVariable int id , @RequestBody User user) throws ConfigDataResourceNotFoundException
	{
	return service.updateuser(id,user);
	}
	
	@GetMapping("/operator{op}")
	public List<User> operator(@PathVariable String op, @RequestBody Mobile mobile)
	{
	   return service.operator(op);
	}
	
}
