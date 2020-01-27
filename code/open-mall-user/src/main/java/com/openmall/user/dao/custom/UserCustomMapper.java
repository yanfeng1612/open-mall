package com.openmall.user.dao.custom;

import com.openmall.user.domain.auto.User;

public interface UserCustomMapper {

    /**
     * find user by userName and password
     */
    User findUserByUserNameAndPassword(String userName,String password);
}
