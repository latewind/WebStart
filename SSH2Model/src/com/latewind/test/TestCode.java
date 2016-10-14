package com.latewind.test;

import org.apache.log4j.DailyRollingFileAppender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.latewind.domain.DepartmentDAO;
import com.latewind.domain.DepartmentHome;

public class TestCode {
private String m;
public String getM() {
	return m;
}

public void setM(String m) {
	this.m = m;
}
private Test   t;

public Test getT() {
	return t;
}

public void setT(Test t) {
	this.t = t;
	System.out.println("set  T in  TestCode");
}
public void showM(){
	System.out.println(m);
	t.show();
	
}
public static void main(String args[]){
	System.out.println("12313");
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml"); TestCode obj = (TestCode) context.getBean("testCode");
			obj.showM();
		
		
			
}
	

}
