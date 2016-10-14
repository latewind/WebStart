package com.latewind.pojo;

public class Product {
	private Integer id;
	private String name;
	private String size;
	
	public Product (String name,String size){
		this.name=name;
		this.size=size;
		
	}
	public Product (Integer id,String name,String size){
		this.name=name;
		this.size=size;
		this.id=id;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
