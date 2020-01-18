package com.openmall.product.dao.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.openmall.product.domain.auto.Product;
import com.openmall.product.domain.auto.ProductQuery;
import com.openmall.product.utils.*;

/**
 * 商品基本属性表
 * @author model-driven
 * @date 2020-01-18
 **/
public interface ProductMapper {

    /**
     *
     * @auto generated
     */
    int insert(Product product);

    /**
     *
     * @auto generated
     */
    int insertBatch(List<Product> productList);

    /**
     *
     * @auto generated
     */
    int deleteById(long id);

    /**
     *
     * @auto generated
     */
    int update(Product product);

    /**
     *
     * @auto generated
     */
    Product findById(Product product);

    /**
     *
     * @auto generated
     */
    List<Product> getAllList(Query<ProductQuery> query);

    /**
     *
     * @auto generated
     */
    List<Product> getPagenationList(PageQuery<ProductQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    List<Product> getPagenationListById(IdPageQuery<ProductQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    long getCount(PageQuery<ProductQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    long getTotalCount(Query<ProductQuery> query);

}
