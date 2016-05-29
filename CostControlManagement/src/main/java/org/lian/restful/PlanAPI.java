package org.lian.restful;

import org.lian.domain.Plan;
import org.lian.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lianjiangchao on 16/5/29.
 */
@RestController
@RequestMapping("/api/1/plans")
public class PlanAPI {
    private PlanService planService;
    @Autowired
    public void setPlanService(PlanService planService) {
        this.planService = planService;
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public List<Plan> getSome(String status){
        return planService.selectByStatus(status);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Plan getOne(@PathVariable("id") Integer id){
        return planService.selectById(id);
    }
    @RequestMapping(value = "" , method = RequestMethod.POST ,consumes = "application/json")
    public Integer postOne(@RequestBody Plan plan){
        return planService.addPlan(plan);
    }
    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = "application/json")
    public Plan putOne(@RequestBody Plan plan){
        return planService.editPlan(plan);
    }

}
