package com.openmall.order.manager.impl.auto;

import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

import com.openmall.order.domain.auto.OrderMaster;
import com.openmall.order.domain.auto.OrderMasterQuery;
import com.openmall.order.dao.auto.OrderMasterMapper;
import com.openmall.order.manager.auto.OrderMasterManager;

import com.openmall.order.utils.*;

/**
 * 订单master表
 * @author model-driven
 * @date 2020-01-24
 **/
@Component("orderMasterManager")
public class OrderMasterManagerImpl implements OrderMasterManager {

    private final static Logger logger = LoggerFactory.getLogger(OrderMasterManagerImpl.class);

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    /**
     *
     * @generated
     */
    @Override
    public int insertOrderMaster(OrderMaster orderMaster) {
        return orderMasterMapper.insert(orderMaster);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertBatch(List<OrderMaster> orderMasterList){
        return orderMasterMapper.insertBatch(orderMasterList);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertOrUpdate(OrderMaster orderMaster){
        return orderMasterMapper.insertOrUpdate(orderMaster);
    }

    /**
     *
     * @generated
     */
    @Override
    public int deleteById(long id){
        return orderMasterMapper.deleteById(id);
    }

     /**
     *
     * @generated
     */
    @Override
    public int updateOrderMaster(OrderMaster orderMaster) {
        return orderMasterMapper.update(orderMaster);
    }

    /**
     *
     * @generated
     */
    @Transactional
    @Override
    public int updateBatch(List<OrderMaster> orderMasterList){
        int result = 0;
        for(OrderMaster item : orderMasterList){
            int count = orderMasterMapper.update(item);
            result += count;
        }
        return result;
    }

    @Override
    public OrderMaster findById(Long id){
        return orderMasterMapper.findById(id);
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<OrderMaster> searchOrderMasterList(Query<OrderMasterQuery> query) {
        List<OrderMaster> list = orderMasterMapper.getAllList(query);
        ListResult<OrderMaster> result = new ListResult<OrderMaster>();
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
    public PageListResult<OrderMaster> searchPageOrderMasterList(PageQuery<OrderMasterQuery> pageQuery) {
        long count = orderMasterMapper.getCount(pageQuery);
        PageQueryWrapper<OrderMasterQuery> wrapper = new PageQueryWrapper<OrderMasterQuery>(pageQuery.getPageNo(),pageQuery.getPageSize(),count,pageQuery.getQuery());
        List<OrderMaster> itemList = orderMasterMapper.getPagenationList(wrapper);
        PageListResult<OrderMaster> retValue = new PageListResult<>();
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
    public ListResult<OrderMaster> searchPageOrderMasterListById(IdPageQuery<OrderMasterQuery> idPageQuery) {
        List<OrderMaster> itemList = orderMasterMapper.getPagenationListById(idPageQuery);
        ListResult<OrderMaster> retValue = new ListResult<OrderMaster>();
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
    public GenericResult<Long> getTotalCount(Query<OrderMasterQuery> query){
        long count = orderMasterMapper.getTotalCount(query);
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
    public GenericResult<Long> getCount(PageQuery<OrderMasterQuery> pageQuery){
        long count = orderMasterMapper.getCount(pageQuery);
        GenericResult<Long> result = new GenericResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        return result;
    }

}
