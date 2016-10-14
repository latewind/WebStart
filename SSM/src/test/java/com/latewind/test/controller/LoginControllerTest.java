package com.latewind.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.HandlerAdapter;

import com.graphbuilder.struc.LinkedList;

public class LoginControllerTest extends com.latewind.test.base.BasicWebTest {

	@Test
	public void loginLink() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.post("/front/user/login.html"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("front/user/login"));
		
	}
}
