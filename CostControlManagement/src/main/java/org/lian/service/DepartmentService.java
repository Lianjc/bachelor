package org.lian.service;

import org.lian.domain.Department;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/27.
 */
public interface DepartmentService {
    Department findOne(Integer id);
    List<Department> findIndirect(String description);
    Integer addDepartment(Department department);
    Department editDepartment(Department department);
}
