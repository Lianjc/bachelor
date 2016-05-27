package org.lian.restful;

import org.lian.domain.Form;
import org.lian.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
