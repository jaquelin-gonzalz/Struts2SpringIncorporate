package com.mx.subastas.vo;

/**
 * @author Dinesh Rajput
 *
 */
public class UserBean {
	private String userName;
	private int userAge;
	private String userGender;
	private String userJob;
	private String []userHobbies;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserJob() {
		return userJob;
	}
	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}
	public String[] getUserHobbies() {
		return userHobbies;
	}
	public void setUserHobbies(String[] userHobbies) {
		this.userHobbies = userHobbies;
	}
	
}
