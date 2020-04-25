package com.openmall.user.controller.custom;

import com.openmall.user.domain.auto.User;
import com.openmall.user.domain.auto.UserQuery;
import com.openmall.user.service.auto.UserService;
import com.openmall.user.service.custom.UserCustomService;
import com.openmall.user.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/login")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserCustomService userCustomService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/in")
    public Response<User> login(String username, String password) {
        Response<User> response = new Response<>();
        try {
            User user = userCustomService.findUserByUserNameAndPassword(username,password);
            if (user != null) {
                ResponseTemplate.getResponse(APIMsgCode.SUCCESS, user);
            } else {
                ResponseTemplate.getResponse(APIMsgCode.FAILURE,null);
            }
            response = ResponseTemplate.getResponse(APIMsgCode.SUCCESS,user);
        } catch (Exception e) {
            LOG.error("登录失败: ",e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }

    @RequestMapping(value = "/in0",method = {RequestMethod.POST})
    public Response<User> login0(String username, String password) {
        Response<User> response = new Response<>();
        try {
            Query<UserQuery> query = new Query<>();
            UserQuery userQuery = new UserQuery();
            userQuery.setUsername(username);
            userQuery.setPassword(password);
            query.setQuery(userQuery);
            ListResult<User> userListResult = userService.searchUser(query);
            if (userListResult != null && userListResult.getValues().size() == 1) {
                response = ResponseTemplate.getResponse(APIMsgCode.SUCCESS, userListResult.getValues().get(0));
            } else {
                response = ResponseTemplate.getResponse(APIMsgCode.FAILURE,null);
            }
        } catch (Exception e) {
            LOG.error("登录失败: ",e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }

}
