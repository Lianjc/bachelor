package org.lian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lian.domain.Form;

/**
 * Created by lianjiangchao on 16/5/26.
 */
@Mapper
public interface FormMapper {
    Form selectOne(@Param("id") Integer id);

}
