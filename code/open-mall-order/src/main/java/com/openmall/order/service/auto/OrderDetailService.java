package com.openmall.order.service.auto;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

import com.openmall.order.utils.*;

import com.openmall.order.domain.auto.OrderDetail;
import com.openmall.order.domain.auto.OrderDetailQuery;

/**
 * 订单明细表
 * @author model-driven
 * @date 2020-01-24
 **/
public interface OrderDetailService {

    /**
     *
     * @generated
     */
    BasicResult addOrderDetail(OrderDetail orderDetail);

    /**
     *
     * @generated
     */
    BasicResult addBatch(List<OrderDetail> orderDetailList);

    /**
     *
     * @generated
     */
    BasicResult addOrUpdate(OrderDetail orderDetail);

    /**
     *
     * @generated
     */
    BasicResult deleteById(long id);

    /**
     *
     * @generated
     */
    BasicResult updateOrderDetailById(OrderDetail orderDetail);

    /**
     *
     * @generated
     */
    BasicResult updateBatch(List<OrderDetail> orderDetailList);

    /**
     *
     * @generated
     */
    OrderDetail searchOrderDetailById(Long id);

    /**
     *
     * @generated
     */
    ListResult<OrderDetail> searchOrderDetail(Query<OrderDetailQuery> query);

    /**
     *
     * @generated
     */
    PageListResult<OrderDetail> searchPageOrderDetail(PageQuery<OrderDetailQuery> pageQuery);

    /**
    *
    * @generated
    */
    ListResult<OrderDetail> searchPageOrderDetailById(IdPageQuery<OrderDetailQuery> idPageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getCount(PageQuery<OrderDetailQuery> pageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getTotalCount(Query<OrderDetailQuery> query);

}
