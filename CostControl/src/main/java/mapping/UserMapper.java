package mapping;

import org.apache.ibatis.annotations.Param;

/**
 * Created by lianjiangchao on 16/3/10.
 */
public interface UserMapper {

    User selectByName(@Param("userName") String userName);

}
