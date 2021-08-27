package dao;

import models.ArticleInfo;
import sun.security.pkcs11.Secmod;
import utils.DBUtils;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/24
 * Time: 18:45
 */
public class ArticleInfoDao {
    // 根据 UID 查询
    public List<ArticleInfo> getListByUID(int uid) throws SQLException {
        List<ArticleInfo> list = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        String sql = "select * from articleinfo where uid=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, uid);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ArticleInfo articleInfo = new ArticleInfo();
            articleInfo.setId(resultSet.getInt("id"));
            articleInfo.setRcount(resultSet.getInt("rcount"));
            articleInfo.setContent(resultSet.getString("content"));
            articleInfo.setTitle(resultSet.getString("title"));
            articleInfo.setCreatetime(resultSet.getDate("createtime"));
            list.add(articleInfo);
        }
        DBUtils.close(connection, statement, resultSet);
        return list;
    }

    // 删除文章
    public int del(int id) throws SQLException {
        int result = 0;
        if (id > 0) {
            Connection connection = DBUtils.getConnection();
            String sql = "delete from articleinfo where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeUpdate();
            DBUtils.close(connection, statement, null);
        }
        return result;
    }

}
