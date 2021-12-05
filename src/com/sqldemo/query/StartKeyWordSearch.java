package com.sqldemo.query;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import com.sqldemo.db.*;


/**
* This program is  used to  perform keyword search in  our registered databases and  return results as per the format.
* @author  Geethan kuriakose,geethankuriakose@gmail.com
* @version 0.1
* @since 4-12-2021
*/

public class StartKeyWordSearch {
	
	static ArrayList AListDrivers=null;
	static ArrayList AListDbinfo=null;
	static ArrayList<String> AListTables=null;
	static ArrayList AListSQL=null;
	static ArrayList<String> AListSearchResults=null;
	static Connection Con=null;
	
	/**
	   * This method is used to  generate  keyword search results from our  registered databases ..
	  
	   */
	public void getKeyWordSearchResults(String SearchKey)
	{
		
		 //String SearchKey="nintedanib";
		 RegisterDBs objRegisterDBs= new RegisterDBs();
		 AListDbinfo=objRegisterDBs.getAllDBS();
		 RegisterDBPojo objRegisterDBPojo= null;
		try {
			 for (int i=0;i<AListDbinfo.size();i++)
			 {
				
				 //Load Driver and database
				 objRegisterDBPojo=(RegisterDBPojo)AListDbinfo.get(i);
				 String strDriverURL=objRegisterDBPojo.getDriverURL()+"://"+objRegisterDBPojo.getServerIP()+":"+objRegisterDBPojo.getDriverPort()+"/"+objRegisterDBPojo.getDBName();
				 //System.out.println(strDriverURL);
				 
				 
				 //open the registered database.
				 DbConnect objDbConnect = new DbConnect();
				 Con=objDbConnect.OpenDatabase(objRegisterDBPojo.getDriverName(),strDriverURL, objRegisterDBPojo.getUserName(), objRegisterDBPojo.getPassword());
				
				 
				 
				//List tables from registered database 
				 FindTable objFindTable = new FindTable(Con);
				 AListTables = new ArrayList<String>();
				 AListTables=objFindTable.ListAllTables();
				 //printArrayListData(AListTables);
				 
				 
				 //Generate Search SQL
				 SearchSQL objGetSearchSQL = new SearchSQL(AListTables,SearchKey,Con);
				 AListSQL = new ArrayList ();
				 AListSQL=objGetSearchSQL.getSearchSQL();
				// printArrayListData(AListSQL);
				 
				 //Execute  Search SQL
				 SearchResults objSearchResults = new SearchResults(AListSQL, Con,objRegisterDBPojo.getDBName());
				 AListSearchResults = new ArrayList<String>();
				 AListSearchResults=objSearchResults.getSearchResults();
				 printArrayListData(AListSearchResults);
				 
				 Con.close();
			 
			 }
		  } catch (Exception ex)
		  {
	            System.out.println( ex.getMessage());
		  }
		
	}
	
	
	/**
	   * This method is used to  print search results
	   *@param  alist as ArrayList to list search results
	   */
	 public static void printArrayListData(ArrayList alist)
	 {
		 Iterator itr=alist.iterator();
	      while(itr.hasNext())
	        {
	          String obj = (String) itr.next();
	          System.out.println(obj);
	        }
	 }
	 /**
	  * 
	  * 
	  * main method
	  */
	 
	 public static void main(String [] args) 
		{
		 
		 	StartKeyWordSearch objStartKeyWordSearch= new StartKeyWordSearch();
		 	objStartKeyWordSearch.getKeyWordSearchResults("nintedanib");//Search Keyword
		}

}


