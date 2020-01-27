package com.openmall.user.service.custom;

import com.openmall.user.domain.auto.User;

public interface UserCustomService {

    /**
     * 通过useName & password查询用户信息
     */
    User findUserByUserNameAndPassword(String useName, String password);

}
