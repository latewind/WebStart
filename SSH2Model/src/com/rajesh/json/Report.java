package com.rajesh.json;

public class Report {
	private int id;
	private String name;
	private boolean active;
	private String date;
	private String color;

	public Report(){
		System.out.println("Inside Constructor with 0 arguments");
	}
	
public Report(int id,String name,boolean active,String date,String color){
		this.active=active;
		this.id=id;
		this.name=name;
		this.color=color;
		this.date=date;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
