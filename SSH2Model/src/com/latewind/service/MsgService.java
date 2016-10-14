/**
 * 
 */
package com.latewind.service;

import com.latewind.domain.Msg;

/**
 * @author Administrator
 *
 */
public interface MsgService {
	
	public void saveOrUpdateMsg(Msg msg);
	public Msg findMsgById(Integer id);
//	public void saveMsg(Msg msg);
	public void merge(Msg msg);
	public void sendMsg2All(Msg msg);
//	public void findBy
}
