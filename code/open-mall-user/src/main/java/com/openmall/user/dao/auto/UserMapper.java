package com.openmall.user.dao.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.openmall.user.domain.auto.User;
import com.openmall.user.domain.auto.UserQuery;
import com.openmall.user.utils.*;

/**
 * 用户表
 * @author model-driven
 * @date 2020-01-12
 **/
public interface UserMapper {

    /**
     *
     * @auto generated
     */
    int insert(User user);

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
    int update(User user);

    /**
     *
     * @auto generated
     */
    User findById(User user);

    /**
     *
     * @auto generated
     */
    List<User> getAllList(Query<UserQuery> query);

    /**
     *
     * @auto generated
     */
    List<User> getPagenationList(PageQuery<UserQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    List<User> getPagenationListById(IdPageQuery<UserQuery> idPageQuery);

    /**
     *
     * @auto generated
     */
    long getCount(PageQuery<UserQuery> pageQuery);

    /**
     *
     * @auto generated
     */
    long getTotalCount(Query<UserQuery> query);

}
