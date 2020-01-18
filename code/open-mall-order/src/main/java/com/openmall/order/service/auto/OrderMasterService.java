package com.openmall.order.service.auto;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

import com.openmall.order.utils.*;

import com.openmall.order.domain.auto.OrderMaster;
import com.openmall.order.domain.auto.OrderMasterQuery;

/**
 * 订单master表
 * @author model-driven
 * @date 2020-01-18
 **/
public interface OrderMasterService {

    /**
     *
     * @generated
     */
    BasicResult addOrderMaster(OrderMaster orderMaster);

    /**
     *
     * @generated
     */
    BasicResult addBatch(List<OrderMaster> orderMasterList);

    /**
     *
     * @generated
     */
    BasicResult deleteById(long id);

    /**
     *
     * @generated
     */
    BasicResult updateOrderMasterById(OrderMaster orderMaster);

    /**
     *
     * @generated
     */
    BasicResult updateBatch(List<OrderMaster> orderMasterList);

    /**
     *
     * @generated
     */
    OrderMaster searchOrderMasterById(OrderMaster orderMaster);

    /**
     *
     * @generated
     */
    ListResult<OrderMaster> searchOrderMaster(Query<OrderMasterQuery> query);

    /**
     *
     * @generated
     */
    PageListResult<OrderMaster> searchPageOrderMaster(PageQuery<OrderMasterQuery> pageQuery);

    /**
    *
    * @generated
    */
    ListResult<OrderMaster> searchPageOrderMasterById(IdPageQuery<OrderMasterQuery> idPageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getCount(PageQuery<OrderMasterQuery> pageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getTotalCount(Query<OrderMasterQuery> query);

}
