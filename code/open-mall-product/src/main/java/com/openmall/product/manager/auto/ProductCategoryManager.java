package com.openmall.product.manager.auto;

import java.util.List;

import com.openmall.product.domain.auto.ProductCategory;
import com.openmall.product.domain.auto.ProductCategoryQuery;
import com.openmall.product.utils.*;

/**
 * 商品分类表
 * @author model-driven
 * @date 2020-01-14
 **/
public interface ProductCategoryManager {

     /**
     *
     * @auto generated
     */
    int insertProductCategory(ProductCategory productCategory);

    /**
     *
     * @auto generated
     */
    int insertBatch(List<ProductCategory> productCategoryList);

    /**
     *
     * @auto generated
     */
    int deleteById(long id);

    /**
     *
     * @auto generated
     */
    int updateProductCategory(ProductCategory productCategory);

    /**
     *
     * @auto generated
     */
    int updateBatch(List<ProductCategory> productCategoryList);

    /**
     *
     * @auto generated
     */
    ProductCategory findById(ProductCategory productCategory);

    /**
     *
     * @auto generated
     */
    ListResult<ProductCategory> searchProductCategoryList(Query<ProductCategoryQuery> query);

    /**
     *
     * @auto generated
     */
    PageListResult<ProductCategory> searchPageProductCategoryList(PageQuery<ProductCategoryQuery> pageQuery);

    /**
    *
    * @auto generated
    */
    ListResult<ProductCategory> searchPageProductCategoryListById(IdPageQuery<ProductCategoryQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getTotalCount(Query<ProductCategoryQuery> query);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getCount(PageQuery<ProductCategoryQuery> pageQuery);

}
