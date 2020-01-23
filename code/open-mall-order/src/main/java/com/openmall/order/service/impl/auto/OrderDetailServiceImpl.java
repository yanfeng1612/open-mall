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

import com.openmall.order.domain.auto.OrderDetail;
import com.openmall.order.domain.auto.OrderDetailQuery;
import com.openmall.order.manager.auto.OrderDetailManager;
import com.openmall.order.service.auto.OrderDetailService;

/**
 * 订单明细表
 * @author model-driven
 * @date 2020-01-24
 **/
@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService{

    private final static Logger LOG = LoggerFactory.getLogger(OrderDetailServiceImpl.class);

    @Autowired
    private OrderDetailManager orderDetailManagerImpl;

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addOrderDetail(OrderDetail orderDetail) {
        LOG.info("request OrderDetailServiceImpl.addOrderDetail param:" + JSON.toJSONString(orderDetail));
        BasicResult result = new BasicResult();
        try {
            if (orderDetail != null) {
                orderDetailManagerImpl.insertOrderDetail(orderDetail);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("orderDetail is null");
                LOG.error("------OrderDetailServiceImpl.addOrderDetail - orderDetail is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------OrderDetailServiceImpl.addOrderDetail 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------OrderDetailServiceImpl.addOrderDetail 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addBatch(List<OrderDetail> orderDetailList){
        LOG.info("request OrderDetailServiceImpl.addBatch size:" + orderDetailList.size());
        BasicResult result = new BasicResult();
        try {
            orderDetailManagerImpl.insertBatch(orderDetailList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("批量插入成功");
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------orderDetailServiceImpl.addBatch 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderDetailServiceImpl.addBatch param:" + JSON.toJSONString(orderDetailList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addOrUpdate(OrderDetail orderDetail) {
        LOG.info("request OrderDetailServiceImpl.addOrUpdate param:" + JSON.toJSONString(orderDetail));
        BasicResult result = new BasicResult();
        try {
            if (orderDetail != null) {
                orderDetailManagerImpl.insertOrUpdate(orderDetail);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("orderDetail is null");
                LOG.error("------OrderDetailServiceImpl.addOrderDetail - orderDetail is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------OrderDetailServiceImpl.addOrderDetail 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------OrderDetailServiceImpl.addOrderDetail 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult deleteById(long id){
        LOG.info("request OrderDetailServiceImpl.deleteBy param:{}",id);
        BasicResult result = new BasicResult();
        try{
            int num = orderDetailManagerImpl.deleteById(id);
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
            LOG.error("exception OrderDetailServiceImpl.deleteById :{}",id,e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult updateOrderDetailById(OrderDetail orderDetail){
        LOG.info("request OrderDetailServiceImpl.modifyOrderDetail param:" + JSON.toJSONString(orderDetail));
        BasicResult result = new BasicResult();
        try {
            if (orderDetail != null) {
                int update = orderDetailManagerImpl.updateOrderDetail(orderDetail);
                if (update > 0) {
                    result.setCode(CodeEnum.SUCCESS.getCode());
                    result.setMsg("编辑成功");
                    LOG.debug("------OrderDetailServiceImpl.modifyOrderDetail 编辑成功------");
                } else {
                    result.setCode(CodeEnum.FAILED.getCode());
                    result.setMsg("编辑失败，请检查是否指定主键，或者唯一键");
                    LOG.debug("------OrderDetailServiceImpl.modifyOrderDetail 编辑失败------");
                }
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("orderDetail is null");
                LOG.error("------OrderDetailServiceImpl.modifyOrderDetail - orderDetail is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------OrderDetailServiceImpl.modifyOrderDetail 异常",e);
        } catch (Exception e) {
            LOG.error("------OrderDetailServiceImpl.modifyOrderDetail 异常",e);
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
    public BasicResult updateBatch(List<OrderDetail> orderDetailList){
        LOG.info("request OrderDetailServiceImpl.modifyBatch size:" + orderDetailList.size());
        BasicResult result = new BasicResult();
        try {
            Object count = orderDetailManagerImpl.updateBatch(orderDetailList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg(String.valueOf(count));
            LOG.info("response OrderDetailServiceImpl.modifyBatch 处理成功 updateCount:" + count);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderDetailServiceImpl.modifyBatch :" + JSON.toJSONString(orderDetailList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public OrderDetail searchOrderDetailById(Long id){
        try {
            return orderDetailManagerImpl.findById(id);
        } catch (Exception e) {
            LOG.error("------OrderDetailServiceImpl.searchOrderDetailByPriKey 异常", e);
        }
        return null;
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<OrderDetail> searchOrderDetail(Query<OrderDetailQuery> query){
        LOG.info("request OrderDetailServiceImpl.searchOrderDetail param:" + JSON.toJSONString(query));
        ListResult<OrderDetail> result = new ListResult<>();
        try {
            result = orderDetailManagerImpl.searchOrderDetailList(query);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------OrderDetailServiceImpl.searchOrderDetail 异常", e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public PageListResult<OrderDetail> searchPageOrderDetail(PageQuery<OrderDetailQuery> pageQuery){
        LOG.info("request OrderDetailServiceImpl.searchPageOrderDetail param:" + JSON.toJSONString(pageQuery));
        PageListResult<OrderDetail> result = new PageListResult<OrderDetail>();
        try {
            result = orderDetailManagerImpl.searchPageOrderDetailList(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("result OrderDetailServiceImpl.searchPageOrderDetail 处理结果:" + JSON.toJSONString(result));
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderDetailServiceImpl.searchPageOrderDetail :" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

    /**
    *
    * @generated
    */
    @Override
    public ListResult<OrderDetail> searchPageOrderDetailById(IdPageQuery<OrderDetailQuery> idPageQuery){
        LOG.info("request OrderDetailServiceImpl.searchPageOrderDetailById param:" + JSON.toJSONString(idPageQuery));
        ListResult<OrderDetail> result = new ListResult<>();
        try {
            result = orderDetailManagerImpl.searchPageOrderDetailListById(idPageQuery);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderDetailServiceImpl.searchPageOrderDetailById :" + JSON.toJSONString(idPageQuery),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getTotalCount(Query<OrderDetailQuery> query){
        LOG.info("request OrderDetailServiceImpl.getTotalCount param:" + JSON.toJSONString(query));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = orderDetailManagerImpl.getTotalCount(query);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response OrderDetailServiceImpl.getTotalCount 处理成功" + JSON.toJSONString(result));
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderDetailServiceImpl.getTotalCount param:" + JSON.toJSONString(query),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getCount(PageQuery<OrderDetailQuery> pageQuery){
        LOG.info("request OrderDetailServiceImpl.getCount param:" + JSON.toJSONString(pageQuery));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = orderDetailManagerImpl.getCount(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response OrderDetailServiceImpl.getCount 处理结果:");
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception OrderDetailServiceImpl.getCount param:" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

}
