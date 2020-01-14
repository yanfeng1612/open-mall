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

import com.openmall.product.domain.auto.ProductBrand;
import com.openmall.product.domain.auto.ProductBrandQuery;
import com.openmall.product.manager.auto.ProductBrandManager;
import com.openmall.product.service.auto.ProductBrandService;

/**
 * 商品品牌表
 * @author model-driven
 * @date 2020-01-14
 **/
@Service("productBrandService")
public class ProductBrandServiceImpl implements ProductBrandService{

    private final static Logger LOG = LoggerFactory.getLogger(ProductBrandServiceImpl.class);

    @Autowired
    private ProductBrandManager productBrandManagerImpl;

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addProductBrand(ProductBrand productBrand) {
        LOG.info("request ProductBrandServiceImpl.addProductBrand param:" + JSON.toJSONString(productBrand));
        BasicResult result = new BasicResult();
        try {
            if (productBrand != null) {
                productBrandManagerImpl.insertProductBrand(productBrand);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("productBrand is null");
                LOG.error("------ProductBrandServiceImpl.addProductBrand - productBrand is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------ProductBrandServiceImpl.addProductBrand 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------ProductBrandServiceImpl.addProductBrand 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addBatch(List<ProductBrand> productBrandList){
        LOG.info("request ProductBrandServiceImpl.addBatch size:" + productBrandList.size());
        BasicResult result = new BasicResult();
        try {
            productBrandManagerImpl.insertBatch(productBrandList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("批量插入成功");
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------productBrandServiceImpl.addBatch 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductBrandServiceImpl.addBatch param:" + JSON.toJSONString(productBrandList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult deleteById(long id){
        LOG.info("request ProductBrandServiceImpl.deleteBy param:{}",id);
        BasicResult result = new BasicResult();
        try{
            int num = productBrandManagerImpl.deleteById(id);
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
            LOG.error("exception ProductBrandServiceImpl.deleteById :{}",id,e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult updateProductBrandById(ProductBrand productBrand){
        LOG.info("request ProductBrandServiceImpl.modifyProductBrand param:" + JSON.toJSONString(productBrand));
        BasicResult result = new BasicResult();
        try {
            if (productBrand != null) {
                int update = productBrandManagerImpl.updateProductBrand(productBrand);
                if (update > 0) {
                    result.setCode(CodeEnum.SUCCESS.getCode());
                    result.setMsg("编辑成功");
                    LOG.debug("------ProductBrandServiceImpl.modifyProductBrand 编辑成功------");
                } else {
                    result.setCode(CodeEnum.FAILED.getCode());
                    result.setMsg("编辑失败，请检查是否指定主键，或者唯一键");
                    LOG.debug("------ProductBrandServiceImpl.modifyProductBrand 编辑失败------");
                }
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("productBrand is null");
                LOG.error("------ProductBrandServiceImpl.modifyProductBrand - productBrand is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------ProductBrandServiceImpl.modifyProductBrand 异常",e);
        } catch (Exception e) {
            LOG.error("------ProductBrandServiceImpl.modifyProductBrand 异常",e);
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
    public BasicResult updateBatch(List<ProductBrand> productBrandList){
        LOG.info("request ProductBrandServiceImpl.modifyBatch size:" + productBrandList.size());
        BasicResult result = new BasicResult();
        try {
            Object count = productBrandManagerImpl.updateBatch(productBrandList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg(String.valueOf(count));
            LOG.info("response ProductBrandServiceImpl.modifyBatch 处理成功 updateCount:" + count);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductBrandServiceImpl.modifyBatch :" + JSON.toJSONString(productBrandList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public ProductBrand searchProductBrandById(ProductBrand productBrand){
        try {
            return productBrandManagerImpl.findById(productBrand);
        } catch (Exception e) {
            LOG.error("------ProductBrandServiceImpl.searchProductBrandByPriKey 异常", e);
        }
        return null;
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<ProductBrand> searchProductBrand(Query<ProductBrandQuery> query){
        LOG.info("request ProductBrandServiceImpl.searchProductBrand param:" + JSON.toJSONString(query));
        ListResult<ProductBrand> result = new ListResult<>();
        try {
            result = productBrandManagerImpl.searchProductBrandList(query);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------ProductBrandServiceImpl.searchProductBrand 异常", e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public PageListResult<ProductBrand> searchPageProductBrand(PageQuery<ProductBrandQuery> pageQuery){
        LOG.info("request ProductBrandServiceImpl.searchPageProductBrand param:" + JSON.toJSONString(pageQuery));
        PageListResult<ProductBrand> result = new PageListResult<ProductBrand>();
        try {
            result = productBrandManagerImpl.searchPageProductBrandList(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("result ProductBrandServiceImpl.searchPageProductBrand 处理结果:" + JSON.toJSONString(result));
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductBrandServiceImpl.searchPageProductBrand :" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

    /**
    *
    * @generated
    */
    @Override
    public ListResult<ProductBrand> searchPageProductBrandById(IdPageQuery<ProductBrandQuery> idPageQuery){
        LOG.info("request ProductBrandServiceImpl.searchPageProductBrandById param:" + JSON.toJSONString(idPageQuery));
        ListResult<ProductBrand> result = new ListResult<>();
        try {
            result = productBrandManagerImpl.searchPageProductBrandListById(idPageQuery);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductBrandServiceImpl.searchPageProductBrandById :" + JSON.toJSONString(idPageQuery),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getTotalCount(Query<ProductBrandQuery> query){
        LOG.info("request ProductBrandServiceImpl.getTotalCount param:" + JSON.toJSONString(query));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = productBrandManagerImpl.getTotalCount(query);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response ProductBrandServiceImpl.getTotalCount 处理成功" + JSON.toJSONString(result));
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductBrandServiceImpl.getTotalCount param:" + JSON.toJSONString(query),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getCount(PageQuery<ProductBrandQuery> pageQuery){
        LOG.info("request ProductBrandServiceImpl.getCount param:" + JSON.toJSONString(pageQuery));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = productBrandManagerImpl.getCount(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response ProductBrandServiceImpl.getCount 处理结果:");
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception ProductBrandServiceImpl.getCount param:" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

}
