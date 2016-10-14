/**
 * 
 */
package com.latewind.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.latewind.tools.FileUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class NoticeAction extends ActionSupport{
	private Map<String, String> notices;
	public String execute(){
		
		//��ȡ·��
	    String path=ServletActionContext.getServletContext().getRealPath("/");    
	    System.out.println(path+"upload"); 
	    Properties properties=new Properties();
	    try {
			properties.load(new FileInputStream(new File(path+"upload\\"+"filelist.properties")));
			
			System.out.println("properties size ="+properties.size());
			//ǿ��ת����Map����
			notices=new HashMap<String,String>((Map)properties);
			System.out.println("notices size="+notices.size());
			;
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    //�����Է��õ�notices
       
		System.out.println("NoticeAction  map size="+notices.size());
		
		
		
		return SUCCESS;
	}
	public Map<String, String> getNotices() {
		return notices;
	}
	public void setNotices(Map<String, String> notices) {
		this.notices = notices;
	}
	
	
}
