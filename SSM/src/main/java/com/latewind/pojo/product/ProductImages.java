package com.latewind.pojo.product;

public class ProductImages {
    private Integer imageId;

    private String imageName;

    private Integer prtId;
    
    
    public ProductImages(){
    	
    }
    
    public ProductImages(String imageName,Integer prtId){
    	
    	this.imageName=imageName;
    	this.prtId=prtId;
    	
    	
    }
    
    
    @Override
	public String toString() {
		return "ProductImages [imageId=" + imageId + ", imageName=" + imageName + ", prtId=" + prtId + "]";
	}

	public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }

    public Integer getPrtId() {
        return prtId;
    }

    public void setPrtId(Integer prtId) {
        this.prtId = prtId;
    }
}