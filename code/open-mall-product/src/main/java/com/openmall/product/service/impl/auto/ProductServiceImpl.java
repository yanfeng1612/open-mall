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

import com.openmall.product.domain.auto.Product;
import com.openmall.product.domain.auto.ProductQuery;
import com.openmall.product.manager.auto.ProductManager;
import com.openmall.product.service.auto.ProductService;

/**
 * 商品基本属性表
 * @author model-driven
 * @date 2020-01-18
 **/
@Service("productService")
public class ProductServiceImpl implements ProductService{

    private final static Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductManager productManagerImpl;

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addProduct(Product product) {
        LOG.info("request ProductServiceImpl.addProduct param:" + JSON.toJSONString(product));
        BasicResult result = new BasicResult();
        try {
            if (product != null) {
                productManagerImpl.insertProduct(product);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("product is null");
                LOG.error("------ProductServiceImpl.addProduct - product is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------ProductServiceImpl.addProduct 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------ProductServiceImpl.addProduct 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addBatch(List<Product> productList){
        LOG.info("request ProductServiceImpl.addBatch size:" + productList.size());
        BasicResult result = new BasicResult();
        try {
            productManagerImpl.insertBatch(productList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("批量插入成功");
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------productServiceImpl.addBatch 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductServiceImpl.addBatch param:" + JSON.toJSONString(productList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult deleteById(long id){
        LOG.info("request ProductServiceImpl.deleteBy param:{}",id);
        BasicResult result = new BasicResult();
        try{
            int num = productManagerImpl.deleteById(id);
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
            LOG.error("exception ProductServiceImpl.deleteById :{}",id,e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult updateProductById(Product product){
        LOG.info("request ProductServiceImpl.modifyProduct param:" + JSON.toJSONString(product));
        BasicResult result = new BasicResult();
        try {
            if (product != null) {
                int update = productManagerImpl.updateProduct(product);
                if (update > 0) {
                    result.setCode(CodeEnum.SUCCESS.getCode());
                    result.setMsg("编辑成功");
                    LOG.debug("------ProductServiceImpl.modifyProduct 编辑成功------");
                } else {
                    result.setCode(CodeEnum.FAILED.getCode());
                    result.setMsg("编辑失败，请检查是否指定主键，或者唯一键");
                    LOG.debug("------ProductServiceImpl.modifyProduct 编辑失败------");
                }
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("product is null");
                LOG.error("------ProductServiceImpl.modifyProduct - product is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------ProductServiceImpl.modifyProduct 异常",e);
        } catch (Exception e) {
            LOG.error("------ProductServiceImpl.modifyProduct 异常",e);
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
    public BasicResult updateBatch(List<Product> productList){
        LOG.info("request ProductServiceImpl.modifyBatch size:" + productList.size());
        BasicResult result = new BasicResult();
        try {
            Object count = productManagerImpl.updateBatch(productList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg(String.valueOf(count));
            LOG.info("response ProductServiceImpl.modifyBatch 处理成功 updateCount:" + count);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductServiceImpl.modifyBatch :" + JSON.toJSONString(productList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public Product searchProductById(Product product){
        try {
            return productManagerImpl.findById(product);
        } catch (Exception e) {
            LOG.error("------ProductServiceImpl.searchProductByPriKey 异常", e);
        }
        return null;
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<Product> searchProduct(Query<ProductQuery> query){
        LOG.info("request ProductServiceImpl.searchProduct param:" + JSON.toJSONString(query));
        ListResult<Product> result = new ListResult<>();
        try {
            result = productManagerImpl.searchProductList(query);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------ProductServiceImpl.searchProduct 异常", e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public PageListResult<Product> searchPageProduct(PageQuery<ProductQuery> pageQuery){
        LOG.info("request ProductServiceImpl.searchPageProduct param:" + JSON.toJSONString(pageQuery));
        PageListResult<Product> result = new PageListResult<Product>();
        try {
            result = productManagerImpl.searchPageProductList(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("result ProductServiceImpl.searchPageProduct 处理结果:" + JSON.toJSONString(result));
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductServiceImpl.searchPageProduct :" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

    /**
    *
    * @generated
    */
    @Override
    public ListResult<Product> searchPageProductById(IdPageQuery<ProductQuery> idPageQuery){
        LOG.info("request ProductServiceImpl.searchPageProductById param:" + JSON.toJSONString(idPageQuery));
        ListResult<Product> result = new ListResult<>();
        try {
            result = productManagerImpl.searchPageProductListById(idPageQuery);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductServiceImpl.searchPageProductById :" + JSON.toJSONString(idPageQuery),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getTotalCount(Query<ProductQuery> query){
        LOG.info("request ProductServiceImpl.getTotalCount param:" + JSON.toJSONString(query));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = productManagerImpl.getTotalCount(query);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response ProductServiceImpl.getTotalCount 处理成功" + JSON.toJSONString(result));
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductServiceImpl.getTotalCount param:" + JSON.toJSONString(query),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getCount(PageQuery<ProductQuery> pageQuery){
        LOG.info("request ProductServiceImpl.getCount param:" + JSON.toJSONString(pageQuery));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = productManagerImpl.getCount(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response ProductServiceImpl.getCount 处理结果:");
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductServiceImpl.getCount param:" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

}
