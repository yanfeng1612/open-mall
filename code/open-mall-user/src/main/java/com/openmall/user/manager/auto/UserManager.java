package com.openmall.user.manager.auto;

import java.util.List;

import com.openmall.user.domain.auto.User;
import com.openmall.user.domain.auto.UserQuery;
import com.openmall.user.utils.*;

/**
 * 用户表
 * @author model-driven
 * @date 2020-01-12
 **/
public interface UserManager {

     /**
     *
     * @auto generated
     */
    int insertUser(User user);

    /**
     *
     * @auto generated
     */
    int insertBatch(List<User> userList);

    /**
     *
     * @auto generated
     */
    int deleteById(long id);

    /**
     *
     * @auto generated
     */
    int updateUser(User user);

    /**
     *
     * @auto generated
     */
    int updateBatch(List<User> userList);

    /**
     *
     * @auto generated
     */
    User findById(User user);

    /**
     *
     * @auto generated
     */
    ListResult<User> searchUserList(Query<UserQuery> query);

    /**
     *
     * @auto generated
     */
    PageListResult<User> searchPageUserList(PageQuery<UserQuery> pageQuery);

    /**
    *
    * @auto generated
    */
    ListResult<User> searchPageUserListById(IdPageQuery<UserQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getTotalCount(Query<UserQuery> query);

    /**
     *
     * @auto generated
     */
    GenericResult<Long> getCount(PageQuery<UserQuery> pageQuery);

}
