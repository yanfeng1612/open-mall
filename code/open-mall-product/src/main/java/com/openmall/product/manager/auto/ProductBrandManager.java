package com.openmall.product.manager.auto;

import java.util.List;

import com.openmall.product.domain.auto.ProductBrand;
import com.openmall.product.domain.auto.ProductBrandQuery;
import com.openmall.product.utils.*;

/**
 * 商品品牌表
 * @author model-driven
 * @date 2020-01-14
 **/
public interface ProductBrandManager {

     /**
     *
     * @auto generated
     */
    int insertProductBrand(ProductBrand productBrand);

    /**
     *
     * @auto generated
     */
    int insertBatch(List<ProductBrand> productBrandList);

    /**
     *
     * @auto generated
     */
    int deleteById(long id);

    /**
     *
     * @auto generated
     */
    int updateProductBrand(ProductBrand productBrand);

    /**
     *
     * @auto generated
     */
    int updateBatch(List<ProductBrand> productBrandList);

    /**
     *
     * @auto generated
     */
    ProductBrand findById(ProductBrand productBrand);

    /**
     *
     * @auto generated
     */
    ListResult<ProductBrand> searchProductBrandList(Query<ProductBrandQuery> query);

    /**
     *
     * @auto generated
     */
    PageListResult<ProductBrand> searchPageProductBrandList(PageQuery<ProductBrandQuery> pageQuery);

    /**
    *
    * @auto generated
    */
    ListResult<ProductBrand> searchPageProductBrandListById(IdPageQuery<ProductBrandQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getTotalCount(Query<ProductBrandQuery> query);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getCount(PageQuery<ProductBrandQuery> pageQuery);

}
