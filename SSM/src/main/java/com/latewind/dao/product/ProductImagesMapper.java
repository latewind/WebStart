package com.latewind.dao.product;

import com.latewind.pojo.product.ProductImages;

public interface ProductImagesMapper {
    int deleteByPrimaryKey(Integer imageId);

    int insert(ProductImages record);

    int insertSelective(ProductImages record);

    ProductImages selectByPrimaryKey(Integer imageId);

    int updateByPrimaryKeySelective(ProductImages record);

    int updateByPrimaryKey(ProductImages record);
}