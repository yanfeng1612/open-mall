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

import com.openmall.order.domain.auto.OrderMaster;
import com.openmall.order.domain.auto.OrderMasterQuery;
import com.openmall.order.manager.auto.OrderMasterManager;
import com.openmall.order.service.auto.OrderMasterService;

/**
 * 订单master表
 * @author model-driven
 * @date 2020-01-24
 **/
@Service("orderMasterService")
public class OrderMasterServiceImpl implements OrderMasterService{

    private final static Logger LOG = LoggerFactory.getLogger(OrderMasterServiceImpl.class);

    @Autowired
    private OrderMasterManager orderMasterManagerImpl;

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addOrderMaster(OrderMaster orderMaster) {
        LOG.info("request OrderMasterServiceImpl.addOrderMaster param:" + JSON.toJSONString(orderMaster));
        BasicResult result = new BasicResult();
        try {
            if (orderMaster != null) {
                orderMasterManagerImpl.insertOrderMaster(orderMaster);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("orderMaster is null");
                LOG.error("------OrderMasterServiceImpl.addOrderMaster - orderMaster is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------OrderMasterServiceImpl.addOrderMaster 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------OrderMasterServiceImpl.addOrderMaster 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addBatch(List<OrderMaster> orderMasterList){
        LOG.info("request OrderMasterServiceImpl.addBatch size:" + orderMasterList.size());
        BasicResult result = new BasicResult();
        try {
            orderMasterManagerImpl.insertBatch(orderMasterList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("批量插入成功");
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------orderMasterServiceImpl.addBatch 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderMasterServiceImpl.addBatch param:" + JSON.toJSONString(orderMasterList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addOrUpdate(OrderMaster orderMaster) {
        LOG.info("request OrderMasterServiceImpl.addOrUpdate param:" + JSON.toJSONString(orderMaster));
        BasicResult result = new BasicResult();
        try {
            if (orderMaster != null) {
                orderMasterManagerImpl.insertOrUpdate(orderMaster);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("orderMaster is null");
                LOG.error("------OrderMasterServiceImpl.addOrderMaster - orderMaster is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------OrderMasterServiceImpl.addOrderMaster 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------OrderMasterServiceImpl.addOrderMaster 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult deleteById(long id){
        LOG.info("request OrderMasterServiceImpl.deleteBy param:{}",id);
        BasicResult result = new BasicResult();
        try{
            int num = orderMasterManagerImpl.deleteById(id);
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
            LOG.error("exception OrderMasterServiceImpl.deleteById :{}",id,e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult updateOrderMasterById(OrderMaster orderMaster){
        LOG.info("request OrderMasterServiceImpl.modifyOrderMaster param:" + JSON.toJSONString(orderMaster));
        BasicResult result = new BasicResult();
        try {
            if (orderMaster != null) {
                int update = orderMasterManagerImpl.updateOrderMaster(orderMaster);
                if (update > 0) {
                    result.setCode(CodeEnum.SUCCESS.getCode());
                    result.setMsg("编辑成功");
                    LOG.debug("------OrderMasterServiceImpl.modifyOrderMaster 编辑成功------");
                } else {
                    result.setCode(CodeEnum.FAILED.getCode());
                    result.setMsg("编辑失败，请检查是否指定主键，或者唯一键");
                    LOG.debug("------OrderMasterServiceImpl.modifyOrderMaster 编辑失败------");
                }
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("orderMaster is null");
                LOG.error("------OrderMasterServiceImpl.modifyOrderMaster - orderMaster is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------OrderMasterServiceImpl.modifyOrderMaster 异常",e);
        } catch (Exception e) {
            LOG.error("------OrderMasterServiceImpl.modifyOrderMaster 异常",e);
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
    public BasicResult updateBatch(List<OrderMaster> orderMasterList){
        LOG.info("request OrderMasterServiceImpl.modifyBatch size:" + orderMasterList.size());
        BasicResult result = new BasicResult();
        try {
            Object count = orderMasterManagerImpl.updateBatch(orderMasterList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg(String.valueOf(count));
            LOG.info("response OrderMasterServiceImpl.modifyBatch 处理成功 updateCount:" + count);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderMasterServiceImpl.modifyBatch :" + JSON.toJSONString(orderMasterList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public OrderMaster searchOrderMasterById(Long id){
        try {
            return orderMasterManagerImpl.findById(id);
        } catch (Exception e) {
            LOG.error("------OrderMasterServiceImpl.searchOrderMasterByPriKey 异常", e);
        }
        return null;
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<OrderMaster> searchOrderMaster(Query<OrderMasterQuery> query){
        LOG.info("request OrderMasterServiceImpl.searchOrderMaster param:" + JSON.toJSONString(query));
        ListResult<OrderMaster> result = new ListResult<>();
        try {
            result = orderMasterManagerImpl.searchOrderMasterList(query);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------OrderMasterServiceImpl.searchOrderMaster 异常", e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public PageListResult<OrderMaster> searchPageOrderMaster(PageQuery<OrderMasterQuery> pageQuery){
        LOG.info("request OrderMasterServiceImpl.searchPageOrderMaster param:" + JSON.toJSONString(pageQuery));
        PageListResult<OrderMaster> result = new PageListResult<OrderMaster>();
        try {
            result = orderMasterManagerImpl.searchPageOrderMasterList(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("result OrderMasterServiceImpl.searchPageOrderMaster 处理结果:" + JSON.toJSONString(result));
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderMasterServiceImpl.searchPageOrderMaster :" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

    /**
    *
    * @generated
    */
    @Override
    public ListResult<OrderMaster> searchPageOrderMasterById(IdPageQuery<OrderMasterQuery> idPageQuery){
        LOG.info("request OrderMasterServiceImpl.searchPageOrderMasterById param:" + JSON.toJSONString(idPageQuery));
        ListResult<OrderMaster> result = new ListResult<>();
        try {
            result = orderMasterManagerImpl.searchPageOrderMasterListById(idPageQuery);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderMasterServiceImpl.searchPageOrderMasterById :" + JSON.toJSONString(idPageQuery),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getTotalCount(Query<OrderMasterQuery> query){
        LOG.info("request OrderMasterServiceImpl.getTotalCount param:" + JSON.toJSONString(query));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = orderMasterManagerImpl.getTotalCount(query);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response OrderMasterServiceImpl.getTotalCount 处理成功" + JSON.toJSONString(result));
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderMasterServiceImpl.getTotalCount param:" + JSON.toJSONString(query),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getCount(PageQuery<OrderMasterQuery> pageQuery){
        LOG.info("request OrderMasterServiceImpl.getCount param:" + JSON.toJSONString(pageQuery));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = orderMasterManagerImpl.getCount(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response OrderMasterServiceImpl.getCount 处理结果:");
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderMasterServiceImpl.getCount param:" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

}
