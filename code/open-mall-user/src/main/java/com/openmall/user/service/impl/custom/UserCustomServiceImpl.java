package com.openmall.user.service.impl.custom;

import com.openmall.user.domain.auto.User;
import com.openmall.user.service.custom.UserCustomService;
import com.openmall.user.service.impl.auto.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userCustomService")
public class UserCustomServiceImpl implements UserCustomService {

    private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserCustomServiceImpl userCustomService;

    @Override
    public User findUserByUserNameAndPassword(String useName, String password) {
        User user = null;
        try {
            user = userCustomService.findUserByUserNameAndPassword(useName, password);
        } catch (Exception e) {
            LOG.error("UserCustomServiceImpl error: ",e);
        }
        return user;
    }

}
