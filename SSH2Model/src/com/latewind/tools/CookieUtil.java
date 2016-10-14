/**
 * 
 */
package com.latewind.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**
 * @author Administrator
 *
 */
public class CookieUtil {
	
	/**
     * Cookie��׷��
     * @return
     * @throws Exception
     */
    public  static void addCookie(String name,String value){
    	try {
			value=URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60*60*24*365);
        ServletActionContext.getResponse().addCookie(cookie);
    }
    /**
     * Cookie��ȡ��
     * @return
     * @throws Exception
     */
    public  static String getCookie(String name){
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();
        if(cookies==null) return null;
        for(Cookie cookie : cookies)
        {
            if(cookie.getName().equals(name))
            {	
            	String value=cookie.getValue();
            	try {
					value=URLDecoder.decode(value, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					
					e.printStackTrace();
				}
                return value;
            }
        }
        return null;
    }
    /**
     * ɾ��Cookie 
     * @param name
     */
    public static void delCookie(String name){
    	
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies)
        {
        	if(cookie.getName().equals(name))
            {
               cookie.setMaxAge(0);
               ServletActionContext.getResponse().addCookie(cookie);
               return ;
            }
        }
    	
    	
    }
    

}
