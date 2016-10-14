package com.latewind.pojo.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderInfo {
    private Integer orderId;

    private Integer userId;

    private String name;

    private String contact;

    private String address;

    private String orderStatus;

    private String payMethod;

    private BigDecimal totalPrice;

    private String delivery;

    private Integer packCount;

    private Date completeTime;

    private Date createTime;
    
    private String passKey;
    
    
    
    private List<ProductPack> productPacks;
    
    
    public OrderInfo() {
			}
    
    

 
    /**
	 * @param userId
	 * @param name
	 * @param contact
	 * @param address
	 * @param orderStatus
	 * @param payMethod
	 * @param delivery
	 * @param packCount
	 * @param createTime
	 */
	public OrderInfo(Integer userId, String name, String contact, String address, String orderStatus, String payMethod,
			String delivery, Integer packCount, Date createTime) {
		super();
		this.userId = userId;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.orderStatus = orderStatus;
		this.payMethod = payMethod;
		this.delivery = delivery;
		this.packCount = packCount;
		this.createTime = createTime;
	}




	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", userId=" + userId + ", name=" + name + ", contact=" + contact
				+ ", address=" + address + ", orderStatus=" + orderStatus + ", payMethod=" + payMethod + ", totalPrice="
				+ totalPrice + ", delivery=" + delivery + ", packCount=" + packCount + ", completeTime=" + completeTime
				+ ", createTime=" + createTime + "]";
	}

	public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery == null ? null : delivery.trim();
    }

    public Integer getPackCount() {
        return packCount;
    }

    public void setPackCount(Integer packCount) {
        this.packCount = packCount;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }




	/**
	 * @return the productPacks
	 */
	public List<ProductPack> getProductPacks() {
		return productPacks;
	}




	/**
	 * @param productPacks the productPacks to set
	 */
	public void setProductPacks(List<ProductPack> productPacks) {
		this.productPacks = productPacks;
	}




	/**
	 * @return the passKey
	 */
	public String getPassKey() {
		return passKey;
	}




	/**
	 * @param passKey the passKey to set
	 */
	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}
}