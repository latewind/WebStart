package com.latewind.service.notice;

import java.util.List;

import com.latewind.pojo.notice.Announcement;
import com.latewind.pojo.notice.Headline;

public interface INoticeService {
	
	/**
	 * get current headline
	 * @return
	 */
	Headline getHeadLine();
	
	Integer backupHeadline(Headline rocord);
	
	
	Announcement getAnnounById(Integer id);
	Integer updateAnnoun(Announcement announcement);
	
	Integer updateHeadLine(Headline record);
	
	List<Announcement> getAnnouncement();

}
