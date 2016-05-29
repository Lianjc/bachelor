package org.lian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lian.domain.Department;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/27.
 */
@Mapper
public interface DepartmentMapper {
    Department selectByID(@Param("id") Integer id);
    List<Department> selectIndirect(@Param("description") String description);

    Integer insertDepartment(Department department);

    void updateDepartment(Department department);
}
