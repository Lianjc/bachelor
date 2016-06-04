package org.lian.controller;

import org.lian.domain.Authority;
import org.lian.domain.Department;
import org.lian.domain.User;
import org.lian.service.DepartmentService;
import org.lian.service.ProcessService;
import org.lian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/24.
 */
@Controller
public class PageController {

    private UserService userService;
    private DepartmentService departmentService;
    private ProcessService processService;
    private HttpSession httpSession;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    public void setProcessService(ProcessService processService) {
        this.processService = processService;
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

    @RequestMapping(value = "/cfo_allocation", method = RequestMethod.GET)
    public String showCFOAllocation(Model model) {
        model.addAttribute("departments", departmentService.findIndirect(null));
        return "cfo_allocation";
    }

    @RequestMapping(value = "/cfo_control", method = RequestMethod.GET)
    public String showCFOControl(String startdate, String enddate, String name, Model model) {
        List<Department> departments = departmentService.findIndirect(null);
        model.addAttribute("departments", departments);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;

        try {
            if (!startdate.equals("")) {
                start = simpleDateFormat.parse(startdate);
            }

            if (!enddate.equals("")) {
                end = simpleDateFormat.parse(enddate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (Department department : departments) {
            department.setProcesses(processService.findIndirect(name, start, end, department.getId()));
            Double planCost = department.getPlancost();
            Double cost = department.getCost();
            Double difference = null;
            if (planCost != null && cost != null && planCost != 0) {
                difference = (planCost - cost) / planCost;
            }
            department.setDifference(difference);
        }
        return "cfo_control";
    }

}
