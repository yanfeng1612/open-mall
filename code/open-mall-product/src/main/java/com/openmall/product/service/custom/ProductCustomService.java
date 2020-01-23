package com.openmall.product.service.custom;

import com.openmall.product.domain.auto.Product;
import com.openmall.product.utils.BasicResult;

public interface ProductCustomService {

    /**
     * 增加商品
     */
    BasicResult addProduct(Product product);
}
