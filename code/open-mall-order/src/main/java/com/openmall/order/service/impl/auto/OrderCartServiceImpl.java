package com.openmall.order.service.impl.auto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import org.springframework.dao.DuplicateKeyException;

import com.openmall.order.utils.*;

import com.openmall.order.domain.auto.OrderCart;
import com.openmall.order.domain.auto.OrderCartQuery;
import com.openmall.order.manager.auto.OrderCartManager;
import com.openmall.order.service.auto.OrderCartService;

/**
 * 订单购物车
 * @author model-driven
 * @date 2020-01-24
 **/
@Service("orderCartService")
public class OrderCartServiceImpl implements OrderCartService{

    private final static Logger LOG = LoggerFactory.getLogger(OrderCartServiceImpl.class);

    @Autowired
    private OrderCartManager orderCartManagerImpl;

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addOrderCart(OrderCart orderCart) {
        LOG.info("request OrderCartServiceImpl.addOrderCart param:" + JSON.toJSONString(orderCart));
        BasicResult result = new BasicResult();
        try {
            if (orderCart != null) {
                orderCartManagerImpl.insertOrderCart(orderCart);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("orderCart is null");
                LOG.error("------OrderCartServiceImpl.addOrderCart - orderCart is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------OrderCartServiceImpl.addOrderCart 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------OrderCartServiceImpl.addOrderCart 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addBatch(List<OrderCart> orderCartList){
        LOG.info("request OrderCartServiceImpl.addBatch size:" + orderCartList.size());
        BasicResult result = new BasicResult();
        try {
            orderCartManagerImpl.insertBatch(orderCartList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("批量插入成功");
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------orderCartServiceImpl.addBatch 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderCartServiceImpl.addBatch param:" + JSON.toJSONString(orderCartList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addOrUpdate(OrderCart orderCart) {
        LOG.info("request OrderCartServiceImpl.addOrUpdate param:" + JSON.toJSONString(orderCart));
        BasicResult result = new BasicResult();
        try {
            if (orderCart != null) {
                orderCartManagerImpl.insertOrUpdate(orderCart);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("orderCart is null");
                LOG.error("------OrderCartServiceImpl.addOrderCart - orderCart is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------OrderCartServiceImpl.addOrderCart 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------OrderCartServiceImpl.addOrderCart 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult deleteById(long id){
        LOG.info("request OrderCartServiceImpl.deleteBy param:{}",id);
        BasicResult result = new BasicResult();
        try{
            int num = orderCartManagerImpl.deleteById(id);
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
            LOG.error("exception OrderCartServiceImpl.deleteById :{}",id,e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult updateOrderCartById(OrderCart orderCart){
        LOG.info("request OrderCartServiceImpl.modifyOrderCart param:" + JSON.toJSONString(orderCart));
        BasicResult result = new BasicResult();
        try {
            if (orderCart != null) {
                int update = orderCartManagerImpl.updateOrderCart(orderCart);
                if (update > 0) {
                    result.setCode(CodeEnum.SUCCESS.getCode());
                    result.setMsg("编辑成功");
                    LOG.debug("------OrderCartServiceImpl.modifyOrderCart 编辑成功------");
                } else {
                    result.setCode(CodeEnum.FAILED.getCode());
                    result.setMsg("编辑失败，请检查是否指定主键，或者唯一键");
                    LOG.debug("------OrderCartServiceImpl.modifyOrderCart 编辑失败------");
                }
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("orderCart is null");
                LOG.error("------OrderCartServiceImpl.modifyOrderCart - orderCart is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------OrderCartServiceImpl.modifyOrderCart 异常",e);
        } catch (Exception e) {
            LOG.error("------OrderCartServiceImpl.modifyOrderCart 异常",e);
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
    public BasicResult updateBatch(List<OrderCart> orderCartList){
        LOG.info("request OrderCartServiceImpl.modifyBatch size:" + orderCartList.size());
        BasicResult result = new BasicResult();
        try {
            Object count = orderCartManagerImpl.updateBatch(orderCartList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg(String.valueOf(count));
            LOG.info("response OrderCartServiceImpl.modifyBatch 处理成功 updateCount:" + count);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderCartServiceImpl.modifyBatch :" + JSON.toJSONString(orderCartList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public OrderCart searchOrderCartById(Long id){
        try {
            return orderCartManagerImpl.findById(id);
        } catch (Exception e) {
            LOG.error("------OrderCartServiceImpl.searchOrderCartByPriKey 异常", e);
        }
        return null;
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<OrderCart> searchOrderCart(Query<OrderCartQuery> query){
        LOG.info("request OrderCartServiceImpl.searchOrderCart param:" + JSON.toJSONString(query));
        ListResult<OrderCart> result = new ListResult<>();
        try {
            result = orderCartManagerImpl.searchOrderCartList(query);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------OrderCartServiceImpl.searchOrderCart 异常", e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public PageListResult<OrderCart> searchPageOrderCart(PageQuery<OrderCartQuery> pageQuery){
        LOG.info("request OrderCartServiceImpl.searchPageOrderCart param:" + JSON.toJSONString(pageQuery));
        PageListResult<OrderCart> result = new PageListResult<OrderCart>();
        try {
            result = orderCartManagerImpl.searchPageOrderCartList(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("result OrderCartServiceImpl.searchPageOrderCart 处理结果:" + JSON.toJSONString(result));
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderCartServiceImpl.searchPageOrderCart :" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

    /**
    *
    * @generated
    */
    @Override
    public ListResult<OrderCart> searchPageOrderCartById(IdPageQuery<OrderCartQuery> idPageQuery){
        LOG.info("request OrderCartServiceImpl.searchPageOrderCartById param:" + JSON.toJSONString(idPageQuery));
        ListResult<OrderCart> result = new ListResult<>();
        try {
            result = orderCartManagerImpl.searchPageOrderCartListById(idPageQuery);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderCartServiceImpl.searchPageOrderCartById :" + JSON.toJSONString(idPageQuery),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getTotalCount(Query<OrderCartQuery> query){
        LOG.info("request OrderCartServiceImpl.getTotalCount param:" + JSON.toJSONString(query));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = orderCartManagerImpl.getTotalCount(query);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response OrderCartServiceImpl.getTotalCount 处理成功" + JSON.toJSONString(result));
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderCartServiceImpl.getTotalCount param:" + JSON.toJSONString(query),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getCount(PageQuery<OrderCartQuery> pageQuery){
        LOG.info("request OrderCartServiceImpl.getCount param:" + JSON.toJSONString(pageQuery));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = orderCartManagerImpl.getCount(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response OrderCartServiceImpl.getCount 处理结果:");
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderCartServiceImpl.getCount param:" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

}
