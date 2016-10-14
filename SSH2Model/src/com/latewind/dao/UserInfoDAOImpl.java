package com.latewind.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.latewind.bean.UserInfo;

public class UserInfoDAOImpl extends HibernateDaoSupport implements UserInfoDAO {

	public Boolean save(UserInfo userInfo) {
		this.getHibernateTemplate().saveOrUpdate(userInfo);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public UserInfo findUser(String userName) {
		// TODO Auto-generated method stub
		List list= this.getHibernateTemplate().find("select userInfo from UserInfo userInfo where userInfo.userName='" + userName + "'");
		System.out.println(list.size()+"userInfo");
		if (list.size()>0){
			return (UserInfo) list.get(0);	
		}else{
			return null;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.latewind.dao.UserInfoDAO#findUserByCHN(java.lang.String)
	 */
	@Override
	public UserInfo findUserByCHN(String chn) {
		// TODO Auto-generated method stub
		System.out.println("find User By CHN");
		List list=this.getHibernateTemplate().find("select userInfo from UserInfo userInfo where userInfo.chnName='"+ chn+ "'");
		
		if(list.size()>0){
			return (UserInfo)list.get(0);
		}else {
			return null;
		}
	
	}

	/* (non-Javadoc)
	 * @see com.latewind.dao.UserInfoDAO#findUserById(int)
	 */
	@Override
	public UserInfo findUserById(int id) {
		 return (UserInfo) this.getHibernateTemplate().get("com.latewind.bean.UserInfo",id);
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.latewind.dao.UserInfoDAO#listAll()
	 */
	@Override
	public List<UserInfo> listAll() {
		// TODO Auto-generated method stub
		
		return (List<UserInfo>) this.getHibernateTemplate().find("from UserInfo");
	}

}
