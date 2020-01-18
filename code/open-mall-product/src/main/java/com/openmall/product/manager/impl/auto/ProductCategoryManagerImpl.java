package com.openmall.product.manager.impl.auto;

import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

import com.openmall.product.domain.auto.ProductCategory;
import com.openmall.product.domain.auto.ProductCategoryQuery;
import com.openmall.product.dao.auto.ProductCategoryMapper;
import com.openmall.product.manager.auto.ProductCategoryManager;

import com.openmall.product.utils.*;

/**
 * 商品分类表
 * @author model-driven
 * @date 2020-01-18
 **/
@Component("productCategoryManager")
public class ProductCategoryManagerImpl implements ProductCategoryManager {

    private final static Logger logger = LoggerFactory.getLogger(ProductCategoryManagerImpl.class);

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    /**
     *
     * @generated
     */
    @Override
    public int insertProductCategory(ProductCategory productCategory) {
        return productCategoryMapper.insert(productCategory);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertBatch(List<ProductCategory> productCategoryList){
        return productCategoryMapper.insertBatch(productCategoryList);
    }

    /**
     *
     * @generated
     */
    @Override
    public int deleteById(long id){
        return productCategoryMapper.deleteById(id);
    }

     /**
     *
     * @generated
     */
    @Override
    public int updateProductCategory(ProductCategory productCategory) {
        return productCategoryMapper.update(productCategory);
    }

    /**
     *
     * @generated
     */
    @Transactional
    @Override
    public int updateBatch(List<ProductCategory> productCategoryList){
        int result = 0;
        for(ProductCategory item : productCategoryList){
            int count = productCategoryMapper.update(item);
            result += count;
        }
        return result;
    }

    @Override
    public ProductCategory findById(ProductCategory productCategory){
        return productCategoryMapper.findById(productCategory);
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<ProductCategory> searchProductCategoryList(Query<ProductCategoryQuery> query) {
        List<ProductCategory> list = productCategoryMapper.getAllList(query);
        ListResult<ProductCategory> result = new ListResult<ProductCategory>();
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
    public PageListResult<ProductCategory> searchPageProductCategoryList(PageQuery<ProductCategoryQuery> pageQuery) {
        long count = productCategoryMapper.getCount(pageQuery);
        PageQueryWrapper<ProductCategoryQuery> wrapper = new PageQueryWrapper<ProductCategoryQuery>(pageQuery.getPageNo(),pageQuery.getPageSize(),count,pageQuery.getQuery());
        List<ProductCategory> itemList = productCategoryMapper.getPagenationList(wrapper);
        PageListResult<ProductCategory> retValue = new PageListResult<>();
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
    public ListResult<ProductCategory> searchPageProductCategoryListById(IdPageQuery<ProductCategoryQuery> idPageQuery) {
        List<ProductCategory> itemList = productCategoryMapper.getPagenationListById(idPageQuery);
        ListResult<ProductCategory> retValue = new ListResult<ProductCategory>();
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
    public GenericResult<Long> getTotalCount(Query<ProductCategoryQuery> query){
        long count = productCategoryMapper.getTotalCount(query);
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
    public GenericResult<Long> getCount(PageQuery<ProductCategoryQuery> pageQuery){
        long count = productCategoryMapper.getCount(pageQuery);
        GenericResult<Long> result = new GenericResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        return result;
    }

}
