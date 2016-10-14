package com.latewind.pojo.product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProductInfo {
	private Integer prtId;

	private String prtName;

	private String describ;

	private Integer thirdId;

	private BigDecimal price;

	private Integer num;

	private Integer sellCount;

	private Integer clickCount;

	private Date createTime;

	private Integer offShelf;

	private Integer primImgId;

	private String intro;
	// 主要图片
	private ProductImages primImage;
	//
	private List<ProductImages> images;

	@Override
	public String toString() {
		return "ProductInfo [prtId=" + prtId + ", prtName=" + prtName + ", describ=" + describ + ", thirdId=" + thirdId
				+ ", price=" + price + ", num=" + num + ", sellCount=" + sellCount + ", clickCount=" + clickCount
				+ ", createTime=" + createTime + ", offShelf=" + offShelf + ", primImgId=" + primImgId + ", intro="
				+ intro + ", primImage=" + primImage + ", images=" + images + "]";
	}

	public ProductInfo() {

	}

	public ProductInfo(String prtName, String describ, Integer thirdId, BigDecimal price, Integer num, Integer sellCount,
			Integer clickCount, Date createTime, Integer offShelf, Integer primImgId, String intro) {

		this.prtName = prtName;
		this.describ = describ;
		this.thirdId = thirdId;
		this.price = price;
		this.num = num;
		this.sellCount = sellCount;
		this.clickCount = clickCount;
		this.createTime = createTime;
		this.offShelf = offShelf;
		this.primImgId = primImgId;
		this.intro = intro;
	}

	public Integer getPrtId() {
		return prtId;
	}

	public void setPrtId(Integer prtId) {
		this.prtId = prtId;
	}

	public String getPrtName() {
		return prtName;
	}

	public void setPrtName(String prtName) {
		this.prtName = prtName == null ? null : prtName.trim();
	}

	public String getDescrib() {
		return describ;
	}

	public void setDescrib(String describ) {
		this.describ = describ == null ? null : describ.trim();
	}

	public Integer getThirdId() {
		return thirdId;
	}

	public void setThirdId(Integer thirdId) {
		this.thirdId = thirdId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getSellCount() {
		return sellCount;
	}

	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getOffShelf() {
		return offShelf;
	}

	public void setOffShelf(Integer offShelf) {
		this.offShelf = offShelf;
	}

	public Integer getPrimImgId() {
		return primImgId;
	}

	public void setPrimImgId(Integer primImgId) {
		this.primImgId = primImgId;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro == null ? null : intro.trim();
	}

	/**
	 * @return the primImage
	 */
	public ProductImages getPrimImage() {
		return primImage;
	}

	/**
	 * @param primImage
	 *            the primImage to set
	 */
	public void setPrimImage(ProductImages primImage) {
		this.primImage = primImage;
	}

	/**
	 * @return the images
	 */
	public List<ProductImages> getImages() {
		return images;
	}

	/**
	 * @param images
	 *            the images to set
	 */
	public void setImages(List<ProductImages> images) {
		this.images = images;
	}
}