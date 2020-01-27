package com.openmall.user.manager.custom;

import com.openmall.user.domain.auto.User;

public interface UserCustomManger {

    /**
     * 通过useName & password查询用户信息
     */
    User findUserByUserNameAndPassword(String userName,String password);
}
