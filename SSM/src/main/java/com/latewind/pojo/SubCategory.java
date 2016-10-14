package com.latewind.pojo;

import java.util.List;

public class SubCategory {
    private Integer id;

    private String name;

    private Integer topId;

    private String des;
    //所属 一级分类
    private TopCategory topCategory;
    //下属三级分类
    private List<ThirdCategory> thirdCategories;

    
    
    @Override
	public String toString() {
		return getName();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTopId() {
        return topId;
    }

    public void setTopId(Integer topId) {
        this.topId = topId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

	/**
	 * @return the topCategory
	 */
	public TopCategory getTopCategory() {
		return topCategory;
	}

	/**
	 * @param topCategory the topCategory to set
	 */
	public void setTopCategory(TopCategory topCategory) {
		this.topCategory = topCategory;
	}

	/**
	 * @return the thirdCategories
	 */
	public List<ThirdCategory> getThirdCategories() {
		return thirdCategories;
	}

	/**
	 * @param thirdCategories the thirdCategories to set
	 */
	public void setThirdCategories(List<ThirdCategory> thirdCategories) {
		this.thirdCategories = thirdCategories;
	}
}