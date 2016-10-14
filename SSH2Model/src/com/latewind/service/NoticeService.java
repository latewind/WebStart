/**
 * 
 */
package com.latewind.service;

import java.util.List;

import com.latewind.bean.Notice;

/**
 * @author Administrator
 *
 */
public interface NoticeService {
	
	public void addNotice(Notice notice);
	public List queryAll();
}
