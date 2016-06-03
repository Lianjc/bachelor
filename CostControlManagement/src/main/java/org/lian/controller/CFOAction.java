package org.lian.controller;

import org.lian.domain.Department;
import org.lian.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by lianjiangchao on 16/6/3.
 */
@Controller
@RequestMapping("/action/CFO")
public class CFOAction {

    private DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public String doAddDepartment(@ModelAttribute Department department, RedirectAttributes redirect) {
        departmentService.addDepartment(department);
        redirect.addFlashAttribute("resultMsg", "添加成功!");
        return "redirect:/cfo_allocation";
    }

    @RequestMapping(value = "/allocation", method = RequestMethod.POST)
    public String doAllocation(@ModelAttribute Department department, RedirectAttributes redirect) {
        departmentService.editDepartment(department);
        redirect.addFlashAttribute("allocationMsg", "分配成功!");
        return "redirect:/cfo_allocation";
    }

}
