/**
 * 
 */
package com.latewind.domain;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface PositionDAO {

	void persist(Position transientInstance);

	void attachDirty(Position instance);

	void attachClean(Position instance);

	void delete(Position persistentInstance);

	Position merge(Position detachedInstance);

	Position findById(java.lang.Integer id);
	
	List<Position> listAll();

}