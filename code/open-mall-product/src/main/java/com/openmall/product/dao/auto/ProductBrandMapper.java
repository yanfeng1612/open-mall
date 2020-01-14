package com.openmall.product.dao.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.openmall.product.domain.auto.ProductBrand;
import com.openmall.product.domain.auto.ProductBrandQuery;
import com.openmall.product.utils.*;

/**
 * 商品品牌表
 * @author model-driven
 * @date 2020-01-14
 **/
public interface ProductBrandMapper {

    /**
     *
     * @auto generated
     */
    int insert(ProductBrand productBrand);

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
    int update(ProductBrand productBrand);

    /**
     *
     * @auto generated
     */
    ProductBrand findById(ProductBrand productBrand);

    /**
     *
     * @auto generated
     */
    List<ProductBrand> getAllList(Query<ProductBrandQuery> query);

    /**
     *
     * @auto generated
     */
    List<ProductBrand> getPagenationList(PageQuery<ProductBrandQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    List<ProductBrand> getPagenationListById(IdPageQuery<ProductBrandQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    long getCount(PageQuery<ProductBrandQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    long getTotalCount(Query<ProductBrandQuery> query);

}
