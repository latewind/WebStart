package com.latewind.common.tools;

public class SecurityOperator {
	/**
	 * 加盐
	 * @param password
	 * @return
	 */
	public static String saltingPassword(String password){
		
		
		return password;
	}
	
	
	
	
	
	public static boolean sql_inj(String str)
	{

	String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";

	String inj_stra[] = inj_str.split("|");

	for (int i=0 ; i< inj_stra.length ; i++ )
	{
	if (str.indexOf(inj_stra[i])>=0)
	{
	return true;
	}
	}
	return false;

	}

}
