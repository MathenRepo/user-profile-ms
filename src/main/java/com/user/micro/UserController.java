package com.user.micro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/UserProfile")
@EnableHystrix
@EnableHystrixDashboard
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/{user}")
	@HystrixCommand(fallbackMethod = "fallBackUserCall")
	public UserEntity getUserDetail(@PathVariable String user) {
		UserEntity userObj = userRepo.findByUserName(user).orElse(new UserEntity(9999,"NoUser","NoUser"));
		UserEmploymentEntity u = restTemplate.getForObject("http://USER-EMPLOYMENT-MAINT/UserEmployment/" + userObj.getUserID(), UserEmploymentEntity.class);
		userObj.setUserDescription(userObj.getUserDescription() + "   Companies Worked in : " + u.getUserEmploymentDetailscsv());
		return userObj;
	}
	
	public UserEntity fallBackUserCall(@PathVariable String user) {
		UserEntity userObj = userRepo.findByUserName(user).orElse(new UserEntity(9999,"NoUser","NoUser"));
		userObj.setUserDescription("No Employment Details Found , Call back Methord , !! Service Down");
		return userObj;
	}
	
	@GetMapping("/allusers")
	@HystrixCommand(fallbackMethod = "fallBackAllUsersCall")
	public List<UserEntity> getUserDetails() {
		Iterable<UserEntity> users = userRepo.findAll();
		List<UserEntity> userEntity = new ArrayList<>();
		users.forEach(userEntity::add);
		return userEntity;
	}
	
	@ResponseBody
	public String fallBackAllUsersCall() {
		return "No USer Details Fetched : Service Down";
	}
	
}
