package com.latewind.pojo.sysm;

import java.util.Date;
import java.util.List;

public class SysmFunction {
    private Integer functionId;

    private Integer parentId;

    private String functionName;

    private String functionUrl;

    private Boolean functionType;

    private Date createTime;

    private Integer sort;
    
    private List<SysmFunction> childList;

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl == null ? null : functionUrl.trim();
    }

    public Boolean getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Boolean functionType) {
        this.functionType = functionType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

	/**
	 * @return the childList
	 */
	public List<SysmFunction> getChildList() {
		return childList;
	}

	/**
	 * @param childList the childList to set
	 */
	public void setChildList(List<SysmFunction> childList) {
		this.childList = childList;
	}
}