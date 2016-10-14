package com.latewind.pojo.notice;

import java.util.Date;

public class Headline implements Cloneable{
    private Integer headlineId;

    private String title;

    private String content;

    private String pageLink;

    private Date displayTime;

    private Integer showStatus;
    
    

    @Override
	public Object clone() throws CloneNotSupportedException {
		    	Headline newHead=(Headline) super.clone();
//    	newHead.displayTime=(Date) displayTime.clone();
     
		return newHead;
		
	}

	public Integer getHeadlineId() {
        return headlineId;
    }

    public void setHeadlineId(Integer headlineId) {
        this.headlineId = headlineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink == null ? null : pageLink.trim();
    }



    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

	/**
	 * @return the displayTime
	 */
	public Date getDisplayTime() {
		return displayTime;
	}

	/**
	 * @param displayTime the displayTime to set
	 */
	public void setDisplayTime(Date displayTime) {
		this.displayTime = displayTime;
	}
}