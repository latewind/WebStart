/**
 * 
 */
package com.latewind.domain;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface MsgDAO {

	void persist(Msg transientInstance);

	void attachDirty(Msg instance);

	void attachClean(Msg instance);

	void delete(Msg persistentInstance);

	Msg merge(Msg detachedInstance);

	Msg findById(int id);

	List<Msg> findByExample(Msg instance);

}