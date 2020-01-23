package com.openmall.order.dao.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.openmall.order.domain.auto.OrderDetail;
import com.openmall.order.domain.auto.OrderDetailQuery;
import com.openmall.order.utils.*;

/**
 * 订单明细表
 * @author model-driven
 * @date 2020-01-24
 **/
public interface OrderDetailMapper {

    /**
     *
     * @auto generated
     */
    int insert(OrderDetail orderDetail);

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
    int update(OrderDetail orderDetail);

    /**
     *
     * @auto generated
     */
    OrderDetail findById(Long id);

    /**
     *
     * @auto generated
     */
    List<OrderDetail> getAllList(Query<OrderDetailQuery> query);

    /**
     *
     * @auto generated
     */
    List<OrderDetail> getPagenationList(PageQuery<OrderDetailQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    List<OrderDetail> getPagenationListById(IdPageQuery<OrderDetailQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    long getCount(PageQuery<OrderDetailQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    long getTotalCount(Query<OrderDetailQuery> query);

}
