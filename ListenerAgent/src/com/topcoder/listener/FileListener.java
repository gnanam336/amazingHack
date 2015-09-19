package com.topcoder.listener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyListener;

public class FileListener
{

    public void listen() throws Exception
    {
    	Properties objProp = new Properties();
    	objProp.load(ClassLoader.getSystemResourceAsStream("FileConfig.properties"));
    	String folderPath=objProp.getProperty("ShareDrive");
    	String fileFormat=objProp.getProperty("FileFormat");
    	int noofColumns=Integer.parseInt(objProp.getProperty("NoofColumns"));
    	String columnNames=objProp.getProperty("ColumnNames");
    	String delimiter=objProp.getProperty("Delimiter");
    	
    	if(folderPath==null){
    		throw new Exception("Configure Share Drive to start processing!!!");
    	}
    	String path = folderPath;
        System.out.println("Shared Drive Path : "+ folderPath);
        int mask = JNotify.FILE_CREATED;
        boolean watchSubtree = false;
        int watchID = JNotify.addWatch(path, mask, watchSubtree, new Listener(fileFormat,noofColumns,columnNames,delimiter));

        // sleep a little, the application will exit if you
        // don't (watching is asynchronous), depending on your
        // application, this may not be required
        Thread.sleep(1000000);

        boolean res = JNotify.removeWatch(watchID);
        if (!res)
        {
            throw new Exception("Invalid watch ID specified");
        }
    }

    class Listener implements JNotifyListener
    {
    	private String fileType=null;
    	private int columnCount=0;
    	private String columnHeader=null;
    	private String delimit=null;
    	private String columns[];
    	
    	public Listener(String fileFormat, int noofColumns, String columnNames, String delimiter){
    		fileType=fileFormat;
    		columnCount=noofColumns;
    		columnHeader=columnNames;
    		delimit=delimiter;
    		if(columnHeader!=null && columnHeader.contains(",")){
    			columns = columnHeader.split(",");
    		}
    	}
    	
        public void fileRenamed(int wd, String rootPath, String oldName, String newName)
        {
        	//print("renamed " + rootPath + " : " + oldName + " -> " + newName);
        }

        public void fileModified(int wd, String rootPath, String name)
        {
        	//print("modified " + rootPath + " : " + name);
        }

        public void fileDeleted(int wd, String rootPath, String name)
        {
        	//print("deleted " + rootPath + " : " + name);
        }

        public void fileCreated(int wd, String rootPath, String name)
        {
        	Gson gson = new Gson();
        	print("created " + rootPath + " : " + name);
        	if(name!=null && name.contains("."+fileType)){
        		File objFile = null;
        		try{
        			objFile = new File(rootPath+"/"+name);
        			if(objFile!=null && objFile.canRead()){
        				BufferedReader objReader = new BufferedReader(new InputStreamReader(new FileInputStream(objFile)));
        				JsonArray files = new JsonArray();
        				while(true){
        					String tempRecord = objReader.readLine();
        					if(tempRecord==null){
	        					break;
	        				}
	        				if(tempRecord!=null && tempRecord.contains(delimit)){
	        					String[] recordData = tempRecord.split(delimit);
	        					if(recordData.length==columnCount){
	        						JavaToJSONConversion obj = new JavaToJSONConversion(recordData[0], recordData[1], recordData[2]);
	        						JsonElement jsonStr = gson.toJsonTree(obj);
	        						files.add(jsonStr);
	        					}
	        				}
        				}
        				String jsonStr = gson.toJson(files);
        				System.out.println("jsonStr--->" +jsonStr);
        			}
        		}catch(Exception e){
        			e.printStackTrace();
        		}finally{
        			if(objFile!=null){
						objFile = null;
        			}
        		}
        	}
        }

        void print(String msg) 
        {
        	System.err.println(msg);
        }
    }
}