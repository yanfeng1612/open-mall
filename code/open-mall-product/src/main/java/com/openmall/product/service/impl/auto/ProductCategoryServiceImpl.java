package com.openmall.product.service.impl.auto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import org.springframework.dao.DuplicateKeyException;

import com.openmall.product.utils.*;

import com.openmall.product.domain.auto.ProductCategory;
import com.openmall.product.domain.auto.ProductCategoryQuery;
import com.openmall.product.manager.auto.ProductCategoryManager;
import com.openmall.product.service.auto.ProductCategoryService;

/**
 * 商品分类表
 * @author model-driven
 * @date 2020-01-24
 **/
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService{

    private final static Logger LOG = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);

    @Autowired
    private ProductCategoryManager productCategoryManagerImpl;

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addProductCategory(ProductCategory productCategory) {
        LOG.info("request ProductCategoryServiceImpl.addProductCategory param:" + JSON.toJSONString(productCategory));
        BasicResult result = new BasicResult();
        try {
            if (productCategory != null) {
                productCategoryManagerImpl.insertProductCategory(productCategory);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("productCategory is null");
                LOG.error("------ProductCategoryServiceImpl.addProductCategory - productCategory is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------ProductCategoryServiceImpl.addProductCategory 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------ProductCategoryServiceImpl.addProductCategory 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addBatch(List<ProductCategory> productCategoryList){
        LOG.info("request ProductCategoryServiceImpl.addBatch size:" + productCategoryList.size());
        BasicResult result = new BasicResult();
        try {
            productCategoryManagerImpl.insertBatch(productCategoryList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("批量插入成功");
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------productCategoryServiceImpl.addBatch 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductCategoryServiceImpl.addBatch param:" + JSON.toJSONString(productCategoryList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addOrUpdate(ProductCategory productCategory) {
        LOG.info("request ProductCategoryServiceImpl.addOrUpdate param:" + JSON.toJSONString(productCategory));
        BasicResult result = new BasicResult();
        try {
            if (productCategory != null) {
                productCategoryManagerImpl.insertOrUpdate(productCategory);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("productCategory is null");
                LOG.error("------ProductCategoryServiceImpl.addProductCategory - productCategory is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------ProductCategoryServiceImpl.addProductCategory 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------ProductCategoryServiceImpl.addProductCategory 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult deleteById(long id){
        LOG.info("request ProductCategoryServiceImpl.deleteBy param:{}",id);
        BasicResult result = new BasicResult();
        try{
            int num = productCategoryManagerImpl.deleteById(id);
            if (num == 1) {
                result.setMsg("删除成功");
                result.setCode(CodeEnum.SUCCESS.getCode());
            } else {
                result.setMsg("删除失败");
                result.setCode(CodeEnum.FAILED.getCode());
            }
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductCategoryServiceImpl.deleteById :{}",id,e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult updateProductCategoryById(ProductCategory productCategory){
        LOG.info("request ProductCategoryServiceImpl.modifyProductCategory param:" + JSON.toJSONString(productCategory));
        BasicResult result = new BasicResult();
        try {
            if (productCategory != null) {
                int update = productCategoryManagerImpl.updateProductCategory(productCategory);
                if (update > 0) {
                    result.setCode(CodeEnum.SUCCESS.getCode());
                    result.setMsg("编辑成功");
                    LOG.debug("------ProductCategoryServiceImpl.modifyProductCategory 编辑成功------");
                } else {
                    result.setCode(CodeEnum.FAILED.getCode());
                    result.setMsg("编辑失败，请检查是否指定主键，或者唯一键");
                    LOG.debug("------ProductCategoryServiceImpl.modifyProductCategory 编辑失败------");
                }
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("productCategory is null");
                LOG.error("------ProductCategoryServiceImpl.modifyProductCategory - productCategory is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------ProductCategoryServiceImpl.modifyProductCategory 异常",e);
        } catch (Exception e) {
            LOG.error("------ProductCategoryServiceImpl.modifyProductCategory 异常",e);
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult updateBatch(List<ProductCategory> productCategoryList){
        LOG.info("request ProductCategoryServiceImpl.modifyBatch size:" + productCategoryList.size());
        BasicResult result = new BasicResult();
        try {
            Object count = productCategoryManagerImpl.updateBatch(productCategoryList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg(String.valueOf(count));
            LOG.info("response ProductCategoryServiceImpl.modifyBatch 处理成功 updateCount:" + count);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductCategoryServiceImpl.modifyBatch :" + JSON.toJSONString(productCategoryList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public ProductCategory searchProductCategoryById(Long id){
        try {
            return productCategoryManagerImpl.findById(id);
        } catch (Exception e) {
            LOG.error("------ProductCategoryServiceImpl.searchProductCategoryByPriKey 异常", e);
        }
        return null;
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<ProductCategory> searchProductCategory(Query<ProductCategoryQuery> query){
        LOG.info("request ProductCategoryServiceImpl.searchProductCategory param:" + JSON.toJSONString(query));
        ListResult<ProductCategory> result = new ListResult<>();
        try {
            result = productCategoryManagerImpl.searchProductCategoryList(query);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------ProductCategoryServiceImpl.searchProductCategory 异常", e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public PageListResult<ProductCategory> searchPageProductCategory(PageQuery<ProductCategoryQuery> pageQuery){
        LOG.info("request ProductCategoryServiceImpl.searchPageProductCategory param:" + JSON.toJSONString(pageQuery));
        PageListResult<ProductCategory> result = new PageListResult<ProductCategory>();
        try {
            result = productCategoryManagerImpl.searchPageProductCategoryList(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("result ProductCategoryServiceImpl.searchPageProductCategory 处理结果:" + JSON.toJSONString(result));
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductCategoryServiceImpl.searchPageProductCategory :" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

    /**
    *
    * @generated
    */
    @Override
    public ListResult<ProductCategory> searchPageProductCategoryById(IdPageQuery<ProductCategoryQuery> idPageQuery){
        LOG.info("request ProductCategoryServiceImpl.searchPageProductCategoryById param:" + JSON.toJSONString(idPageQuery));
        ListResult<ProductCategory> result = new ListResult<>();
        try {
            result = productCategoryManagerImpl.searchPageProductCategoryListById(idPageQuery);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductCategoryServiceImpl.searchPageProductCategoryById :" + JSON.toJSONString(idPageQuery),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getTotalCount(Query<ProductCategoryQuery> query){
        LOG.info("request ProductCategoryServiceImpl.getTotalCount param:" + JSON.toJSONString(query));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = productCategoryManagerImpl.getTotalCount(query);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response ProductCategoryServiceImpl.getTotalCount 处理成功" + JSON.toJSONString(result));
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductCategoryServiceImpl.getTotalCount param:" + JSON.toJSONString(query),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getCount(PageQuery<ProductCategoryQuery> pageQuery){
        LOG.info("request ProductCategoryServiceImpl.getCount param:" + JSON.toJSONString(pageQuery));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = productCategoryManagerImpl.getCount(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response ProductCategoryServiceImpl.getCount 处理结果:");
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductCategoryServiceImpl.getCount param:" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

}
