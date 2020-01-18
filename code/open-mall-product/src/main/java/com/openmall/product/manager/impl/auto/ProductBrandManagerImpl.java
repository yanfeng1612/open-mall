package com.openmall.product.manager.impl.auto;

import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

import com.openmall.product.domain.auto.ProductBrand;
import com.openmall.product.domain.auto.ProductBrandQuery;
import com.openmall.product.dao.auto.ProductBrandMapper;
import com.openmall.product.manager.auto.ProductBrandManager;

import com.openmall.product.utils.*;

/**
 * 商品品牌表
 * @author model-driven
 * @date 2020-01-18
 **/
@Component("productBrandManager")
public class ProductBrandManagerImpl implements ProductBrandManager {

    private final static Logger logger = LoggerFactory.getLogger(ProductBrandManagerImpl.class);

    @Autowired
    private ProductBrandMapper productBrandMapper;

    /**
     *
     * @generated
     */
    @Override
    public int insertProductBrand(ProductBrand productBrand) {
        return productBrandMapper.insert(productBrand);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertBatch(List<ProductBrand> productBrandList){
        return productBrandMapper.insertBatch(productBrandList);
    }

    /**
     *
     * @generated
     */
    @Override
    public int deleteById(long id){
        return productBrandMapper.deleteById(id);
    }

     /**
     *
     * @generated
     */
    @Override
    public int updateProductBrand(ProductBrand productBrand) {
        return productBrandMapper.update(productBrand);
    }

    /**
     *
     * @generated
     */
    @Transactional
    @Override
    public int updateBatch(List<ProductBrand> productBrandList){
        int result = 0;
        for(ProductBrand item : productBrandList){
            int count = productBrandMapper.update(item);
            result += count;
        }
        return result;
    }

    @Override
    public ProductBrand findById(ProductBrand productBrand){
        return productBrandMapper.findById(productBrand);
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<ProductBrand> searchProductBrandList(Query<ProductBrandQuery> query) {
        List<ProductBrand> list = productBrandMapper.getAllList(query);
        ListResult<ProductBrand> result = new ListResult<ProductBrand>();
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
    public PageListResult<ProductBrand> searchPageProductBrandList(PageQuery<ProductBrandQuery> pageQuery) {
        long count = productBrandMapper.getCount(pageQuery);
        PageQueryWrapper<ProductBrandQuery> wrapper = new PageQueryWrapper<ProductBrandQuery>(pageQuery.getPageNo(),pageQuery.getPageSize(),count,pageQuery.getQuery());
        List<ProductBrand> itemList = productBrandMapper.getPagenationList(wrapper);
        PageListResult<ProductBrand> retValue = new PageListResult<>();
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
    public ListResult<ProductBrand> searchPageProductBrandListById(IdPageQuery<ProductBrandQuery> idPageQuery) {
        List<ProductBrand> itemList = productBrandMapper.getPagenationListById(idPageQuery);
        ListResult<ProductBrand> retValue = new ListResult<ProductBrand>();
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
    public GenericResult<Long> getTotalCount(Query<ProductBrandQuery> query){
        long count = productBrandMapper.getTotalCount(query);
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
    public GenericResult<Long> getCount(PageQuery<ProductBrandQuery> pageQuery){
        long count = productBrandMapper.getCount(pageQuery);
        GenericResult<Long> result = new GenericResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        return result;
    }

}
