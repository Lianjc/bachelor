package org.lian.service;

import org.lian.domain.Form;

import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/26.
 */
public interface FormService {
    Form findOne(Integer id);
    List<Form> findIndirect(String description, Date starDate, Date endDate);
    Integer addOne(Form form);

}
