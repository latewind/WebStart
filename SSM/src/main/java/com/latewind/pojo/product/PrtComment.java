package com.latewind.pojo.product;

import java.util.Date;

import com.latewind.pojo.user.UserInfo;

public class PrtComment {
    private Integer commentId;

    private Integer prtId;

    private Integer userId;

    private String content;

    private Date createTime;

    private Integer evalRank;
    
    private UserInfo userInfo;
    
    

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPrtId() {
        return prtId;
    }

    public void setPrtId(Integer prtId) {
        this.prtId = prtId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }


    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getEvalRank() {
        return evalRank;
    }

    public void setEvalRank(Integer evalRank) {
        this.evalRank = evalRank;
    }

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}