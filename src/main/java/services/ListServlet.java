package services;

import dao.ArticleInfoDao;
import models.vo.ArticleInfoVO;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/29
 * Time: 17:16
 */

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ = 0;
        String msg = "";
        List<ArticleInfoVO> list = null;
        // 1.
        int page = Integer.parseInt(req.getParameter("page"));
        int psize = Integer.parseInt(req.getParameter("psize"));
        // 2.
        ArticleInfoDao articleInfoDao = new ArticleInfoDao();
        try {
            list = articleInfoDao.getList(page, psize);
            succ = 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 3.
        HashMap<String , Object> map = new HashMap<>();
        map.put("succ", succ);
        map.put("msg", msg);
        map.put("list", list);
        ResultJSONUtils.write(resp, map);
    }
}
