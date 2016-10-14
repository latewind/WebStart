package com.latewind.controller.admin.notice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.latewind.common.constants.CommonConstants;
import com.latewind.pojo.ThirdCategory;
import com.latewind.pojo.notice.Announcement;
import com.latewind.pojo.notice.Headline;
import com.latewind.pojo.product.ProductInfo;
import com.latewind.service.category.IThirdCategoryService;
import com.latewind.service.notice.INoticeService;
import com.latewind.service.product.IProductService;

@Controller
public class NoticeManagerController {

	@Resource
	private IProductService productService;

	@Resource
	INoticeService noticeService;

	@Resource
	private IThirdCategoryService thirdCategoryService;

	Logger logger = Logger.getLogger(NoticeManagerController.class);

	/**
	 * 
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping("/admin/notice/updateHeadline.html")
	public String updateHeadlinePage(Model model) {
		// 获取头条信息
		Headline headline = noticeService.getHeadLine();
		model.addAttribute("headline", headline);
		return "admin/notice/updateHeadline";
	}

	@RequestMapping("/admin/notice/updateHeadlineAction")
	public String updateHeadlineAction(HttpServletRequest request, String title, String pageLink, String content)
			throws IOException, CloneNotSupportedException {
		// 获取路径

		Headline headline = noticeService.getHeadLine();
		// 备份原头条
		Headline backup = (Headline) headline.clone();
		backup.setHeadlineId(null);
		backup.setShowStatus(0);
		noticeService.backupHeadline(backup);
		// 更新消息

		headline.setTitle(title);
		headline.setPageLink(pageLink);
		headline.setContent(content);
		headline.setDisplayTime(new Date());
		noticeService.updateHeadLine(headline);
		logger.info("addProcut");
		return "redirect:/admin/notice/updateHeadline.html";
	}

	@RequestMapping("/admin/notice/updateAnnoun.html")
	public String updateAnnounPage(Model model) {

		// 获取公告
		List<Announcement> anno = noticeService.getAnnouncement();
		model.addAttribute("anList", anno);

		return "admin/notice/updateAnnoun";
	}

	@ResponseBody
	@RequestMapping("/admin/ajax/notice/updateAnnounAction")
	public String updateAnnounAction(Model model,Integer id,String title,String link) {

		
		logger.info(id+title+link);
		
		Announcement announcement=noticeService.getAnnounById(id);
		announcement.setAnnounTitle(title);
		announcement.setAnnounAnchor(link);
		announcement.setAnnounTime(new Date());
	
		noticeService.updateAnnoun(announcement);
		// 获取公告
		// List<Announcement> anno = noticeService.getAnnouncement();
		// model.addAttribute("anList", anno);

		logger.info(" update  Announcement Action");
		return "success";
	}

	

}
