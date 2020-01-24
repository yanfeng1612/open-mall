package com.openmall.user.controller.auto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import com.openmall.user.utils.*;

import com.openmall.user.domain.auto.User;
import com.openmall.user.domain.auto.UserQuery;
import com.openmall.user.service.auto.UserService;

/**
 * 用户表
 * @author model-driven
 * @date 2020-01-24
 **/
@RestController
@RequestMapping(value = "/user", produces = "application/json; charset=utf-8")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add")
    public Response<User> add(@RequestBody User user) {
        Response<User> response = new Response<>();
        try {
            BasicResult result = userService.addUser(user);
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
    public Response<User> deleteById(Long id) {
        Response<User> response = new Response<>();
        try {
            BasicResult result = userService.deleteById(id);
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
    public Response<User> updateById(@RequestBody User user) {
        Response<User> response = new Response<>();
        try {
            BasicResult result = userService.updateUserById(user);
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
    public Response<User> addOrUpdate(@RequestBody User user) {
        Response<User> response = new Response<>();
        try {
            BasicResult result = userService.addOrUpdate(user);
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
    public Response<PageListResult> list(@RequestBody PageQuery<UserQuery> query) {
        try {
            LOG.info("分页查询数据参数信息req: {}", JSON.toJSONString(query));
            PageListResult<User> pageListResult = userService.searchPageUser(query);
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
    public Response<User> getUserById(Long id) {
        LOG.info("查询参数 {}",id) ;
        Response<User> response = new Response<>();
        try {
            User result = userService.searchUserById(id);
            return ResponseTemplate.getResponse(APIMsgCode.SUCCESS, result);
        } catch (Exception e) {
            LOG.error("查询数据异常:{}",id,e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }

}
