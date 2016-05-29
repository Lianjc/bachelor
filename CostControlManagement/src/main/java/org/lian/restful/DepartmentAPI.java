package org.lian.restful;

import org.lian.domain.Department;
import org.lian.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/27.
 */
@RestController
@RequestMapping("api/1/departments")
public class DepartmentAPI {
    private DepartmentService departmentService;
    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Department getOne(@PathVariable("id") Integer id){
        return departmentService.findOne(id);
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public List<Department> getSome(String description ){
        return departmentService.findIndirect(description);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public Integer postOne(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT, consumes = "application/json")
    public Department putOne(@RequestBody Department department) {
        return departmentService.editDepartment(department);
    }
}
