package com.user.micro;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findByUserName(String userName);
	
	Optional<UserEntity> findByUserDescription(String userDesc); 
	
}
