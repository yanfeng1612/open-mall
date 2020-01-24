package com.openmall.user.manager.impl.auto;

import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

import com.openmall.user.domain.auto.User;
import com.openmall.user.domain.auto.UserQuery;
import com.openmall.user.dao.auto.UserMapper;
import com.openmall.user.manager.auto.UserManager;

import com.openmall.user.utils.*;

/**
 * 用户表
 * @author model-driven
 * @date 2020-01-24
 **/
@Component("userManager")
public class UserManagerImpl implements UserManager {

    private final static Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @generated
     */
    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertBatch(List<User> userList){
        return userMapper.insertBatch(userList);
    }

    /**
     *
     * @generated
     */
    @Override
    public int insertOrUpdate(User user){
        return userMapper.insertOrUpdate(user);
    }

    /**
     *
     * @generated
     */
    @Override
    public int deleteById(long id){
        return userMapper.deleteById(id);
    }

     /**
     *
     * @generated
     */
    @Override
    public int updateUser(User user) {
        return userMapper.update(user);
    }

    /**
     *
     * @generated
     */
    @Transactional
    @Override
    public int updateBatch(List<User> userList){
        int result = 0;
        for(User item : userList){
            int count = userMapper.update(item);
            result += count;
        }
        return result;
    }

    @Override
    public User findById(Long id){
        return userMapper.findById(id);
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<User> searchUserList(Query<UserQuery> query) {
        List<User> list = userMapper.getAllList(query);
        ListResult<User> result = new ListResult<User>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValues(list);
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public PageListResult<User> searchPageUserList(PageQuery<UserQuery> pageQuery) {
        long count = userMapper.getCount(pageQuery);
        PageQueryWrapper<UserQuery> wrapper = new PageQueryWrapper<UserQuery>(pageQuery.getPageNo(),pageQuery.getPageSize(),count,pageQuery.getQuery());
        List<User> itemList = userMapper.getPagenationList(wrapper);
        PageListResult<User> retValue = new PageListResult<>();
        retValue.setMsg("查询成功");
        retValue.setCode(CodeEnum.SUCCESS.getCode());
        retValue.setValues(itemList);
        long currentPage = pageQuery.getPageNo() > 1 ? pageQuery.getPageNo() : 1;
        Pagenation pagenation = new Pagenation(currentPage, count, pageQuery.getPageSize());
        retValue.setPagenation(pagenation);
        return retValue;
    }

    /**
    *
    * @generated
    */
    @Override
    public ListResult<User> searchPageUserListById(IdPageQuery<UserQuery> idPageQuery) {
        List<User> itemList = userMapper.getPagenationListById(idPageQuery);
        ListResult<User> retValue = new ListResult<User>();
        retValue.setMsg("查询成功");
        retValue.setCode(CodeEnum.SUCCESS.getCode());
        retValue.setValues(itemList);
        return retValue;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getTotalCount(Query<UserQuery> query){
        long count = userMapper.getTotalCount(query);
        GenericResult<Long> result = new GenericResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getCount(PageQuery<UserQuery> pageQuery){
        long count = userMapper.getCount(pageQuery);
        GenericResult<Long> result = new GenericResult<>();
        result.setMsg("查询成功");
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setValue(Long.valueOf(count));
        return result;
    }

}
