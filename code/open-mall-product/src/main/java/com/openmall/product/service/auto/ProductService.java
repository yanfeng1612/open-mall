package com.openmall.product.service.auto;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

import com.openmall.product.utils.*;

import com.openmall.product.domain.auto.Product;
import com.openmall.product.domain.auto.ProductQuery;

/**
 * 商品基本属性表
 * @author model-driven
 * @date 2020-01-18
 **/
public interface ProductService {

    /**
     *
     * @generated
     */
    BasicResult addProduct(Product product);

    /**
     *
     * @generated
     */
    BasicResult addBatch(List<Product> productList);

    /**
     *
     * @generated
     */
    BasicResult deleteById(long id);

    /**
     *
     * @generated
     */
    BasicResult updateProductById(Product product);

    /**
     *
     * @generated
     */
    BasicResult updateBatch(List<Product> productList);

    /**
     *
     * @generated
     */
    Product searchProductById(Product product);

    /**
     *
     * @generated
     */
    ListResult<Product> searchProduct(Query<ProductQuery> query);

    /**
     *
     * @generated
     */
    PageListResult<Product> searchPageProduct(PageQuery<ProductQuery> pageQuery);

    /**
    *
    * @generated
    */
    ListResult<Product> searchPageProductById(IdPageQuery<ProductQuery> idPageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getCount(PageQuery<ProductQuery> pageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getTotalCount(Query<ProductQuery> query);

}
