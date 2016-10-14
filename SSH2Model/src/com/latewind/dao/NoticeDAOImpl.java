/**
 * 
 */
package com.latewind.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.latewind.bean.Notice;

/**
 * @author Administrator
 *
 */
public class NoticeDAOImpl extends HibernateDaoSupport implements NoticeDAO {

	/* (non-Javadoc)
	 * @see com.latewind.dao.NoticeDAO#addNotice(com.latewind.bean.Notice)
	 */
	@Override
	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub
		System.out.println("add Notice");
		this.getHibernateTemplate().save(notice);
		
	}

	/* (non-Javadoc)
	 * @see com.latewind.dao.NoticeDAO#queryAll()
	 */
	@Override
	public List<Notice> queryAll() {
		System.out.println("query All Notice");
		List list=this.getHibernateTemplate().find("from Notice");
		// TODO Auto-generated method stub
		return list;
	}

}
