package com.user.micro;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Table")
public class UserEntity {
	
	@Id
	private Integer userID;
	private String userName;
	private String userDescription;
	
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	
	
	@Override
	public String toString() {
		return "UserEntity [userID=" + userID + ", userName=" + userName + ", userDescription=" + userDescription + "]";
	}
	
	public UserEntity() {

	}

	
	public UserEntity(Integer userID, String userName, String userDescription) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userDescription = userDescription;
	}

}
