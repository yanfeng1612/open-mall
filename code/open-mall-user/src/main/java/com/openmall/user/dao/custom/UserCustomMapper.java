package com.openmall.user.dao.custom;

import com.openmall.user.domain.auto.User;
import org.apache.ibatis.annotations.Param;

public interface UserCustomMapper {

    /**
     * find user by userName and password
     */
    User findUserByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}
