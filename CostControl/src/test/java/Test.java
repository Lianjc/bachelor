import mapping.User;
import mapping.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by lianjiangchao on 16/3/10.
 */
public class Test {
    public static void main(String[] args) throws IOException{
        String resource = "mybatisConf/MybatisConf.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
//        String statement = "mapping.UserMapper.getUser";
//        User user = session.selectOne(statement , 1);
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectByName("lianjc");
        System.out.print(user);

    }
}
