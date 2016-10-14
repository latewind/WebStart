package com.latewind.service.impl.notice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.latewind.dao.notice.AnnouncementMapper;
import com.latewind.dao.notice.HeadlineMapper;
import com.latewind.pojo.notice.Announcement;
import com.latewind.pojo.notice.Headline;
import com.latewind.service.notice.INoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements INoticeService{
@Resource
private HeadlineMapper headlineDAO;

@Resource
private AnnouncementMapper announcementDAO;
	@Override
	public Headline getHeadLine() {
		
//		headlineDAO.s
				return headlineDAO.selectCurrentHeadline();
	}
	@Override
	public List<Announcement> getAnnouncement() {
				return announcementDAO.selectCurAnnounce();
	}
	@Override
	public Integer updateHeadLine(Headline record) {
				return headlineDAO.updateByPrimaryKeySelective(record);
	}
	@Override
	public Integer backupHeadline(Headline rocord) {
				return headlineDAO.insertSelective(rocord);
	}
	@Override
	public Integer updateAnnoun(Announcement announcement) {
				return announcementDAO.updateByPrimaryKeySelective(announcement);
	}
	@Override
	public Announcement getAnnounById(Integer announId) {
				return announcementDAO.selectByPrimaryKey(announId);
	}
	
	

	
}
