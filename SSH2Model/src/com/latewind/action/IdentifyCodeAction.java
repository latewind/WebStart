package com.latewind.action;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Vector;

import com.latewind.tools.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IdentifyCodeAction extends ActionSupport{
	 //Í¼Æ¬Á÷  
    private ByteArrayInputStream imageStream;  
    //sessionÓò  
    private String randomCode ;  
    
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}


	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

	public String execute(){
		IdentifyCode ic=new IdentifyCode();	
		Vector<Object> vector=ic.CreateImage("n");
		String  random=(String) vector.get(0);
		System.out.println(random);
		randomCode=random;
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("IdentifyCode",random);	
		imageStream=(ByteArrayInputStream) vector.get(1);
		System.out.println("IdentifyCode in action");
		return SUCCESS;
		
	}
}
