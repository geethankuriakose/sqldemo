package com.sqldemo.db;

import java.util.ArrayList;
import java.lang.*;
/**
* This program is  used to register our  databases for our keyword search. 
* @author  Geethan kuriakose,geethankuriakose@gmail.com
* @version 0.1
* @since 4-12-2021
*/


public class RegisterDBs {
	
	ArrayList AListDBInfo = new ArrayList();
	
	public RegisterDBs()
	{
	}
	
	
	/**
	* This method will return  our registered database . 
	* @return ArrayList  - it is return arraylist as our registered databases informations.

	*/

	
	public ArrayList getAllDBS()
	{
		RegisterDBPojo objRegisterDBPojo= new RegisterDBPojo();
		objRegisterDBPojo.setDriverName("org.postgresql.Driver");
		objRegisterDBPojo.setDriverURL("jdbc:postgresql");
		objRegisterDBPojo.setDBName("dbdemo");
		objRegisterDBPojo.setUserName("postgres");
		objRegisterDBPojo.setPassword("");
		objRegisterDBPojo.setServerIP("localhost");
		objRegisterDBPojo.setDriverPort("5432");
		AListDBInfo.add(objRegisterDBPojo);
		
		return AListDBInfo;
		
	}
	
	

}
