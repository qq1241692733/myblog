package services;

import dao.ArticleInfoDao;
import models.ArticleInfo;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/24
 * Time: 18:39
 */
public class ArtListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ = 1;
        String msg = "";
        List<ArticleInfo> list = null;
        // 1.获取参数
        HttpSession session = request.getSession(false);  // 如果获取不到不会创建新的 session
        if (session == null) {
            msg = "非法请求，用户未登录";
        }else {
            msg = "用户已登录";
            UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");  // 登录成功后有 setAttribute

            int uid = userInfo.getId();
            ArticleInfoDao articleInfoDao = new ArticleInfoDao();
            try {
                list = articleInfoDao.getListByUID(uid);
                succ = 1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            // 3.返回结果
            HashMap<String, Object> result = new HashMap<>();
            result.put("succ", succ);
            result.put("msg", msg);
            result.put("list", list);
            ResultJSONUtils.write(response, result);
        }
    }
}
