package org.lian.service.impl;

import org.lian.domain.Form;
import org.lian.mapper.FormMapper;
import org.lian.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/26.
 */
@Service
@Transactional
public class FormServiceImpl implements FormService {

    private FormMapper formMapper;

    @Autowired
    public void setFormMapper(FormMapper formMapper) {
        this.formMapper = formMapper;
    }

    @Override
    public Form findOne(Integer id) {
        return formMapper.selectOne(id);
    }

    @Override
    public List<Form> findIndirect(String description, Date startDate, Date endDate) {
        return formMapper.selectIndirect(description, startDate , endDate);
    }

    @Override
    public Integer addOne(Form form) {
        formMapper.insertDescription(form);
        return form.getId();
    }


}