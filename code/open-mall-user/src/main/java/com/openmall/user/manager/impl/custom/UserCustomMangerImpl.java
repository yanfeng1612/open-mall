package com.openmall.user.manager.impl.custom;

import com.openmall.user.dao.custom.UserCustomMapper;
import com.openmall.user.domain.auto.User;
import com.openmall.user.manager.custom.UserCustomManger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userCustomManger")
public class UserCustomMangerImpl implements UserCustomManger {

    private final static Logger logger = LoggerFactory.getLogger(UserCustomMangerImpl.class);

    @Autowired
    private UserCustomMapper userCustomMapper;

    /**
     * find user by username And password
     */
    @Override
    public User findUserByUserNameAndPassword(String useName,String password) {
        return userCustomMapper.findUserByUserNameAndPassword(useName,password);
    }
}
