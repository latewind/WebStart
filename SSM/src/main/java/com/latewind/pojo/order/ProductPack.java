package com.latewind.pojo.order;

import java.math.BigDecimal;

import com.latewind.pojo.product.ProductInfo;

public class ProductPack {
    private Integer cartProductId;

    private Integer cartId;

    private Integer prtId;

    private Integer quantity;
    
    private ProductInfo productInfo;
    
    private Integer orderId;
    
    private BigDecimal dealPrice;
    
    private Integer commentId;
    
    private String passKey;

    /**
	 * 
	 */
	public ProductPack() {
	
	}

	/**
	 * @param cartId
	 * @param prtId
	 * @param quantity
	 */
	public ProductPack(Integer cartId, Integer prtId, Integer quantity) {
		super();
		this.cartId = cartId;
		this.prtId = prtId;
		this.quantity = quantity;
	}

	

	@Override
	public String toString() {
		return "ProductPack [cartProductId=" + cartProductId + ", cartId=" + cartId + ", prtId=" + prtId + ", quantity="
				+ quantity + ", productInfo=" + productInfo + ", orderId=" + orderId + ", dealPrice=" + dealPrice
				+ ", commentId=" + commentId + ", passKey=" + passKey + "]";
	}

	public Integer getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Integer cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getPrtId() {
        return prtId;
    }

    public void setPrtId(Integer prtId) {
        this.prtId = prtId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	/**
	 * @return the productInfo
	 */
	public ProductInfo getProductInfo() {
		return productInfo;
	}

	/**
	 * @param productInfo the productInfo to set
	 */
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the dealPrice
	 */
	public BigDecimal getDealPrice() {
		return dealPrice;
	}

	/**
	 * @param dealPrice the dealPrice to set
	 */
	public void setDealPrice(BigDecimal dealPrice) {
		this.dealPrice = dealPrice;
	}

	/**
	 * @return the commentId
	 */
	public Integer getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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