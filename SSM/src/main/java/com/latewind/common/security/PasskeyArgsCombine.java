package com.latewind.common.security;

import com.latewind.service.impl.category.ThirdCategoryServiceImpl;

public interface PasskeyArgsCombine {

	public String combineArgs(Integer userId,Integer Id,String salt);
	
	
}


class NormalCombineArgs implements PasskeyArgsCombine{

	@Override
	public String combineArgs(Integer userId, Integer Id, String salt) {
		//  Auto-generated method stub
		return userId+Id+salt;
	}
}

class ExtendCombineArgs implements PasskeyArgsCombine{

	@Override
	public String combineArgs(Integer userId, Integer Id, String salt) {
		//  Auto-generated method stub
		return userId+Id+salt+"1234567890";
	}
}
