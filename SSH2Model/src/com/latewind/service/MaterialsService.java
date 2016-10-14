/**
 * 
 */
package com.latewind.service;

import java.util.List;

import com.latewind.bean.UserInfo;
import com.latewind.domain.Materials;

/**
 * @author Administrator
 *
 */
public interface MaterialsService {

	public void addMaterials(List<Materials> l );
	public List<Materials> approveMaterials(UserInfo u);
	public void agreed2Approve(List<Integer> ids);
	public void disagree(List<Integer> ids);
	
	/**
	 * 
	 */
}
