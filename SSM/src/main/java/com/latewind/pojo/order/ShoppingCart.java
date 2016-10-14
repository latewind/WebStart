package com.latewind.pojo.order;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {
    private Integer cartId;

    private Integer userId;

    private Integer prtCount;

    private BigDecimal totalPrice;
    
    private List<ProductPack> productPacks;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPrtCount() {
        return prtCount;
    }

    public void setPrtCount(Integer prtCount) {
        this.prtCount = prtCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
}