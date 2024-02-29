package com.voting.Dto;

import com.voting.Entity.Address;

public class UsersDto {

	String userName;
	String userDob;
	long userMobileNumber;
	String userGender;
	int userAge;
	String role="User";
	String userPassword;
	String ConfirmPassword;
	long aadharNo;
	Address address;
	public UsersDto(String userName, String userDob, long userMobileNumber, String userGender, int userAge, String role,
			String userPassword, String confirmPassword, long aadharNo, Address address) {
		super();
		this.userName = userName;
		this.userDob = userDob;
		this.userMobileNumber = userMobileNumber;
		this.userGender = userGender;
		this.userAge = userAge;
		this.role = role;
		this.userPassword = userPassword;
		ConfirmPassword = confirmPassword;
		this.aadharNo = aadharNo;
		this.address = address;
	}
	public UsersDto() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserDob() {
		return userDob;
	}
	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}
	public long getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddreess(Address address) {
		this.address = address;
	}
}