package com.user.micro;

public class UserEmploymentEntity {
	
	private Integer userID;
	private String userName;
	private String userDescription;
	private String userEmploymentDetailscsv;
	
	
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
	
	public String getUserEmploymentDetailscsv() {
		return userEmploymentDetailscsv;
	}
	public void setUserEmploymentDetailscsv(String userEmploymentDetailscsv) {
		this.userEmploymentDetailscsv = userEmploymentDetailscsv;
	}
	
	@Override
	public String toString() {
		return "UserEmploymentEntity [userID=" + userID + ", userName=" + userName + ", userDescription="
				+ userDescription + ", userEmploymentDetailscsv=" + userEmploymentDetailscsv + "]";
	}
	
	public UserEmploymentEntity() {

	}

	public UserEmploymentEntity(Integer userID, String userName, String userDescription, String userEmploymentDetailscsv) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userDescription = userDescription;
		this.userEmploymentDetailscsv = userEmploymentDetailscsv;
	}

}
