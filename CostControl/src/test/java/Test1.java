import mapping.User;
import mapping.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by lianjiangchao on 16/3/10.
 */
public class Test1 {


    @Test(enabled = false)
    public void testMybatis() throws IOException {
        String resource = "mybatisConf/MybatisConf.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectByName("lianjc");


        Assert.assertNotNull(user, "Failed in getting the expected user! NullPointer!");
        Assert.assertEquals("lianjc@outlook.com", user.getEmail(), "Failed get info!");
    }

}
