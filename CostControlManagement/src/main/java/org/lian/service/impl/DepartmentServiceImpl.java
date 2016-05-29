package org.lian.service.impl;

import org.lian.domain.Department;
import org.lian.mapper.DepartmentMapper;
import org.lian.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/27.
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentMapper departmentMapper;
    @Autowired
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {this.departmentMapper = departmentMapper;}

    @Override
    public Department findOne(Integer id) {
        return departmentMapper.selectByID(id);
    }

    @Override
    public List<Department> findIndirect(String description) {
        return departmentMapper.selectIndirect(description);
    }

    @Override
    public Integer addDepartment(Department department) {
        departmentMapper.insertDepartment(department);
        return department.getId();
    }

    @Override
    public Department editDepartment(Department department) {
        departmentMapper.updateDepartment(department);
        return departmentMapper.selectByID(department.getId());
    }

}
