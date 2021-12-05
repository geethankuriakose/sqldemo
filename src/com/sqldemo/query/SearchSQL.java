
package com.sqldemo.query;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.sqldemo.db.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
* This program is  used to  generate an  executable queries for our  keyword search.
* @author  Geethan kuriakose,geethankuriakose@gmail.com
* @version 0.1
* @since 4-12-2021
*/


public class SearchSQL
{
	private String StrCondtions="";  
	private String SearchKey="";
	private String SerachColums="";
	private String strTableSchema=""; 
	private String strTableName="";
	private String strColumnName="";
	private String strTypeName=""; 
	private Connection Con=null;
	private ArrayList<String> AListSQL=null ;
	private ArrayList<String> AListTables=null ;
	HashMap<String,String> objMap = new HashMap<String,String>();
	
	public SearchSQL(ArrayList AListTables,String SearchKey,Connection Con)
	{
		
		this.SearchKey=SearchKey;
		this.AListTables=AListTables;
		try {
			this.Con=Con;
 			
			
		  } catch (Exception ex)
		  {
	            System.out.println( ex.getMessage());
		  }
		
	}
	
	/**
	   * This method is used to  generate executable queries for our keyword search.
	   * @return ArrayList    returns List of executable Search SQL for keyword search
	   */
	
	 public  ArrayList getSearchSQL() throws SQLException 
	 {
	  return getSearchMetadata_SQL(AListTables,SearchKey);
	}
	
	 /**
	   * This method is used to  generate executable queries for our keyword search.
	   * @param AListTables  List of tables from our current database
	   * @param SearchKey    Keyword for Search SQL
	   * @return ArrayList    returns List of executable Search SQL for keyword search
	   */
	 
	 public  ArrayList getSearchMetadata_SQL(ArrayList AListTables,String SearchKey) throws SQLException 
	 {
		  AListSQL = new ArrayList<String>();
		  try {
	 		  Iterator itr=AListTables.iterator();
		      while(itr.hasNext())
		        {
		          String strTable = (String) itr.next();
		          //System.out.println( "strTable"+strTable);
		          
		          String[] arrOfStr = strTable.split("#");
		          
		          DatabaseMetaData meta = Con.getMetaData();
				  ResultSet res = meta.getColumns(null, null, arrOfStr[1], null);  
				  resetValues();
				  while (res.next()) 
				    {
						   strTableSchema=res.getString("TABLE_SCHEM");
				    	   strTableName=res.getString("TABLE_NAME");
				    	   strColumnName=res.getString("COLUMN_NAME");
				    	   strTypeName=res.getString("TYPE_NAME");
				       if (strTypeName.trim().equals("text"))
				       { 	 StrCondtions+= strColumnName +"='"+SearchKey+"'"+ "  or ";
				       
				       		SerachColums+=strColumnName+",";
				       }
				    }
				  
				    SerachColums=SerachColums.substring(0,SerachColums.length()-1);
				    StrCondtions=StrCondtions.substring(0,StrCondtions.length()-3);
				    String SQL=arrOfStr[0]+"."+arrOfStr[1]+"#"+"select row_number() over(),"+SerachColums +" from "+arrOfStr[0]+"."+arrOfStr[1]+ " where " + StrCondtions;
				    
				  
				    AListSQL.add(SQL);
				
				    
				    
		        }
		  } catch (Exception ex)
		  {
	            System.out.println( ex.getMessage());
		  }
		
		  
		  
	  
	  return AListSQL;
	}
	
    private void resetValues()
    {
    	StrCondtions="";  
    	SerachColums="";
    	strTableSchema=""; 
    	strTableName="";
    	strColumnName="";
    	strTypeName=""; 
    }
    
}	 
	