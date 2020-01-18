package com.openmall.product.service.auto;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

import com.openmall.product.utils.*;

import com.openmall.product.domain.auto.ProductBrand;
import com.openmall.product.domain.auto.ProductBrandQuery;

/**
 * 商品品牌表
 * @author model-driven
 * @date 2020-01-18
 **/
public interface ProductBrandService {

    /**
     *
     * @generated
     */
    BasicResult addProductBrand(ProductBrand productBrand);

    /**
     *
     * @generated
     */
    BasicResult addBatch(List<ProductBrand> productBrandList);

    /**
     *
     * @generated
     */
    BasicResult deleteById(long id);

    /**
     *
     * @generated
     */
    BasicResult updateProductBrandById(ProductBrand productBrand);

    /**
     *
     * @generated
     */
    BasicResult updateBatch(List<ProductBrand> productBrandList);

    /**
     *
     * @generated
     */
    ProductBrand searchProductBrandById(ProductBrand productBrand);

    /**
     *
     * @generated
     */
    ListResult<ProductBrand> searchProductBrand(Query<ProductBrandQuery> query);

    /**
     *
     * @generated
     */
    PageListResult<ProductBrand> searchPageProductBrand(PageQuery<ProductBrandQuery> pageQuery);

    /**
    *
    * @generated
    */
    ListResult<ProductBrand> searchPageProductBrandById(IdPageQuery<ProductBrandQuery> idPageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getCount(PageQuery<ProductBrandQuery> pageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getTotalCount(Query<ProductBrandQuery> query);

}
