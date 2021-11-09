package com.Springboot.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{	 

	 User findByEmail(String email);
     @Query("select u from User u  join u.mobile m where m.operator=:op")
     List<User> findByOperator(@Param("op") String op);

}
