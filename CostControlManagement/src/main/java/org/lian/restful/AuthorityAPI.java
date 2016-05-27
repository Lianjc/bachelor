package org.lian.restful;

import org.lian.domain.Authority;
import org.lian.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lianjiangchao on 16/5/26.
 */
@RequestMapping("/api/1/authorities")
@RestController
public class AuthorityAPI {

    private AuthorityService authorityService;
    @Autowired
    public void setAuthorityService(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Authority getOne(@PathVariable("id") Integer id){
        return authorityService.findOne(id);
    }


}
