/**
 * 
 */
package com.latewind.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.latewind.bean.UserInfo;
import com.latewind.domain.Department;
import com.latewind.domain.Employee;
import com.latewind.domain.Position;
import com.latewind.service.HRService;
import com.latewind.test.Userinfo;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

/**
 * @author Administrator
 *
 */
public class HRManAction extends ActionSupport {

private HRService hrService;
private Map<String, List<String>> dataMap=new HashMap<String, List<String>>();
private String searchType;
private String searchCnt;
private Map<String,String> employData=new HashMap<String,String>();	
private List<HashMap<String, String>> positionsTree= new ArrayList<HashMap<String,String>>();
private Object[] objects=new  Object[2];
private Integer id;
private String account;
private String password;
private String repassword;
private Integer departId;

private String promptMsg;
public String loadDP(){		
	
		List<Department> departments=hrService.listAllDepartment();
		for(Department d:departments){
			//获取部门下面所有职位
			Set<Position> pSet=d.getPositions();
			List<String> list=new LinkedList<String>();//new list 存放职位名
			for(Position position:pSet){
				list.add(position.getName());
			}
			dataMap.put(d.getName(), list);
			
		}
		System.out.println(dataMap.size());
		return SUCCESS;
	}
	/**
	 * 根据 搜搜内容加载员工信息
	 * @return
	 */
	public String loadEmp(){
		
		System.out.println(searchCnt+searchType);
		if(searchType.equals("id")){
			Integer id=Integer.valueOf(searchCnt);
			Employee e=hrService.findEmployee(id);
			System.out.println(e.getAddress());
			employData.put("empId", e.getId().toString());
			employData.put("name", e.getName());
			employData.put("sex", e.getSex());
			
			employData.put("age", e.getAge().toString());
			employData.put("college", e.getCollege());
			employData.put("education", e.getEducation());
			employData.put("telephone", e.getTelephone());
			employData.put("idcode", e.getIdcode());
			employData.put("address", e.getAddress());
			employData.put("department", e.getPosition().getDepartment().getName());
			employData.put("position", e.getPosition().getName());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
			employData.put("entrytime", sdf.format(e.getEntrytime()));
			employData.put("introduction", e.getIntroduction());		
		}
	//	employData.add(new Employee());
		
			
		return "LOAD";
	}
	/**
	 * 申请账号
	 * 
	 * @return
	 */
	public String appAccount(){
		if (!repassword.equals(password)) {
			promptMsg="密码不一致";
			return "appsuccess";
			
		}
		UserInfo userInfo=new UserInfo();
		userInfo.setUserName(account);
		userInfo.setPassword(repassword);
		promptMsg=hrService.addAccount(userInfo, id);
		return "appsuccess";
	}
	public String organChart(){
		

		
	
		System.out.println(departId+"next");
		List<Department> departments=hrService.listAllDepartment();
		Integer sizes=departments.size();
		
		Department d=departments.get(departId%sizes);
		Set<Position> pSet=d.getPositions();
		Iterator<Position> i=pSet.iterator();
		while(i.hasNext()){
			Map m=new HashMap<String,String>();
			Position p=i.next();
			Integer id=p.getPositionId();
			String posname=p.getName();
			String parent=null;
			if(p.getSuperior()==null){
				
			}else{
				parent=String.valueOf(p.getSuperior().getPositionId());
			}
		
			m.put("id",String.valueOf(id));
			m.put("name",posname);
			m.put("parent",parent);
			positionsTree.add((HashMap<String, String>) m);
			objects[0]=d.getName();
			objects[1]=positionsTree;
			// test
			
//			
			
			
			
			//
			
		}
		
		return SUCCESS;
	}

	public HRService getHrService() {
		return hrService;
	}

	public void setHrService(HRService hrService) {
		this.hrService = hrService;
	}

	public Map<String, List<String>> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, List<String>> dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 * @return the searchCnt
	 */
	public String getSearchCnt() {
		return searchCnt;
	}

	/**
	 * @param searchCnt the searchCnt to set
	 */
	public void setSearchCnt(String searchCnt) {
		this.searchCnt = searchCnt;
	}

	/**
	 * @return the searchType
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	/**
	 * @return the employData
	 */
	public Map<String, String> getEmployData() {
		return employData;
	}
	public void setEmployData(Map<String, String> employData) {
		this.employData = employData;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	/**
	 * @return the promptMsg
	 */
	public String getPromptMsg() {
		return promptMsg;
	}
	/**
	 * @param promptMsg the promptMsg to set
	 */
	public void setPromptMsg(String promptMsg) {
		this.promptMsg = promptMsg;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the positionsTree
	 */
	public List<HashMap<String, String>> getPositionsTree() {
		return positionsTree;
	}
	/**
	 * @param positionsTree the positionsTree to set
	 */
	public void setPositionsTree(List<HashMap<String, String>> positionsTree) {
		this.positionsTree = positionsTree;
	}
	/**
	 * @return the objects
	 */
	public Object[] getObjects() {
		return objects;
	}
	/**
	 * @param objects the objects to set
	 */
	public void setObjects(Object[] objects) {
		this.objects = objects;
	}
	/**
	 * @return the next
	 */
	/**
	 * @return the departId
	 */
	public Integer getDepartId() {
		return departId;
	}
	/**
	 * @param departId the departId to set
	 */
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}



	

}
