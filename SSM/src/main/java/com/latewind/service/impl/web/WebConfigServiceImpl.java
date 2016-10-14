package com.latewind.service.impl.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.latewind.dao.web.NavTabsMapper;
import com.latewind.pojo.web.NavTabs;
import com.latewind.service.web.IWebConfigService;
@Service("webConfigService")
public class WebConfigServiceImpl  implements IWebConfigService{
	@Resource NavTabsMapper navTabsDAO;
	@Override
	public List<NavTabs> listNavTabs() {
				return navTabsDAO.selectAllNavtabs();
	}
	

}
