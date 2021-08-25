package services;

import com.sun.org.apache.xpath.internal.objects.XNull;
import dao.UserInfoDao;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

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
        String msg = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && !username.equals("") &&
                password != null && !password.equals("")) {
            // 查询数据库
            UserInfoDao userInfoDao = new UserInfoDao();
            try {
                UserInfo userInfo = userInfoDao.getUser(username, password);
                if (userInfo.getId() > 0) {  // 用户的 id 是从1开始的
                    msg = "查询到该用户";
                    succ = 1;

                    HttpSession session = request.getSession();
                    session.setAttribute("userinfo", userInfo);
                }else {
                    succ = 0;
                    msg = "用户名或者密码错误";
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else {
            msg = "非法请求，参数不完整";
        }
        HashMap<String, Object> result = new HashMap<>();
        result.put("succ", succ);
        result.put("msg", msg);
        ResultJSONUtils.write(response, result);
    }
}
