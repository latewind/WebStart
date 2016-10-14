/**
 * 
 */
package com.latewind.struts2.convertor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/**
 * @author Administrator
 *
 */
public class DateTimeConvertor extends DefaultTypeConverter{
	private DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	public Object convertValue(Map context,Object value,Class toType){
		
		return null;
	}

}
