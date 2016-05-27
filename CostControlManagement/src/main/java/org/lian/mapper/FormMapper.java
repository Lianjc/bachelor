package org.lian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lian.domain.Form;

import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/26.
 */
@Mapper
public interface FormMapper {
    Form selectOne(@Param("id") Integer id);

    List<Form> selectIndirect(@Param("description") String description, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    void insertDescription(Form form);

}
