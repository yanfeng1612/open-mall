package com.openmall.order.controller.auto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import com.openmall.order.utils.*;

import com.openmall.order.domain.auto.OrderDetail;
import com.openmall.order.domain.auto.OrderDetailQuery;
import com.openmall.order.service.auto.OrderDetailService;

/**
 * 订单明细表
 * @author model-driven
 * @date 2020-01-24
 **/
@RestController
@RequestMapping(value = "/orderDetail", produces = "application/json; charset=utf-8")
public class OrderDetailController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderDetailController.class);

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value = "/add")
    public Response<OrderDetail> add(@RequestBody OrderDetail orderDetail) {
        Response<OrderDetail> response = new Response<>();
        try {
            BasicResult result = orderDetailService.addOrderDetail(orderDetail);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    @RequestMapping(value = "/deleteById")
    public Response<OrderDetail> deleteById(Long id) {
        Response<OrderDetail> response = new Response<>();
        try {
            BasicResult result = orderDetailService.deleteById(id);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    @RequestMapping(value = "/updateById")
    public Response<OrderDetail> updateById(@RequestBody OrderDetail orderDetail) {
        Response<OrderDetail> response = new Response<>();
        try {
            BasicResult result = orderDetailService.updateOrderDetailById(orderDetail);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    @RequestMapping(value = "/addOrUpdate")
    public Response<OrderDetail> addOrUpdate(@RequestBody OrderDetail orderDetail) {
        Response<OrderDetail> response = new Response<>();
        try {
            BasicResult result = orderDetailService.addOrUpdate(orderDetail);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    /**
     * 查询数据列表
     */
    @RequestMapping("/list")
    public Response<PageListResult> list(@RequestBody PageQuery<OrderDetailQuery> query) {
        try {
            LOG.info("分页查询数据参数信息req: {}", JSON.toJSONString(query));
            PageListResult<OrderDetail> pageListResult = orderDetailService.searchPageOrderDetail(query);
            LOG.info("分页查询数据参数信息resp: {}-{}", pageListResult.getCode(), JSON.toJSONString(pageListResult.getPagenation()));
            APIMsgCode apiMsgCode = CodeConverter.convert(pageListResult.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, pageListResult);
        } catch (Exception e) {
            LOG.error("分页查询数据参数信息exception: ", e);
        }
        return ResponseTemplate.FAILURE.getResponse(null);
    }

    /**
     * 查询数据详情
     */
    @RequestMapping(value = "/detail", method = {RequestMethod.POST,RequestMethod.GET})
    public Response<OrderDetail> getOrderDetailById(Long id) {
        LOG.info("查询参数 {}",id) ;
        Response<OrderDetail> response = new Response<>();
        try {
            OrderDetail result = orderDetailService.searchOrderDetailById(id);
            return ResponseTemplate.getResponse(APIMsgCode.SUCCESS, result);
        } catch (Exception e) {
            LOG.error("查询数据异常:{}",id,e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }

}
