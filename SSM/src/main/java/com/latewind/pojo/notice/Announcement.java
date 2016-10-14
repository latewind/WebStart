package com.latewind.pojo.notice;

import java.util.Date;

public class Announcement {
    private Integer announId;

    private String announTitle;

    private Date announTime;

    private String announAnchor;

    private Integer displayStatus;

    private String announContent;

    public Integer getAnnounId() {
        return announId;
    }

    public void setAnnounId(Integer announId) {
        this.announId = announId;
    }

    public String getAnnounTitle() {
        return announTitle;
    }

    public void setAnnounTitle(String announTitle) {
        this.announTitle = announTitle == null ? null : announTitle.trim();
    }


    public String getAnnounAnchor() {
        return announAnchor;
    }

    public void setAnnounAnchor(String announAnchor) {
        this.announAnchor = announAnchor == null ? null : announAnchor.trim();
    }

    public Integer getDisplayStatus() {
        return displayStatus;
    }

    public void setDisplayStatus(Integer displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getAnnounContent() {
        return announContent;
    }

    public void setAnnounContent(String announContent) {
        this.announContent = announContent == null ? null : announContent.trim();
    }

	/**
	 * @return the announTime
	 */
	public Date getAnnounTime() {
		return announTime;
	}

	/**
	 * @param announTime the announTime to set
	 */
	public void setAnnounTime(Date announTime) {
		this.announTime = announTime;
	}
}