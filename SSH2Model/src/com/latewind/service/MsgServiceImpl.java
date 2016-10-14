/**
 * 
 */
package com.latewind.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.latewind.bean.UserInfo;
import com.latewind.dao.UserInfoDAO;
import com.latewind.domain.Msg;
import com.latewind.domain.MsgDAO;

/**
 * @author Administrator
 *
 */
public class MsgServiceImpl implements MsgService {
	private MsgDAO  msgDAO;
	private UserInfoDAO userInfoDAO;
	/* (non-Javadoc)
	 * @see com.latewind.service.MsgService#saveOrUpdateMsg(com.latewind.domain.Msg)
	 */
	@Override
	public void saveOrUpdateMsg(Msg msg) {
		// TODO Auto-generated method stub

		msgDAO.attachDirty(msg);
		
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.MsgService#findMsgById(java.lang.Integer)
	 */
	@Override
	public Msg findMsgById(Integer id) {
		return msgDAO.findById(id);
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see com.latewind.service.MsgService#saveMsg(com.latewind.domain.Msg)
	 */
	@Override
//	public void saveMsg(Msg msg) {
//		// TODO Auto-generated method stub
//		msgDAO.persist(msg);
////		msgDAO.merge(msg);
//		
//	}
	public void merge(Msg msg){
		
		msgDAO.merge(msg);
	}
	
	/**
	 * @return the userInfoDAO
	 */
	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}
	/**
	 * @param userInfoDAO the userInfoDAO to set
	 */
	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
	public MsgDAO getMsgDAO() {
		return msgDAO;
	}
	public void setMsgDAO(MsgDAO msgDAO) {
		this.msgDAO = msgDAO;
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.MsgService#sendMsg2All()
	 */
	@Override
	public void sendMsg2All(Msg msg) {
		// TODO Auto-generated method stub
		Set<UserInfo> set=new HashSet<>(userInfoDAO.listAll());
		msg.setReceivers(set);
		msgDAO.merge(msg);
	}
	

}
