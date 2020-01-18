package com.openmall.user.service.auto;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

import com.openmall.user.utils.*;

import com.openmall.user.domain.auto.User;
import com.openmall.user.domain.auto.UserQuery;

/**
 * 用户表
 * @author model-driven
 * @date 2020-01-18
 **/
public interface UserService {

    /**
     *
     * @generated
     */
    BasicResult addUser(User user);

    /**
     *
     * @generated
     */
    BasicResult addBatch(List<User> userList);

    /**
     *
     * @generated
     */
    BasicResult deleteById(long id);

    /**
     *
     * @generated
     */
    BasicResult updateUserById(User user);

    /**
     *
     * @generated
     */
    BasicResult updateBatch(List<User> userList);

    /**
     *
     * @generated
     */
    User searchUserById(User user);

    /**
     *
     * @generated
     */
    ListResult<User> searchUser(Query<UserQuery> query);

    /**
     *
     * @generated
     */
    PageListResult<User> searchPageUser(PageQuery<UserQuery> pageQuery);

    /**
    *
    * @generated
    */
    ListResult<User> searchPageUserById(IdPageQuery<UserQuery> idPageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getCount(PageQuery<UserQuery> pageQuery);

    /**
     *
     * @generated
     */
    GenericResult<Long> getTotalCount(Query<UserQuery> query);

}
