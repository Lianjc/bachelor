package org.lian.service;

import org.lian.domain.Plan;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/29.
 */
public interface PlanService {
    List<Plan> selectByStatus(String status);
    Plan selectById(Integer id);
    Integer addPlan(Plan plan);
    Plan editPlan(Plan plan);
}
