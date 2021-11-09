package com.Springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.Repository.MobileRepository;
import com.Springboot.Repository.UserRepository;
import com.Springboot.entity.Mobile;
import com.Springboot.entity.User;

@Service
public class UserService 
{

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private MobileRepository mobilerepo;

	@Autowired
	public UserService(UserRepository userRepository)
	{
	      this.userRepository = userRepository;
	}
	
	

    public User findByEmailid(String Emailid) 
    {
		 return   userRepository.findByEmail(Emailid);
	}


	public void adduser(User user)
	{
		
		
	 userRepository.save(user);
	}

	public List<User> SaveUsers(java.util.List<User> user)
	{
	return userRepository.saveAll(user);
	}


	public List<User> getUser()
	{
	return userRepository.findAll();
	}


	public User GetUserById(int id)
	{
	return  userRepository.findById(id).orElse(null);
	}


	public User findByEmail(String Emailid) {
	 User u = userRepository.findByEmail(Emailid);
	 return u;
	}


	
	public String deletebyid(int id)
	{       userRepository.deleteById(id);
	return "removed Successfully..."+id;
	}


	public String deleteall()
	{    userRepository.deleteAll();
	return "removed Successfully...";
	}


	public User updateuser(int id, User user) {
		User existuser=userRepository.findById(id).orElse(null);
		existuser.setId(user.getId());
		existuser.setFname(user.getFname());
		existuser.setEmail(user.getEmail());
		existuser.setPassword(user.getPassword());
		return userRepository.save(existuser);
	}



	public List<User> operator(String op) {
		
		return userRepository.findByOperator(op);
	}



	
}
