package com.latewind.common.security;

public class CombineArgsContext{
	
	private static PasskeyArgsCombine passkeyArgsCombine=new NormalCombineArgs();
	public static String getResult(Integer userId, Integer Id, String salt){
		return passkeyArgsCombine.combineArgs(userId, Id, salt);
	}
	
	public static void setCombineMethod(PasskeyArgsCombine passkeyArgsCombine){
				
		CombineArgsContext.passkeyArgsCombine=passkeyArgsCombine;
		
	
	}
	
	
}