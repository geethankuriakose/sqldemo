package com.sqldemo.query;

import java.sql.Connection;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.sqldemo.db.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;


/**
* This program is  used to list available tables from  our  registered databases.. 
* @author  Geethan kuriakose,geethankuriakose@gmail.com
* @version 0.1
* @since 4-12-2021
*/

public class FindTable
{
	private String StrCondtions="";  
	private String SearchKey="EU";
	private String SerachColums="";
	private String strTableSchema=""; 
	private String strTableName="";
	private String strColumnName="";
	private String strTypeName=""; 
	private Connection Con=null;
	
	ArrayList<String> AListTables=null;
	 
	public FindTable(Connection Con)
	{
		try {
			
			this.Con=Con;
 			
		
		  } catch (Exception ex)
		  {
	            System.out.println( ex.getMessage());
		  }
	}
	
	 /**
	   * This method is used to  list all tables our daatabases.
	   * @return ArrayList  It's list  all tables from our registered database schemas. .
	   */
	 public  ArrayList ListAllTables() //throws SQLException 
	 {
		 AListTables = new ArrayList<String>();
		 String strSchemaName="";
		  try {
			Statement st = Con.createStatement();  
			
		

			
			String sql="SELECT schema_name FROM information_schema.schemata where schema_name not like ('pg_%') and schema_name not like 'information_schema'";
			
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				strSchemaName=result.getString("schema_name");
				Statement stmtTables = Con.createStatement(); 
				String SQL = "SELECT table_name FROM information_schema.tables WHERE table_schema = '"+strSchemaName+"'  ORDER BY table_name;";
				
				// System.out.println( SQL);
				ResultSet resultTables = stmtTables.executeQuery(SQL);
				
				
				while(resultTables.next()) 
				{
				AListTables.add(strSchemaName+"#"+resultTables.getString("table_name"));
			    
				}
			    
			    
			}
			
			
		  } catch (Exception ex)
		  {
	            System.out.println(  ex.getMessage());
		  }
	  
	  return AListTables;
	}
	
	 /**
	   * This method is used to   print tales.
	   * @param alist as  ArrayList to  pass tables names for printing  .
	   */
	 public void printData(ArrayList alist)
	 {
		 Iterator itr=alist.iterator();
	      while(itr.hasNext())
	        {
	          String obj = (String) itr.next();
	          System.out.println(obj);
	        }
	 }
}	 
	
