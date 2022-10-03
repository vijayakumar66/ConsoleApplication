package model;

public class UserModel {
	private String userName, email, userPassword;
	private int age;
	private long accountNumber,userId;
	private long mobile;
	private  double balance;
	public String getUserName() {	
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	

}
