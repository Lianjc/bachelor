package org.lian.restful;

import org.lian.domain.Form;
import org.lian.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/26.
 */
@RestController
@RequestMapping("api/1/forms")
public class FormAPI {

    private FormService formService;

    @Autowired
    public void setFormService(FormService formService) {
        this.formService = formService;
    }

    @RequestMapping(value ="/{id}" , method = RequestMethod.GET)
    public Form getOne(@PathVariable("id" ) Integer id){
        return formService.findOne(id);
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public List<Form> getSome(String description , Long start , Long end){
        Date startDate = null;
        Date endDate = null;
        if (start != null) {
            startDate = new Date(start);
            endDate = new Date(end);
        }
        return formService.findIndirect(description, startDate, endDate);
    }

    @RequestMapping(value = "" , method = RequestMethod.POST , consumes = "application/json")
    public Integer postForm(@RequestBody Form form){
        return formService.addOne(form);
    }


}
