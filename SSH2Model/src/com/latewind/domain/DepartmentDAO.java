/**
 * 
 */
package com.latewind.domain;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface DepartmentDAO {

	void persist(Department transientInstance);

	void attachDirty(Department instance);

	void attachClean(Department instance);

	void delete(Department persistentInstance);

	Department merge(Department detachedInstance);

	Department findById(java.lang.Integer id);
	
	Department findByName(java.lang.String name);
	 
	List<Department> listAll();
	
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