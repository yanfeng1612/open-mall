package com.openmall.order.manager.auto;

import java.util.List;

import com.openmall.order.domain.auto.OrderDetail;
import com.openmall.order.domain.auto.OrderDetailQuery;
import com.openmall.order.utils.*;

/**
 * 订单明细表
 * @author model-driven
 * @date 2020-01-24
 **/
public interface OrderDetailManager {

     /**
     *
     * @auto generated
     */
    int insertOrderDetail(OrderDetail orderDetail);

    /**
     *
     * @auto generated
     */
    int insertBatch(List<OrderDetail> orderDetailList);

    /**
     *
     * @auto generated
     */
    int insertOrUpdate(OrderDetail orderDetail);

    /**
     *
     * @auto generated
     */
    int deleteById(long id);

    /**
     *
     * @auto generated
     */
    int updateOrderDetail(OrderDetail orderDetail);

    /**
     *
     * @auto generated
     */
    int updateBatch(List<OrderDetail> orderDetailList);

    /**
     *
     * @auto generated
     */
    OrderDetail findById(Long id);

    /**
     *
     * @auto generated
     */
    ListResult<OrderDetail> searchOrderDetailList(Query<OrderDetailQuery> query);

    /**
     *
     * @auto generated
     */
    PageListResult<OrderDetail> searchPageOrderDetailList(PageQuery<OrderDetailQuery> pageQuery);

    /**
    *
    * @auto generated
    */
    ListResult<OrderDetail> searchPageOrderDetailListById(IdPageQuery<OrderDetailQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getTotalCount(Query<OrderDetailQuery> query);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getCount(PageQuery<OrderDetailQuery> pageQuery);

}
