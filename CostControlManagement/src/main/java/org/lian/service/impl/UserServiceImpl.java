package org.lian.service.impl;

import org.lian.domain.User;
import org.lian.mapper.UserMapper;
import org.lian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/24.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findOne(Integer id) {
        return userMapper.selectByID(id);
    }

    @Override
    public User findOne(String phone) {
        return userMapper.selectByPhone(phone);
    }

    @Override
    public List<User> findIndirect(User user) {
        return userMapper.selectIndirect(user);
    }

    @Override
    public Integer addUser(User user) {
        userMapper.insertPhoneAndPasswordAndName(user);
        return user.getId();
    }

    @Override
    public User editUser(User user) {
        userMapper.updatePasswordOrName(user);
        return userMapper.selectByPhone(user.getPhone());
    }

}
