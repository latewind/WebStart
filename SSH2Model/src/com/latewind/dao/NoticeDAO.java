/**
 * 
 */
package com.latewind.dao;

import java.util.List;

import com.latewind.bean.Notice;

/**
 * @author Administrator
 *
 */
public interface NoticeDAO {
	public void addNotice(Notice notice);
	public List<Notice> queryAll();

}
