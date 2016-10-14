/**
 * 
 */
package com.latewind.domain;

import java.util.List;

import org.hibernate.SessionFactory;

/**
 * @author Administrator
 *
 */
public interface MaterialsDAO {

	SessionFactory getSessionFactory();

	void persist(Materials transientInstance);

	void attachDirty(Materials instance);

	void attachClean(Materials instance);

	void delete(Materials persistentInstance);

	Materials merge(Materials detachedInstance);

	Materials findById(java.lang.Integer id);

	List findByExample(Materials instance);
	
	List findByUserId(Integer userId);

}