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

import com.openmall.order.domain.auto.OrderMaster;
import com.openmall.order.domain.auto.OrderMasterQuery;
import com.openmall.order.service.auto.OrderMasterService;

/**
 * 订单master表
 * @author model-driven
 * @date 2020-01-18
 **/
@RestController
@RequestMapping(value = "/orderMaster", produces = "application/json; charset=utf-8")
public class OrderMasterController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderMasterController.class);

    @Autowired
    private OrderMasterService orderMasterService;

    @RequestMapping(value = "/add")
    public Response<OrderMaster> add(@RequestBody OrderMaster orderMaster) {
        Response<OrderMaster> response = new Response<>();
        try {
            BasicResult result = orderMasterService.addOrderMaster(orderMaster);
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
    public Response<OrderMaster> deleteById(Long id) {
        Response<OrderMaster> response = new Response<>();
        try {
            BasicResult result = orderMasterService.deleteById(id);
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
    public Response<OrderMaster> updateById(@RequestBody OrderMaster orderMaster) {
        Response<OrderMaster> response = new Response<>();
        try {
            BasicResult result = orderMasterService.updateOrderMasterById(orderMaster);
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
    public Response<PageListResult> list(@RequestBody PageQuery<OrderMasterQuery> query) {
        try {
            LOG.info("分页查询数据参数信息req: {}", JSON.toJSONString(query));
            PageListResult<OrderMaster> pageListResult = orderMasterService.searchPageOrderMaster(query);
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
    public Response<OrderMaster> getOrderMasterById(@RequestBody OrderMaster orderMaster) {
        LOG.info("查询参数 {}",orderMaster) ;
        Response<OrderMaster> response = new Response<>();
        try {
            OrderMaster result = orderMasterService.searchOrderMasterById(orderMaster);
            return ResponseTemplate.getResponse(APIMsgCode.SUCCESS, result);
        } catch (Exception e) {
            LOG.error("查询数据异常:{}",orderMaster,e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }

}
