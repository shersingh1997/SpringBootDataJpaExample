package com.Springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.entity.Mobile;
import com.Springboot.entity.User;

@Repository
public interface MobileRepository  extends JpaRepository<Mobile, Integer> 
{
    
	
 	List<Mobile> findByOperator(String op);
	

}
