
package com.sqldemo.query;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sqldemo.db.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
* This program is  used to  execute search queries and  generate  search results as per the prescribed format
* @author  Geethan kuriakose,geethankuriakose@gmail.com
* @version 0.1
* @since 4-12-2021
*/

public class SearchResults
{
	private String StrCondtions="";  
	private String SearchKey="";
	private String SerachColums="";
	private String strTableSchema=""; 
	private String strTableName="";
	private String strColumnName="";
	private String strTypeName=""; 
	private String strDBName="";
	private Connection Con=null;
	private ArrayList<String> AListSQL=null ;
	private ArrayList<String> AListSearchResults=null ;
	 
	
	public SearchResults(ArrayList AListSQL,Connection Con,String strDBName)
	{
		
		
		this.AListSQL=AListSQL;
		this.strDBName=strDBName;
		try {
			this.Con=Con;
 		  } catch (Exception ex)
		  {
	            System.out.println( ex.getMessage());
		  }
		
	}
	 /**
	   * This method is used to  generate search results .
	   * @return ArrayList    returns arrayList as  keyword search results
	   */
	 public  ArrayList getSearchResults() throws SQLException 
	 {
	  return GetSearchResult(AListSQL);
	}
	
	 /**
	   * This method is used to  generate search results .
	   * @return ArrayList    returns arrayList as  keyword search results
	   */
	 
	
    private ArrayList GetSearchResult(ArrayList AListSQL)
    {
    	AListSearchResults = new ArrayList<String>();
    	int numberOfColumns=0;
    	String strRecord="";
    	 try {
    		 
    		 
    		 Iterator itr=AListSQL.iterator();
    		  
   	      	 while(itr.hasNext())
   	         {
   	          String strSQL = (String) itr.next();
   	          
   	          String[] arrOfStr = strSQL.split("#");
   	          
   	          Statement stmt = Con.createStatement();  
   	          
    	      ResultSet rs = stmt.executeQuery(arrOfStr[1]);
    	      ResultSetMetaData rsmd = rs.getMetaData();
         	 // System.out.println(rsmd.getTableName(1));  
         	  
         	  numberOfColumns= rsmd.getColumnCount();
         	 String strTableLabel="DBName#TableName#"; 
         	
         	 for(int k = 1; k<=rsmd.getColumnCount(); k++) 
         	 {
         		strTableLabel+=rsmd.getColumnName(k)+"#";
              }
         	 AListSearchResults.add(strTableLabel);
         	
    	      
    	      while (rs.next()) {
    	          for (int i = 1; i <=numberOfColumns; i++) {
    	        	  
    	        	
    	          
    	            String columnValue = rs.getString(i);
    	            
    	            strRecord+=columnValue+"#";
    	            
    	          }
    	          AListSearchResults.add(strDBName+"#"+arrOfStr[0]+"#"+strRecord);
    	          strRecord="";
    	        }
    	      
    	      rs.close();
    	      stmt.close();
    	      numberOfColumns=0;
   	       }  
    	      
 		  } catch (Exception ex)
 		  {
 	            System.out.println( ex.getMessage());
 		  }
    	 return AListSearchResults;
    }
    
}	 
	