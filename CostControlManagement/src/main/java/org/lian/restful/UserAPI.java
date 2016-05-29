package org.lian.restful;

import org.lian.domain.User;
import org.lian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/24.
 */
@RestController
@RequestMapping("/api/1/users")
public class UserAPI {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable("id") Integer id) {
        return userService.findOne(id);
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getSome(@ModelAttribute User user) {
        return userService.findIndirect(user);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public Integer postOne(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT, consumes = "application/json")
    public User putOne(@RequestBody User user) {
        return userService.editUser(user);
    }

}
