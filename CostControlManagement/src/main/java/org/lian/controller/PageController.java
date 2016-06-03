package org.lian.controller;

import org.lian.domain.Authority;
import org.lian.domain.User;
import org.lian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by lianjiangchao on 16/5/24.
 */
@Controller
public class PageController {

    private UserService userService;
    private HttpSession httpSession;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLogin(Model model) {
        return "login";
    }

    @RequestMapping(value = "/logon", method = RequestMethod.GET)
    public String showLogon() {
        return "logon";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showIndex() {
        Authority authority = ((User) httpSession.getAttribute("currentUser")).getAuthority();
        switch (authority.getId()) {
            case 1:
                return "index0";
            case 2:
                return "index1";
            case 3:
                return "index2";
            default:
                break;
        }
        return null;
    }

    @RequestMapping(value = "/department_allocation", method = RequestMethod.GET)
    public String showDepartmentAllocation() {
        return "department_allocation";
    }
}
