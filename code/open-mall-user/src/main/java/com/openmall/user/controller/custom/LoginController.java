package com.openmall.user.controller.custom;

import com.openmall.user.domain.auto.User;
import com.openmall.user.service.custom.UserCustomService;
import com.openmall.user.utils.APIMsgCode;
import com.openmall.user.utils.Response;
import com.openmall.user.utils.ResponseTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/login")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserCustomService userCustomService;

    @RequestMapping(value = "/in")
    public Response<User> login(String username, String password) {
        Response<User> response = new Response<>();
        try {
            User user = userCustomService.findUserByUserNameAndPassword(username,password);
            if (user != null) {
                ResponseTemplate.getResponse(APIMsgCode.SUCCESS, user);
            } else {
                ResponseTemplate.getResponse(APIMsgCode.LOGIN_ERROR,null);
            }
        } catch (Exception e) {
            LOG.error("登录失败: ",e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }
}
