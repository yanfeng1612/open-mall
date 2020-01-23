package com.openmall.order.manager.impl.auto;

import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

import com.openmall.order.domain.auto.OrderCart;
import com.openmall.order.domain.auto.OrderCartQuery;
import com.openmall.order.dao.auto.OrderCartMapper;
import com.openmall.order.manager.auto.OrderCartManager;

import com.openmall.order.utils.*;

/**
 * 订单购物车
 * @author model-driven
 * @date 2020-01-24
 **/
@Component("orderCartManager")
public class OrderCartManagerImpl implements OrderCartManager {

    private final static Logger logger = LoggerFactory.getLogger(OrderCartManagerImpl.class);

    @Autowired
    private OrderCartMapper orderCartMapper;

    /**
     *
     * @generated
     */
    @Override
    public int insertOrderCart(OrderCart orderCart) {
        return orderCartMapper.insert(orderCart);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertBatch(List<OrderCart> orderCartList){
        return orderCartMapper.insertBatch(orderCartList);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertOrUpdate(OrderCart orderCart){
        return orderCartMapper.insertOrUpdate(orderCart);
    }

    /**
     *
     * @generated
     */
    @Override
    public int deleteById(long id){
        return orderCartMapper.deleteById(id);
    }

     /**
     *
     * @generated
     */
    @Override
    public int updateOrderCart(OrderCart orderCart) {
        return orderCartMapper.update(orderCart);
    }

    /**
     *
     * @generated
     */
    @Transactional
    @Override
    public int updateBatch(List<OrderCart> orderCartList){
        int result = 0;
        for(OrderCart item : orderCartList){
            int count = orderCartMapper.update(item);
            result += count;
        }
        return result;
    }

    @Override
    public OrderCart findById(Long id){
        return orderCartMapper.findById(id);
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<OrderCart> searchOrderCartList(Query<OrderCartQuery> query) {
        List<OrderCart> list = orderCartMapper.getAllList(query);
        ListResult<OrderCart> result = new ListResult<OrderCart>();
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
    public PageListResult<OrderCart> searchPageOrderCartList(PageQuery<OrderCartQuery> pageQuery) {
        long count = orderCartMapper.getCount(pageQuery);
        PageQueryWrapper<OrderCartQuery> wrapper = new PageQueryWrapper<OrderCartQuery>(pageQuery.getPageNo(),pageQuery.getPageSize(),count,pageQuery.getQuery());
        List<OrderCart> itemList = orderCartMapper.getPagenationList(wrapper);
        PageListResult<OrderCart> retValue = new PageListResult<>();
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
    public ListResult<OrderCart> searchPageOrderCartListById(IdPageQuery<OrderCartQuery> idPageQuery) {
        List<OrderCart> itemList = orderCartMapper.getPagenationListById(idPageQuery);
        ListResult<OrderCart> retValue = new ListResult<OrderCart>();
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
    public GenericResult<Long> getTotalCount(Query<OrderCartQuery> query){
        long count = orderCartMapper.getTotalCount(query);
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
    public GenericResult<Long> getCount(PageQuery<OrderCartQuery> pageQuery){
        long count = orderCartMapper.getCount(pageQuery);
        GenericResult<Long> result = new GenericResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        return result;
    }

}
