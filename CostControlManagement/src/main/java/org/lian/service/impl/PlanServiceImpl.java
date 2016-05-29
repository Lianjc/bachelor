package org.lian.service.impl;

import org.lian.domain.Plan;
import org.lian.mapper.PlanMapper;
import org.lian.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/29.
 */
@Service
@Transactional
public class PlanServiceImpl implements PlanService {
    private PlanMapper planMapper;
    @Autowired
    public void setPlanMapper(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    @Override
    public List<Plan> selectByStatus(String status) {
        return planMapper.selectByStatus(status);
    }

    @Override
    public Plan selectById(Integer id) {
        return planMapper.selectById(id);
    }

    @Override
    public Integer addPlan(Plan plan) {
        planMapper.insertPlan(plan);
        return plan.getId();
    }

    @Override
    public Plan editPlan(Plan plan) {
        planMapper.updatePlan(plan);
        return planMapper.selectById(plan.getId());
    }


}
