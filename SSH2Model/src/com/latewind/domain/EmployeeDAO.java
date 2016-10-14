/**
 * 
 */
package com.latewind.domain;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface EmployeeDAO {

	void persist(Employee transientInstance);

	void attachDirty(Employee instance);

	void attachClean(Employee instance);

	void delete(Employee persistentInstance);

	Employee merge(Employee detachedInstance);

	Employee findById(java.lang.Integer id);
	
	List<Employee> listAll();

}