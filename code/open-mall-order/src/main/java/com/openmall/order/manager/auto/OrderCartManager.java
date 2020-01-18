package com.openmall.order.manager.auto;

import java.util.List;

import com.openmall.order.domain.auto.OrderCart;
import com.openmall.order.domain.auto.OrderCartQuery;
import com.openmall.order.utils.*;

/**
 * 订单购物车
 * @author model-driven
 * @date 2020-01-18
 **/
public interface OrderCartManager {

     /**
     *
     * @auto generated
     */
    int insertOrderCart(OrderCart orderCart);

    /**
     *
     * @auto generated
     */
    int insertBatch(List<OrderCart> orderCartList);

    /**
     *
     * @auto generated
     */
    int deleteById(long id);

    /**
     *
     * @auto generated
     */
    int updateOrderCart(OrderCart orderCart);

    /**
     *
     * @auto generated
     */
    int updateBatch(List<OrderCart> orderCartList);

    /**
     *
     * @auto generated
     */
    OrderCart findById(OrderCart orderCart);

    /**
     *
     * @auto generated
     */
    ListResult<OrderCart> searchOrderCartList(Query<OrderCartQuery> query);

    /**
     *
     * @auto generated
     */
    PageListResult<OrderCart> searchPageOrderCartList(PageQuery<OrderCartQuery> pageQuery);

    /**
    *
    * @auto generated
    */
    ListResult<OrderCart> searchPageOrderCartListById(IdPageQuery<OrderCartQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getTotalCount(Query<OrderCartQuery> query);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getCount(PageQuery<OrderCartQuery> pageQuery);

}
