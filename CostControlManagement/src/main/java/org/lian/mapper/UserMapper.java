package org.lian.mapper;

import org.apache.catalina.startup.Tomcat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lian.domain.User;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/24.
 */
@Mapper
public interface UserMapper {

    List<User> selectIndirect(@Param("user") User user);

    User selectByID(@Param("id") Integer id);

    void insertPhoneAndPasswordAndName(User user);

    void updatePasswordOrName(User user);
}
