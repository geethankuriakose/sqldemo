package com.sqldemo.db;

/**
* This is  a pojo class to store DB informations. 
* @author  Geethan kuriakose,geethankuriakose@gmail.com
* @version 0.1
* @since 4-12-2021
*/

public class RegisterDBPojo {
	
	
	
	private String DriverPort="";
	private String DBName="";
	private String UserName="";
	private String Password="";
	private String ServerIP="";
	private String DriverURL="";
	private String DriverName="";
	
	public String getServerIP() {
		return ServerIP;
	}
	public void setServerIP(String serverIP) {
		ServerIP = serverIP;
	}
	
	public String getDriverPort() {
		return DriverPort;
	}
	public void setDriverPort(String driverPort) {
		DriverPort = driverPort;
	}
	public String getDBName() {
		return DBName;
	}
	public void setDBName(String dBName) {
		DBName = dBName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	

	
	public void setDriverURL(String DriverURL) 
	{
		this.DriverURL = DriverURL;
	}
	
	public String  getDriverURL() 
	{
		return DriverURL ;
	}
	
	public void setDriverName(String DriverName) 
	{
		this.DriverName = DriverName;
	}
	
	public String  getDriverName() 
	{
		return DriverName ;
	}

}
