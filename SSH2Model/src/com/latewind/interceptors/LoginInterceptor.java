package com.latewind.interceptors;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.eclipse.jdt.internal.compiler.ast.Invocation;

import com.latewind.bean.UserInfo;
import com.latewind.common.ConstantValue;
import com.latewind.tools.FileUtil;
import com.latewind.tools.XMLUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	private static HashMap<String,String> limitMap=new HashMap<String,String>();
	//��ʼ����
	static{
		//��ȡ�����ļ�·��
		String xmlPath=FileUtil.getWEBINFPath()+ConstantValue.PRIVILEGE_HOME;
		System.out.println("xmlPath"+xmlPath);
	
		try {
			//��·��ת��Ϊurl
			URL url=new File(xmlPath).toURL();
			Document document=XMLUtil.parse(url);//����xml
		    Element root = document.getRootElement();
	        // iterate through child elements of root
	        for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
	            Element element = (Element) i.next();
	            String attString=element.attributeValue("class");
	            String childText=element.getStringValue();
	            limitMap.put(attString,childText);//��ֵ���뵽Map��
	            System.out.println(element.getName()+"--- "+attString+"--"+childText); 	            
	            // do something
	        }

			
		} catch (MalformedURLException | DocumentException e) {
			
			e.printStackTrace();
		}
		
		
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//��ȡsession
		Map session=ActionContext.getContext().getSession();	
		UserInfo userSession=(UserInfo) session.get("userInfo");
		System.out.println(userSession);
		System.out.println("ȫ��������");

		
		if(userSession==null){
			System.out.println("userSession is null  Interceptor success");
			return  invocation.invoke();
			//return Action.LOGIN;
		}else{
			/**
			 * 
			 * �������Ȩ������
			 * 
			 */
			Object action=invocation.getAction();
			String actionName=action.getClass().getName();
			System.out.println("action name:"+actionName);
			String authority=limitMap.get(actionName);
			System.out.println("Ȩ����"+authority);
			String limter=userSession.getOpLimit();
			System.out.println("�û�Ȩ����"+limter);
			if(authority!=null&&!authority.contains(limter)){//����������Ȩ��,���ص�ҳ��
				return "unavaiable";
				
			}
		
//			File limitor=new File("WEV-I/limitor.xml");
//			if(!limitor.exists()){
//				limitor.createNewFile();
//				
//			} 
			return  invocation.invoke();
		}
		
	
	}

}
