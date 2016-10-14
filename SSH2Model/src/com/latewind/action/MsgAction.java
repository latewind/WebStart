/**
 * 
 */
package com.latewind.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.latewind.bean.UserInfo;
import com.latewind.domain.Msg;
import com.latewind.service.MsgService;
import com.latewind.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class MsgAction extends ActionSupport {
	private List<Msg> msgs;
	private MsgService msgService;
	private UserInfoService userInfoService;
	private Integer msgId;
	private Msg msg;
	private String title;
	private String content;
	
	
	public String myMsg(){
		UserInfo u=userInfoService.findUserById(6);
		Set set=u.getReceptMsgs();
		msgs=new ArrayList<Msg>(set);
		System.out.println(msgs.size());
//		String  sss=msgs.get(1).getSender().getEmployee().getName();
		
		System.out.println(msgs.get(1).getSender().getEmployee().getName());
		return SUCCESS;
	}
	
	public String viewMsg(){
		
		msg=msgService.findMsgById(msgId);
		//
		System.out.println("the msg id is:"+msgId);
		
		return "view";
	}
	/**
	 *  发布消息
	 * @return
	 */
	public String publishMsg(){
		
		System.out.println("publish Message");
		System.out.println(title);
		System.out.println(content);
		
		//获取session里面的用户
		Map session=ActionContext.getContext().getSession();	
		UserInfo userSession=(UserInfo) session.get("userInfo");
		Msg m=new Msg();
		
		////		m.setId(6);
		m.setTitle(title);
		m.setContent(getContent());		
		m.setSender(userSession);
		msgService.sendMsg2All(m);
		
		return SUCCESS;
	}

	/**
	 * @return the msgs
	 */
	public List<Msg> getMsgs() {
		return msgs;
	}

	/**
	 * @param msgs the msgs to set
	 */
	public void setMsgs(List<Msg> msgs) {
		this.msgs = msgs;
	}

	/**
	 * @return the msgService
	 */
	public MsgService getMsgService() {
		return msgService;
	}

	/**
	 * @param msgService the msgService to set
	 */
	public void setMsgService(MsgService msgService) {
		this.msgService = msgService;
	}

	/**
	 * @return the userInfoService
	 */
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	/**
	 * @param userInfoService the userInfoService to set
	 */
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}



	/**
	 * @return the msg
	 */
	public Msg getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(Msg msg) {
		this.msg = msg;
	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



}
