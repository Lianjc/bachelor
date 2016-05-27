package org.lian.service.impl;

import org.lian.domain.Authority;
import org.lian.mapper.AuthorityMapper;
import org.lian.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lianjiangchao on 16/5/26.
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

    private AuthorityMapper authorityMapper;
    @Autowired
    public void setAuthorityMapper(AuthorityMapper authorityMapper) {
        this.authorityMapper = authorityMapper;
    }

    @Override
    public Authority findOne(Integer id) {
        return authorityMapper.selectOne(id);
    }
}
