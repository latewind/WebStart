package com.latewind.domain;
// Generated 2016-5-13 16:11:27 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * Home object for domain model class Materials.
 * @see com.latewind.domain.Materials
 * @author Hibernate Tools
 */
public class MaterialsHome extends HibernateDaoSupport implements MaterialsDAO{

	private static final Log log = LogFactory.getLog(MaterialsHome.class);


	/* (non-Javadoc)
	 * @see com.latewind.domain.MaterialsDAO#persist(com.latewind.domain.Materials)
	 */
	@Override
	public void persist(Materials transientInstance) {
		log.debug("persisting Materials instance");
		try {
			this.getHibernateTemplate().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.MaterialsDAO#attachDirty(com.latewind.domain.Materials)
	 */
	@Override
	public void attachDirty(Materials instance) {
		log.debug("attaching dirty Materials instance");
		try {
			this.getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.MaterialsDAO#attachClean(com.latewind.domain.Materials)
	 */
	@Override
	public void attachClean(Materials instance) {
		log.debug("attaching clean Materials instance");
		try {
			this.getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.MaterialsDAO#delete(com.latewind.domain.Materials)
	 */
	@Override
	public void delete(Materials persistentInstance) {
		log.debug("deleting Materials instance");
		try {
			this.getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.MaterialsDAO#merge(com.latewind.domain.Materials)
	 */
	@Override
	public Materials merge(Materials detachedInstance) {
		log.debug("merging Materials instance");
		try {
			Materials result = (Materials) this.getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.MaterialsDAO#findById(java.lang.Integer)
	 */
	@Override
	public Materials findById(java.lang.Integer id) {
		log.debug("getting Materials instance with id: " + id);
		try {
			Materials instance = (Materials) this.getHibernateTemplate().get("com.latewind.domain.Materials",
					id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.MaterialsDAO#findByExample(com.latewind.domain.Materials)
	 */
	@Override
	public List findByExample(Materials instance) {
		log.debug("finding Materials instance by example");
		try {
			List results = this.getHibernateTemplate().findByExample(instance);
	
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public List findByUserId(Integer userId) {
		
		List list=this.getHibernateTemplate().find("select materials from Materials materials where materials.userinfoId= '" +userId+ "'" );
		// TODO Auto-generated method stub
		return list;
	}
}
