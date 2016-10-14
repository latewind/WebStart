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
 * Home object for domain model class Department.
 * @see com.latewind.domain.Department
 * @author Hibernate Tools
 */
public class DepartmentHome extends HibernateDaoSupport implements DepartmentDAO{

	private static final Log log = LogFactory.getLog(DepartmentHome.class);


	/* (non-Javadoc)
	 * @see com.latewind.domain.DepartmentDAO#persist(com.latewind.domain.Department)
	 */
	@Override
	public void persist(Department transientInstance) {
		log.debug("persisting Department instance");
		try {
			this.getHibernateTemplate().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.DepartmentDAO#attachDirty(com.latewind.domain.Department)
	 */
	@Override
	public void attachDirty(Department instance) {
		log.debug("attaching dirty Department instance");
		try {
			this.getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.DepartmentDAO#attachClean(com.latewind.domain.Department)
	 */
	@Override
	public void attachClean(Department instance) {
		log.debug("attaching clean Department instance");
		try {
			this.getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.DepartmentDAO#delete(com.latewind.domain.Department)
	 */
	@Override
	public void delete(Department persistentInstance) {
		log.debug("deleting Department instance");
		try {
			this.getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.DepartmentDAO#merge(com.latewind.domain.Department)
	 */
	@Override
	public Department merge(Department detachedInstance) {
		log.debug("merging Department instance");
		try {
			Department result = (Department) this.getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.DepartmentDAO#findById(java.lang.Integer)
	 */
	@Override
	public Department findById(java.lang.Integer id) {
		log.debug("getting Department instance with id: " + id);
		try {
			Department instance = (Department) this.getHibernateTemplate().get("com.latewind.domain.Department",
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
	
	public List<Department> listAll() {
		try{
		List<Department> results=(List<Department>) this.getHibernateTemplate().find("from Department");
		return results;
		}
		catch(RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
			
		}
	
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.DepartmentDAO#findByName(java.lang.String)
	 */
	@Override
	public Department findByName(String name) {
		// TODO Auto-generated method stub
		List<?> list= this.getHibernateTemplate().find("select department from Department department where department.name='" + name + "'");
		
		return (Department) list.get(0);
	}
	
/*
	public List<Department> findByExample(Department instance) {
		log.debug("finding Department instance by example");
		try {
			List<Department> results = (List<Department>) this.getHibernateTemplate()
					.createCriteria("com.latewind.domain.Department").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	*/
}
