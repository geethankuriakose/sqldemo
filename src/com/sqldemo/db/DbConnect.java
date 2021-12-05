package com.sqldemo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
* This program is used to open the database connectivity. 
* @author  Geethan kuriakose,geethankuriakose@gmail.com
* @version 0.1
* @since 4-12-2021
*/

public class DbConnect {
	
	public DbConnect()
	{
		
	}
	
	
  /**
   * This method is used to  open the database connection.
   * @param strDriverName This is the DB driver Name
   * @param strURL  This is the DB URL
   * @param strUserName  This is the DB userName
   * @param strPassword  This is the DB password
   * @return Connection  This returns  active DB Connection.
   */
	
	public Connection OpenDatabase(String strDriverName,String strURL,String strUserName,String strPassword) throws SQLException
	{
		 Connection Con=null;
		  try {
	           // Class.forName("org.postgresql.Driver");
	            Class.forName(strDriverName);
	            Con= DriverManager.getConnection(strURL, strUserName, strPassword);
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	        }
		  return Con;
	}

}
