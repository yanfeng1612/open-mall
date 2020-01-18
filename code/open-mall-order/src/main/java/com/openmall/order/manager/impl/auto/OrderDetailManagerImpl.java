package com.openmall.order.manager.impl.auto;

import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

import com.openmall.order.domain.auto.OrderDetail;
import com.openmall.order.domain.auto.OrderDetailQuery;
import com.openmall.order.dao.auto.OrderDetailMapper;
import com.openmall.order.manager.auto.OrderDetailManager;

import com.openmall.order.utils.*;

/**
 * 订单明细表
 * @author model-driven
 * @date 2020-01-18
 **/
@Component("orderDetailManager")
public class OrderDetailManagerImpl implements OrderDetailManager {

    private final static Logger logger = LoggerFactory.getLogger(OrderDetailManagerImpl.class);

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     *
     * @generated
     */
    @Override
    public int insertOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.insert(orderDetail);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertBatch(List<OrderDetail> orderDetailList){
        return orderDetailMapper.insertBatch(orderDetailList);
    }

    /**
     *
     * @generated
     */
    @Override
    public int deleteById(long id){
        return orderDetailMapper.deleteById(id);
    }

     /**
     *
     * @generated
     */
    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.update(orderDetail);
    }

    /**
     *
     * @generated
     */
    @Transactional
    @Override
    public int updateBatch(List<OrderDetail> orderDetailList){
        int result = 0;
        for(OrderDetail item : orderDetailList){
            int count = orderDetailMapper.update(item);
            result += count;
        }
        return result;
    }

    @Override
    public OrderDetail findById(OrderDetail orderDetail){
        return orderDetailMapper.findById(orderDetail);
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<OrderDetail> searchOrderDetailList(Query<OrderDetailQuery> query) {
        List<OrderDetail> list = orderDetailMapper.getAllList(query);
        ListResult<OrderDetail> result = new ListResult<OrderDetail>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValues(list);
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public PageListResult<OrderDetail> searchPageOrderDetailList(PageQuery<OrderDetailQuery> pageQuery) {
        long count = orderDetailMapper.getCount(pageQuery);
        PageQueryWrapper<OrderDetailQuery> wrapper = new PageQueryWrapper<OrderDetailQuery>(pageQuery.getPageNo(),pageQuery.getPageSize(),count,pageQuery.getQuery());
        List<OrderDetail> itemList = orderDetailMapper.getPagenationList(wrapper);
        PageListResult<OrderDetail> retValue = new PageListResult<>();
        retValue.setMsg("查询成功");
        retValue.setCode(CodeEnum.SUCCESS.getCode());
        retValue.setValues(itemList);
        long currentPage = pageQuery.getPageNo() > 1 ? pageQuery.getPageNo() : 1;
        Pagenation pagenation = new Pagenation(currentPage, count, pageQuery.getPageSize());
        retValue.setPagenation(pagenation);
        return retValue;
    }

    /**
    *
    * @generated
    */
    @Override
    public ListResult<OrderDetail> searchPageOrderDetailListById(IdPageQuery<OrderDetailQuery> idPageQuery) {
        List<OrderDetail> itemList = orderDetailMapper.getPagenationListById(idPageQuery);
        ListResult<OrderDetail> retValue = new ListResult<OrderDetail>();
        retValue.setMsg("查询成功");
        retValue.setCode(CodeEnum.SUCCESS.getCode());
        retValue.setValues(itemList);
        return retValue;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getTotalCount(Query<OrderDetailQuery> query){
        long count = orderDetailMapper.getTotalCount(query);
        GenericResult<Long> result = new GenericResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getCount(PageQuery<OrderDetailQuery> pageQuery){
        long count = orderDetailMapper.getCount(pageQuery);
        GenericResult<Long> result = new GenericResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        return result;
    }

}
