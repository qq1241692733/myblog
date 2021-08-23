package services;

import com.sun.org.apache.xpath.internal.objects.XNull;
import dao.UserInfoDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/23
 * Time: 12:30
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ = -1;
        String mag = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && !username.equals("") &&
                password != null && password.equals("")) {
            // 查询数据库

        }else {

        }
    }
}
