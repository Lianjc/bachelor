package org.lian.controller;

import org.lian.domain.User;
import org.lian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by lianjiangchao on 16/6/1.
 */
@Controller
@RequestMapping("/action")
public class LogonAction {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/logon", method = RequestMethod.POST)
    public String doLogon(@ModelAttribute User user, RedirectAttributes redirect) {
        Integer result = userService.addUser(user);
        if (result != null){
            return "redirect:/";
        }else {
            redirect.addFlashAttribute("errorMsg", "账号已经存在");
            return "redirect:/logon";
        }
    }
}
