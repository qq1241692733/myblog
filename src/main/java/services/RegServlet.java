package services;

import dao.UserInfoDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/22
 * Time: 18:29
 */
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        // 定义返回给前端的参数
        String msg = "";
        int succ = 0;
        // 1.获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // todo:非空检验
        // 2.【业务逻辑处理】操作数据库添加用户
        UserInfoDao userInfoDao = new UserInfoDao();
        try {
            succ = userInfoDao.addUser(username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 3.返回结果给前端
        PrintWriter writer = response.getWriter();
        // {"succ":1,"msg":"msg"}
        writer.println("{\"succ\":1,\"msg\":\"msg\"}");
    }
}
