package org.lian.controller;

import org.lian.domain.User;
import org.lian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lianjiangchao on 16/6/1.
 */
@Controller
@RequestMapping("/action")
public class LoginAction {

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute User user, RedirectAttributes redirect) {
        List<User> result = userService.findIndirect(user);
        if (result.size() > 0) {
            httpSession.setAttribute("currentUser", result.get(0));
            return "redirect:/index";
        } else {
            redirect.addFlashAttribute("errorMsg", "账号或密码不正确!");
            return "redirect:/";
        }
    }

}
