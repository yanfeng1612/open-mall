package com.openmall.order.service.auto;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

import com.openmall.order.utils.*;

import com.openmall.order.domain.auto.OrderCart;
import com.openmall.order.domain.auto.OrderCartQuery;

/**
 * 订单购物车
 * @author model-driven
 * @date 2020-01-18
 **/
public interface OrderCartService {

    /**
     *
     * @generated
     */
    BasicResult addOrderCart(OrderCart orderCart);

    /**
     *
     * @generated
     */
    BasicResult addBatch(List<OrderCart> orderCartList);

    /**
     *
     * @generated
     */
    BasicResult deleteById(long id);

    /**
     *
     * @generated
     */
    BasicResult updateOrderCartById(OrderCart orderCart);

    /**
     *
     * @generated
     */
    BasicResult updateBatch(List<OrderCart> orderCartList);

    /**
     *
     * @generated
     */
    OrderCart searchOrderCartById(OrderCart orderCart);

    /**
     *
     * @generated
     */
    ListResult<OrderCart> searchOrderCart(Query<OrderCartQuery> query);

    /**
     *
     * @generated
     */
    PageListResult<OrderCart> searchPageOrderCart(PageQuery<OrderCartQuery> pageQuery);

    /**
    *
    * @generated
    */
    ListResult<OrderCart> searchPageOrderCartById(IdPageQuery<OrderCartQuery> idPageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getCount(PageQuery<OrderCartQuery> pageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getTotalCount(Query<OrderCartQuery> query);

}
