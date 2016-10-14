/**
 * 
 */
package com.latewind.service;

import java.util.List;

import com.latewind.bean.Notice;
import com.latewind.dao.NoticeDAO;

/**
 * @author Administrator
 *
 */
public class NoticeServiceImpl implements NoticeService {

	private NoticeDAO noticeDAO;
	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.NoticeService#addNotice(com.latewind.bean.Notice)
	 */
	@Override
	public void addNotice(Notice notice) {
		noticeDAO.addNotice(notice);
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.NoticeService#queryAll()
	 */
	@Override
	public List queryAll() {
	
		// TODO Auto-generated method stub
		return noticeDAO.queryAll();
	}

}
