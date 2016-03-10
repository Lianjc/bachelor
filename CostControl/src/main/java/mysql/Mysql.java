package mysql; /**
 * Created by lianjiangchao on 16/3/5.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mysql {


    public ResultSet getData() throws Exception {


        Connection conn = null;

        String sql;
        String url = "jdbc:mysql://localhost:3306/CostControl";
        String user = "root";
        String password = "Lianjc1246";


        try {

            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url, user, password);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = conn.createStatement();
            sql = " SELECT * FROM user ";

            return stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return null;
    }

}

