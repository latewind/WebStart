/**
 * 
 */
package com.latewind.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.latewind.dao.CityDAO;
import com.latewind.test.Test;
import com.opensymphony.xwork2.ActionSupport;  

public class HelloWorld extends ActionSupport  
{  
	private Test t;
    public final static String MESSAGE = "Struts2 is up and running ...";  
    private CityDAO cityDAO;
    private String message;  
	public Test getT() {
   
		return t;
	}


	public CityDAO getCityDAO() {
		return cityDAO;
	}


	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}


	public void setT(Test t) {
		this.t = t;
		System.out.println("set T in Action hello");
//		t.show();
	}


	/** 
     * @return the message 
     */  
    public String getMessage()  
    { 	
        return message;  
    }  
  
  
    /** 
     * @param message the message to set 
     */  
    public void setMessage(String message)  
    {  
        this.message = message;  
    }  
  
  
    public String execute() throws Exception  
    { 
    	if(t==null){
    		System.out.println("t is null");
    	}else{
    		t.show();
    	}
   
    	cityDAO.queryById(1);
    	System.out.println("execute");
        setMessage(MESSAGE); 
 
        return SUCCESS;  
    }  
}  