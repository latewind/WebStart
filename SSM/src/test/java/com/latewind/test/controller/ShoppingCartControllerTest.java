package com.latewind.test.controller;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


public class ShoppingCartControllerTest extends com.latewind.test.base.BasicWebTest {
	
	@Test
//	@Rollback(false)//防止事务自动回滚 
	public void testAppendPrt() throws Exception{
		
		
		mvc.perform(
				MockMvcRequestBuilders.post("/front/product/searchPrtAction").param("keyword", "服装 女装"))
				.andExpect(MockMvcResultMatchers.status().isOk());
//				.andExpect(MockMvcResultMatchers.view().name("front/user/login"));
		String json="{'packs':['12','19','20','21'],'name':'李尚庆','address':'山东省莱芜市羊里镇泉子沟村','payMethod':'支付宝'}";
		
		
	}

}
