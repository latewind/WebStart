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
 * Home object for domain model class Employee.
 * @see com.latewind.domain.Employee
 * @author Hibernate Tools
 */
public class EmployeeHome extends HibernateDaoSupport implements EmployeeDAO{

	private static final Log log = LogFactory.getLog(EmployeeHome.class);

//	private final SessionFactory sessionFactory = getSessionFactory();



	/* (non-Javadoc)
	 * @see com.latewind.domain.EmployeeDAO#persist(com.latewind.domain.Employee)
	 */
	@Override
	public void persist(Employee transientInstance) {
		log.debug("persisting Employee instance");
		try {
			this.getHibernateTemplate().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.EmployeeDAO#attachDirty(com.latewind.domain.Employee)
	 */
	@Override
	public void attachDirty(Employee instance) {
		log.debug("attaching dirty Employee instance");
		try {
			this.getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.EmployeeDAO#attachClean(com.latewind.domain.Employee)
	 */
	@Override
	public void attachClean(Employee instance) {
		log.debug("attaching clean Employee instance");
		try {
			this.getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.EmployeeDAO#delete(com.latewind.domain.Employee)
	 */
	@Override
	public void delete(Employee persistentInstance) {
		log.debug("deleting Employee instance");
		try {
			this.getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.EmployeeDAO#merge(com.latewind.domain.Employee)
	 */
	@Override
	public Employee merge(Employee detachedInstance) {
		log.debug("merging Employee instance");
		try {
			Employee result = (Employee) this.getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.latewind.domain.EmployeeDAO#findById(java.lang.Integer)
	 */
	@Override
	public Employee findById(java.lang.Integer id) {
		log.debug("getting Employee instance with id: " + id);
		try {
			Employee instance = (Employee) this.getHibernateTemplate().get("com.latewind.domain.Employee", id);
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
	
	public List<Employee> listAll() {
		try{
		List<Employee> results=(List<Employee>) this.getHibernateTemplate().find("from Employee");
		return results;
		}
		catch(RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
			
		}
	
	}

//	public List<Employee> findByExample(Employee instance) {
//		log.debug("finding Employee instance by example");
//		try {
//			List<Employee> results = (List<Employee>) this.getHibernateTemplate()
//					.createCriteria("com.latewind.domain.Employee").add(create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
}
