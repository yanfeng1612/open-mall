package com.openmall.user.service.impl.auto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import org.springframework.dao.DuplicateKeyException;

import com.openmall.user.utils.*;

import com.openmall.user.domain.auto.User;
import com.openmall.user.domain.auto.UserQuery;
import com.openmall.user.manager.auto.UserManager;
import com.openmall.user.service.auto.UserService;

/**
 * 用户表
 * @author model-driven
 * @date 2020-01-12
 **/
@Service("userService")
public class UserServiceImpl implements UserService{

    private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserManager userManagerImpl;

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addUser(User user) {
        LOG.info("request UserServiceImpl.addUser param:" + JSON.toJSONString(user));
        BasicResult result = new BasicResult();
        try {
            if (user != null) {
                userManagerImpl.insertUser(user);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("user is null");
                LOG.error("------UserServiceImpl.addUser - user is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------UserServiceImpl.addUser 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------UserServiceImpl.addUser 异常",e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult addBatch(List<User> userList){
        LOG.info("request UserServiceImpl.addBatch size:" + userList.size());
        BasicResult result = new BasicResult();
        try {
            userManagerImpl.insertBatch(userList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("批量插入成功");
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------userServiceImpl.addBatch 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception UserServiceImpl.addBatch param:" + JSON.toJSONString(userList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult deleteById(long id){
        LOG.info("request UserServiceImpl.deleteBy param:{}",id);
        BasicResult result = new BasicResult();
        try{
            int num = userManagerImpl.deleteById(id);
            if (num == 1) {
                result.setMsg("删除成功");
                result.setCode(CodeEnum.SUCCESS.getCode());
            } else {
                result.setMsg("删除失败");
                result.setCode(CodeEnum.FAILED.getCode());
            }
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception UserServiceImpl.deleteById :{}",id,e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult updateUserById(User user){
        LOG.info("request UserServiceImpl.modifyUser param:" + JSON.toJSONString(user));
        BasicResult result = new BasicResult();
        try {
            if (user != null) {
                int update = userManagerImpl.updateUser(user);
                if (update > 0) {
                    result.setCode(CodeEnum.SUCCESS.getCode());
                    result.setMsg("编辑成功");
                    LOG.debug("------UserServiceImpl.modifyUser 编辑成功------");
                } else {
                    result.setCode(CodeEnum.FAILED.getCode());
                    result.setMsg("编辑失败，请检查是否指定主键，或者唯一键");
                    LOG.debug("------UserServiceImpl.modifyUser 编辑失败------");
                }
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("user is null");
                LOG.error("------UserServiceImpl.modifyUser - user is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------UserServiceImpl.modifyUser 异常",e);
        } catch (Exception e) {
            LOG.error("------UserServiceImpl.modifyUser 异常",e);
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public BasicResult updateBatch(List<User> userList){
        LOG.info("request UserServiceImpl.modifyBatch size:" + userList.size());
        BasicResult result = new BasicResult();
        try {
            Object count = userManagerImpl.updateBatch(userList);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg(String.valueOf(count));
            LOG.info("response UserServiceImpl.modifyBatch 处理成功 updateCount:" + count);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception UserServiceImpl.modifyBatch :" + JSON.toJSONString(userList),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public User searchUserById(User user){
        try {
            return userManagerImpl.findById(user);
        } catch (Exception e) {
            LOG.error("------UserServiceImpl.searchUserByPriKey 异常", e);
        }
        return null;
    }

    /**
     *
     * @generated
     */
    @Override
    public ListResult<User> searchUser(Query<UserQuery> query){
        LOG.info("request UserServiceImpl.searchUser param:" + JSON.toJSONString(query));
        ListResult<User> result = new ListResult<>();
        try {
            result = userManagerImpl.searchUserList(query);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------UserServiceImpl.searchUser 异常", e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public PageListResult<User> searchPageUser(PageQuery<UserQuery> pageQuery){
        LOG.info("request UserServiceImpl.searchPageUser param:" + JSON.toJSONString(pageQuery));
        PageListResult<User> result = new PageListResult<User>();
        try {
            result = userManagerImpl.searchPageUserList(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("result UserServiceImpl.searchPageUser 处理结果:" + JSON.toJSONString(result));
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception UserServiceImpl.searchPageUser :" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

    /**
    *
    * @generated
    */
    @Override
    public ListResult<User> searchPageUserById(IdPageQuery<UserQuery> idPageQuery){
        LOG.info("request UserServiceImpl.searchPageUserById param:" + JSON.toJSONString(idPageQuery));
        ListResult<User> result = new ListResult<>();
        try {
            result = userManagerImpl.searchPageUserListById(idPageQuery);
            result.setCode(CodeEnum.SUCCESS.getCode());
            result.setMsg("成功");
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception UserServiceImpl.searchPageUserById :" + JSON.toJSONString(idPageQuery),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getTotalCount(Query<UserQuery> query){
        LOG.info("request UserServiceImpl.getTotalCount param:" + JSON.toJSONString(query));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = userManagerImpl.getTotalCount(query);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response UserServiceImpl.getTotalCount 处理成功" + JSON.toJSONString(result));
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception UserServiceImpl.getTotalCount param:" + JSON.toJSONString(query),e);
        }
        return result;
    }

    /**
     *
     * @generated
     */
    @Override
    public GenericResult<Long> getCount(PageQuery<UserQuery> pageQuery){
        LOG.info("request UserServiceImpl.getCount param:" + JSON.toJSONString(pageQuery));
        GenericResult<Long> result = new GenericResult<>();
        try{
            result = userManagerImpl.getCount(pageQuery);
            result.setMsg("查询成功");
            result.setCode(CodeEnum.SUCCESS.getCode());
            LOG.info("response UserServiceImpl.getCount 处理结果:");
        } catch (Exception e){
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("exception UserServiceImpl.getCount param:" + JSON.toJSONString(pageQuery),e);
        }
        return result;
    }

}
