package dao;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/22
 * Time: 18:37
 */



/**
 * 操作 UserInfo 用户表
 *   executeUpdate(): 返回值是一个整数（int），指示受影响的行数（即更新计数）。
 *     对于 CREATE TABLE 或 DROP TABLE 等不操作行的语句，executeUpdate 的返回值总为零。
 */
public class UserInfoDao {
    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public int addUser(String username, String password) throws SQLException {
        int result = 0;
        // 链接数据库
        Connection connection = DBUtils.getConnection();
        // sql语句
        String sql = "insert into userinfo(username,password) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        result = statement.executeUpdate();
        // 关闭数据库
        DBUtils.close(connection, statement, null);
        return result;
    }
}