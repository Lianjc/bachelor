package org.lian.service;

import org.lian.domain.User;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/24.
 */
public interface UserService {

    User findOne(Integer id);

    User findOne(String phone);

    List<User> findIndirect(User user);

    Integer addUser(User user);

    User editUser(User user);

}
