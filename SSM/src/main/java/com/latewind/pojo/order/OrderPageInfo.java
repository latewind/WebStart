package com.latewind.pojo.order;

import java.util.List;

public class OrderPageInfo {
	private List<Integer> packId;
	private String name;
	private String address;
	private String payMethod;
	private String delivery;
	private String contact;

	public List<Integer> getPackId() {
		return packId;
	}

	public void setPackId(List<Integer> packId) {
		this.packId = packId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

}
