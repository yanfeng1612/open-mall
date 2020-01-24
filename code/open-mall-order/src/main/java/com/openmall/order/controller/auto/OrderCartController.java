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

import com.openmall.order.domain.auto.OrderCart;
import com.openmall.order.domain.auto.OrderCartQuery;
import com.openmall.order.service.auto.OrderCartService;

/**
 * 订单购物车
 * @author model-driven
 * @date 2020-01-24
 **/
@RestController
@RequestMapping(value = "/orderCart", produces = "application/json; charset=utf-8")
public class OrderCartController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderCartController.class);

    @Autowired
    private OrderCartService orderCartService;

    @RequestMapping(value = "/add")
    public Response<OrderCart> add(@RequestBody OrderCart orderCart) {
        Response<OrderCart> response = new Response<>();
        try {
            BasicResult result = orderCartService.addOrderCart(orderCart);
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
    public Response<OrderCart> deleteById(Long id) {
        Response<OrderCart> response = new Response<>();
        try {
            BasicResult result = orderCartService.deleteById(id);
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
    public Response<OrderCart> updateById(@RequestBody OrderCart orderCart) {
        Response<OrderCart> response = new Response<>();
        try {
            BasicResult result = orderCartService.updateOrderCartById(orderCart);
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
    public Response<OrderCart> addOrUpdate(@RequestBody OrderCart orderCart) {
        Response<OrderCart> response = new Response<>();
        try {
            BasicResult result = orderCartService.addOrUpdate(orderCart);
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
    public Response<PageListResult> list(@RequestBody PageQuery<OrderCartQuery> query) {
        try {
            LOG.info("分页查询数据参数信息req: {}", JSON.toJSONString(query));
            PageListResult<OrderCart> pageListResult = orderCartService.searchPageOrderCart(query);
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
    public Response<OrderCart> getOrderCartById(Long id) {
        LOG.info("查询参数 {}",id) ;
        Response<OrderCart> response = new Response<>();
        try {
            OrderCart result = orderCartService.searchOrderCartById(id);
            return ResponseTemplate.getResponse(APIMsgCode.SUCCESS, result);
        } catch (Exception e) {
            LOG.error("查询数据异常:{}",id,e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }

}
