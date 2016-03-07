import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

/**
 * Created by lianjiangchao on 16/3/7.
 */

public class HelloServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.print("HelloWorld!!!");

        Mysql mysql = new Mysql();
        out.print("HelloWorld!!!");


        ResultSet rs = null;
        try {
            rs = mysql.getData();


            while(rs.next()) {
                out.print(rs.getString(1) + "\t" + rs.getString(2)+"\t" + rs.getString(3));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
