package com.openmall.order.manager.auto;

import java.util.List;

import com.openmall.order.domain.auto.OrderMaster;
import com.openmall.order.domain.auto.OrderMasterQuery;
import com.openmall.order.utils.*;

/**
 * 订单master表
 * @author model-driven
 * @date 2020-01-18
 **/
public interface OrderMasterManager {

     /**
     *
     * @auto generated
     */
    int insertOrderMaster(OrderMaster orderMaster);

    /**
     *
     * @auto generated
     */
    int insertBatch(List<OrderMaster> orderMasterList);

    /**
     *
     * @auto generated
     */
    int deleteById(long id);

    /**
     *
     * @auto generated
     */
    int updateOrderMaster(OrderMaster orderMaster);

    /**
     *
     * @auto generated
     */
    int updateBatch(List<OrderMaster> orderMasterList);

    /**
     *
     * @auto generated
     */
    OrderMaster findById(OrderMaster orderMaster);

    /**
     *
     * @auto generated
     */
    ListResult<OrderMaster> searchOrderMasterList(Query<OrderMasterQuery> query);

    /**
     *
     * @auto generated
     */
    PageListResult<OrderMaster> searchPageOrderMasterList(PageQuery<OrderMasterQuery> pageQuery);

    /**
    *
    * @auto generated
    */
    ListResult<OrderMaster> searchPageOrderMasterListById(IdPageQuery<OrderMasterQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getTotalCount(Query<OrderMasterQuery> query);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getCount(PageQuery<OrderMasterQuery> pageQuery);

}
