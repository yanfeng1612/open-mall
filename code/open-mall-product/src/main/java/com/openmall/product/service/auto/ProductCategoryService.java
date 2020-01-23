package com.openmall.product.service.auto;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

import com.openmall.product.utils.*;

import com.openmall.product.domain.auto.ProductCategory;
import com.openmall.product.domain.auto.ProductCategoryQuery;

/**
 * 商品分类表
 * @author model-driven
 * @date 2020-01-24
 **/
public interface ProductCategoryService {

    /**
     *
     * @generated
     */
    BasicResult addProductCategory(ProductCategory productCategory);

    /**
     *
     * @generated
     */
    BasicResult addBatch(List<ProductCategory> productCategoryList);

    /**
     *
     * @generated
     */
    BasicResult addOrUpdate(ProductCategory productCategory);

    /**
     *
     * @generated
     */
    BasicResult deleteById(long id);

    /**
     *
     * @generated
     */
    BasicResult updateProductCategoryById(ProductCategory productCategory);

    /**
     *
     * @generated
     */
    BasicResult updateBatch(List<ProductCategory> productCategoryList);

    /**
     *
     * @generated
     */
    ProductCategory searchProductCategoryById(Long id);

    /**
     *
     * @generated
     */
    ListResult<ProductCategory> searchProductCategory(Query<ProductCategoryQuery> query);

    /**
     *
     * @generated
     */
    PageListResult<ProductCategory> searchPageProductCategory(PageQuery<ProductCategoryQuery> pageQuery);

    /**
    *
    * @generated
    */
    ListResult<ProductCategory> searchPageProductCategoryById(IdPageQuery<ProductCategoryQuery> idPageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getCount(PageQuery<ProductCategoryQuery> pageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getTotalCount(Query<ProductCategoryQuery> query);

}
