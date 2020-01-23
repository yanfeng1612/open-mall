package com.openmall.product.manager.impl.auto;

import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

import com.openmall.product.domain.auto.Product;
import com.openmall.product.domain.auto.ProductQuery;
import com.openmall.product.dao.auto.ProductMapper;
import com.openmall.product.manager.auto.ProductManager;

import com.openmall.product.utils.*;

/**
 * 商品基本属性表
 * @author model-driven
 * @date 2020-01-24
 **/
@Component("productManager")
public class ProductManagerImpl implements ProductManager {

    private final static Logger logger = LoggerFactory.getLogger(ProductManagerImpl.class);

    @Autowired
    private ProductMapper productMapper;

    /**
     *
     * @generated
     */
    @Override
    public int insertProduct(Product product) {
        return productMapper.insert(product);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertBatch(List<Product> productList){
        return productMapper.insertBatch(productList);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertOrUpdate(Product product){
        return productMapper.insertOrUpdate(product);
    }

    /**
     *
     * @generated
     */
    @Override
    public int deleteById(long id){
        return productMapper.deleteById(id);
    }

     /**
     *
     * @generated
     */
    @Override
    public int updateProduct(Product product) {
        return productMapper.update(product);
    }

    /**
     *
     * @generated
     */
    @Transactional
    @Override
    public int updateBatch(List<Product> productList){
        int result = 0;
        for(Product item : productList){
            int count = productMapper.update(item);
            result += count;
        }
        return result;
    }

    @Override
    public Product findById(Long id){
        return productMapper.findById(id);
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<Product> searchProductList(Query<ProductQuery> query) {
        List<Product> list = productMapper.getAllList(query);
        ListResult<Product> result = new ListResult<Product>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValues(list);
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public PageListResult<Product> searchPageProductList(PageQuery<ProductQuery> pageQuery) {
        long count = productMapper.getCount(pageQuery);
        PageQueryWrapper<ProductQuery> wrapper = new PageQueryWrapper<ProductQuery>(pageQuery.getPageNo(),pageQuery.getPageSize(),count,pageQuery.getQuery());
        List<Product> itemList = productMapper.getPagenationList(wrapper);
        PageListResult<Product> retValue = new PageListResult<>();
        retValue.setMsg("查询成功");
        retValue.setCode(CodeEnum.SUCCESS.getCode());
        retValue.setValues(itemList);
        long currentPage = pageQuery.getPageNo() > 1 ? pageQuery.getPageNo() : 1;
        Pagenation pagenation = new Pagenation(currentPage, count, pageQuery.getPageSize());
        retValue.setPagenation(pagenation);
        return retValue;
    }

    /**
    *
    * @generated
    */
    @Override
    public ListResult<Product> searchPageProductListById(IdPageQuery<ProductQuery> idPageQuery) {
        List<Product> itemList = productMapper.getPagenationListById(idPageQuery);
        ListResult<Product> retValue = new ListResult<Product>();
        retValue.setMsg("查询成功");
        retValue.setCode(CodeEnum.SUCCESS.getCode());
        retValue.setValues(itemList);
        return retValue;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getTotalCount(Query<ProductQuery> query){
        long count = productMapper.getTotalCount(query);
        GenericResult<Long> result = new GenericResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getCount(PageQuery<ProductQuery> pageQuery){
        long count = productMapper.getCount(pageQuery);
        GenericResult<Long> result = new GenericResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        return result;
    }

}
