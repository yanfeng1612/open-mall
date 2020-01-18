package com.openmall.product.dao.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.openmall.product.domain.auto.ProductCategory;
import com.openmall.product.domain.auto.ProductCategoryQuery;
import com.openmall.product.utils.*;

/**
 * 商品分类表
 * @author model-driven
 * @date 2020-01-18
 **/
public interface ProductCategoryMapper {

    /**
     *
     * @auto generated
     */
    int insert(ProductCategory productCategory);

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
    int update(ProductCategory productCategory);

    /**
     *
     * @auto generated
     */
    ProductCategory findById(ProductCategory productCategory);

    /**
     *
     * @auto generated
     */
    List<ProductCategory> getAllList(Query<ProductCategoryQuery> query);

    /**
     *
     * @auto generated
     */
    List<ProductCategory> getPagenationList(PageQuery<ProductCategoryQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    List<ProductCategory> getPagenationListById(IdPageQuery<ProductCategoryQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    long getCount(PageQuery<ProductCategoryQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    long getTotalCount(Query<ProductCategoryQuery> query);

}
