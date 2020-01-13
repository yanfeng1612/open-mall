package com.openmall.product.manager.auto;

import java.util.List;

import com.openmall.product.domain.auto.Product;
import com.openmall.product.domain.auto.ProductQuery;
import com.openmall.product.utils.*;

/**
 * 商品基本属性表
 * @author model-driven
 * @date 2020-01-12
 **/
public interface ProductManager {

     /**
     *
     * @auto generated
     */
    int insertProduct(Product product);

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
    int updateProduct(Product product);

    /**
     *
     * @auto generated
     */
    int updateBatch(List<Product> productList);

    /**
     *
     * @auto generated
     */
    Product findById(Product product);

    /**
     *
     * @auto generated
     */
    ListResult<Product> searchProductList(Query<ProductQuery> query);

    /**
     *
     * @auto generated
     */
    PageListResult<Product> searchPageProductList(PageQuery<ProductQuery> pageQuery);

    /**
    *
    * @auto generated
    */
    ListResult<Product> searchPageProductListById(IdPageQuery<ProductQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getTotalCount(Query<ProductQuery> query);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getCount(PageQuery<ProductQuery> pageQuery);

}
