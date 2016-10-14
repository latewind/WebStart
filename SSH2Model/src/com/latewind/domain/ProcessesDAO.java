/**
 * 
 */
package com.latewind.domain;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface ProcessesDAO {

	void persist(Processes transientInstance);

	void attachDirty(Processes instance);

	void attachClean(Processes instance);

	void delete(Processes persistentInstance);

	Processes merge(Processes detachedInstance);

	Processes findById(int id);

	List findByExample(Processes instance);
	
	List findByUserId(Integer id);

}