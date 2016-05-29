package org.lian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lian.domain.Plan;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/29.
 */
@Mapper
public interface PlanMapper {
    List<Plan> selectByStatus(@Param("status") String status);
    Plan selectById(@Param("id") Integer id);
    void insertPlan(Plan plan);
    void updatePlan(Plan plan);
}
