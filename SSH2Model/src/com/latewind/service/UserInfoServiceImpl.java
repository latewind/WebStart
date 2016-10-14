package com.latewind.service;

import com.latewind.bean.UserInfo;
import com.latewind.dao.UserInfoDAO;
import com.latewind.dao.UserInfoDAOImpl;

public class UserInfoServiceImpl implements UserInfoService {
private UserInfoDAO userInfoDAO;
	@Override
	//ÊÇ·ñÕýÈ·
	public String isRight(String userName,String password) {
		// TODO Auto-generated method stub
		UserInfo u=	userInfoDAO.findUser(userName);
		if (u==null) {
			return "SPACE";
		}
		else if(u.getPassword().equals(password)){
			return u.getChnName();
			
		}
		return "NO";
	}
	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}
	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
	/* (non-Javadoc)
	 * @see com.latewind.service.UserInfoService#addUser(com.latewind.bean.UserInfo)
	 */
	@Override
	public Boolean addUser(UserInfo u) {
		// TODO Auto-generated method stub
		return userInfoDAO.save(u);
	}
	/* (non-Javadoc)
	 * @see com.latewind.service.UserInfoService#findUser(java.lang.String)
	 */
	@Override
	public UserInfo findUser(String chn) {
		// TODO Auto-generated method stub
		return userInfoDAO.findUserByCHN(chn);
	}
	/* (non-Javadoc)
	 * @see com.latewind.service.UserInfoService#findByAccount(java.lang.String)
	 */
	@Override
	public UserInfo findByAccount(String account) {
		// TODO Auto-generated method stub
		return userInfoDAO.findUser(account);
	}
	/* (non-Javadoc)
	 * @see com.latewind.service.UserInfoService#findUserById(int)
	 */
	@Override
	public UserInfo findUserById(int id) {
		// TODO Auto-generated method stub
		return userInfoDAO.findUserById(id);
	}


}
