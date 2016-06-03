package org.lian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lian.domain.Process;

import javax.annotation.ManagedBean;
import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/29.
 */
@Mapper
public interface ProcessMapper {
    Process selectById(@Param("id") Integer id);
    List<Process> selectIndirect(@Param("name") String name , @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("departmentID") Integer departmentID);
    void insertProcess(Process process);
    void updateProcess(Process process);
}
