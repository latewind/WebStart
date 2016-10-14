package com.latewind.pojo;

import java.util.List;

public class TopCategory {
    private Integer id;

    private String name;

    private String des;
    
    private List<SubCategory> subCategories;
    

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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

	/**
	 * @return the subCategories
	 */
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
}