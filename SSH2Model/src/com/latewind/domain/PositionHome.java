package com.latewind.domain;
// Generated 2016-5-5 21:53:57 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Position.
 * @see com.latewind.domain.Position
 * @author Hibernate Tools
 */
public class PositionHome extends HibernateDaoSupport implements PositionDAO{

	private static final Log log = LogFactory.getLog(PositionHome.class);

//	private final SessionFactory sessionFactory = getSessionFactory();

//	protected SessionFactory getSessionFactory() {
//		try {
//			return (SessionFactory) new InitialContext().lookup("SessionFactory");
//		} catch (Exception e) {
//			log.error("Could not locate SessionFactory in JNDI", e);
//			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
//		}
//	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.PostionDAO#persist(com.latewind.domain.Position)
	 */
	@Override
	public void persist(Position transientInstance) {
		log.debug("persisting Position instance");
		try {
			this.getHibernateTemplate().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.PostionDAO#attachDirty(com.latewind.domain.Position)
	 */
	@Override
	public void attachDirty(Position instance) {
		log.debug("attaching dirty Position instance");
		try {
			this.getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.PostionDAO#attachClean(com.latewind.domain.Position)
	 */
	@Override
	public void attachClean(Position instance) {
		log.debug("attaching clean Position instance");
		try {
			this.getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.PostionDAO#delete(com.latewind.domain.Position)
	 */
	@Override
	public void delete(Position persistentInstance) {
		log.debug("deleting Position instance");
		try {
			this.getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.PostionDAO#merge(com.latewind.domain.Position)
	 */
	@Override
	public Position merge(Position detachedInstance) {
		log.debug("merging Position instance");
		try {
			Position result = (Position) this.getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.PostionDAO#findById(java.lang.Integer)
	 */
	@Override
	public Position findById(java.lang.Integer id) {
		log.debug("getting Position instance with id: " + id);
		try {
			Position instance = (Position) this.getHibernateTemplate().get("com.latewind.domain.Position", id);
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
	
	
	public List<Position> listAll() {
		try{
		List<Position> results=(List<Position>) this.getHibernateTemplate().find("from Position");
		return results;
		}
		catch(RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
			
		}
	
	}
	

//	public List<Position> findByExample(Position instance) {
//		log.debug("finding Position instance by example");
//		try {
//			List<Position> results = (List<Position>) this.getHibernateTemplate()
//					.createCriteria("com.latewind.domain.Position").add(create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
}
