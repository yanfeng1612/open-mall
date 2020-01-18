package com.openmall.order.dao.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.openmall.order.domain.auto.OrderCart;
import com.openmall.order.domain.auto.OrderCartQuery;
import com.openmall.order.utils.*;

/**
 * 订单购物车
 * @author model-driven
 * @date 2020-01-18
 **/
public interface OrderCartMapper {

    /**
     *
     * @auto generated
     */
    int insert(OrderCart orderCart);

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
    int update(OrderCart orderCart);

    /**
     *
     * @auto generated
     */
    OrderCart findById(OrderCart orderCart);

    /**
     *
     * @auto generated
     */
    List<OrderCart> getAllList(Query<OrderCartQuery> query);

    /**
     *
     * @auto generated
     */
    List<OrderCart> getPagenationList(PageQuery<OrderCartQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    List<OrderCart> getPagenationListById(IdPageQuery<OrderCartQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    long getCount(PageQuery<OrderCartQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    long getTotalCount(Query<OrderCartQuery> query);

}
