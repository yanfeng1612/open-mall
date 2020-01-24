package com.openmall.order.dao.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.openmall.order.domain.auto.OrderMaster;
import com.openmall.order.domain.auto.OrderMasterQuery;
import com.openmall.order.utils.*;

/**
 * 订单master表
 * @author model-driven
 * @date 2020-01-24
 **/
public interface OrderMasterMapper {

    /**
     *
     * @auto generated
     */
    int insert(OrderMaster orderMaster);

    /**
     *
     * @auto generated
     */
    int insertBatch(List<OrderMaster> orderMasterList);

    /**
     *
     * @auto generated
     */
    int insertOrUpdate(OrderMaster orderMaster);

    /**
     *
     * @auto generated
     */
    int deleteById(long id);

    /**
     *
     * @auto generated
     */
    int update(OrderMaster orderMaster);

    /**
     *
     * @auto generated
     */
    OrderMaster findById(Long id);

    /**
     *
     * @auto generated
     */
    List<OrderMaster> getAllList(Query<OrderMasterQuery> query);

    /**
     *
     * @auto generated
     */
    List<OrderMaster> getPagenationList(PageQuery<OrderMasterQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    List<OrderMaster> getPagenationListById(IdPageQuery<OrderMasterQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    long getCount(PageQuery<OrderMasterQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    long getTotalCount(Query<OrderMasterQuery> query);

}
