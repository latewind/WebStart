/**
 * 
 */
package com.latewind.action;

import java.util.Properties;

import org.apache.struts2.ServletActionContext;

import com.latewind.tools.OfficeConvert;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class FileConvertAction extends ActionSupport{
	//
	private String fileName;
	
	
	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/*
	 * 
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
	    String path=ServletActionContext.getServletContext().getRealPath("/");    
	    System.out.println(path+"upload");  
	    
		String scrPath=path+"upload\\"+fileName;
		System.out.println("转换文件名为："+fileName);
				// TODO Auto-generated method stub
				OfficeConvert.office2Swf(scrPath);
		
		return SUCCESS;
		
	}

}
