package bean;

import java.io.Serializable;

public class Signin implements Serializable {
	String userName="";
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String password="";
}
