package com.latewind.domain;
// Generated 2016-5-30 19:15:41 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Msg.
 * @see com.latewind.domain.Msg
 * @author Hibernate Tools
 */
public class MsgHome  extends HibernateDaoSupport implements MsgDAO {

	private static final Log log = LogFactory.getLog(MsgHome.class);



	public void persist(Msg transientInstance) {
		log.debug("persisting Msg instance");
		try {
			this.getHibernateTemplate().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Msg instance) {
		log.debug("attaching dirty Msg instance");
		try {
			this.getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Msg instance) {
		log.debug("attaching clean Msg instance");
		try {
			this.getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Msg persistentInstance) {
		log.debug("deleting Msg instance");
		try {
			this.getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Msg merge(Msg detachedInstance) {
		log.debug("merging Msg instance");
		try {
			Msg result = (Msg) this.getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Msg findById(int id) {
		log.debug("getting Msg instance with id: " + id);
		try {
			Msg instance = (Msg) this.getHibernateTemplate().get("com.latewind.domain.Msg", id);
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

	public List<Msg> findByExample(Msg instance) {
//		log.debug("finding Msg instance by example");
//		try {
//			List<Msg> results = (List<Msg>) this.getHibernateTemplate().createCriteria("com.latewind.domain.Msg")
//					.add(create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}

	return null;
	}
}
