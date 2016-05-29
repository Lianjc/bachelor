package org.lian.restful;

import org.lian.domain.Process;
import org.lian.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/29.
 */
@RestController
@RequestMapping("/api/1/processes")
public class ProcessAPI {
    private ProcessService processService;

    @Autowired public void setProcessService(ProcessService processService) {
        this.processService = processService;
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Process getOne(@PathVariable("id") Integer id){
        return processService.findOne(id);
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public List<Process> getIndirect(String name, Long start , Long end){
        Date startDate = null;
        Date endDate = null;
        if (start != null) {
            startDate = new Date(start);
            endDate = new Date(end);}
        return processService.findIndirect(name,startDate,endDate);
    }

    @RequestMapping(value = "", method = RequestMethod.POST ,consumes = "application/json")
    public Integer postProcess(@RequestBody Process process){
        return processService.addProcess(process);
    }
    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = "application/json")
    public Process putProcess(@RequestBody Process process){
        return processService.editProcess(process);
    }

}
