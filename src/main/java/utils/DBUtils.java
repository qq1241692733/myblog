package utils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/22
 * Time: 18:39
 */
public class DBUtils {
    private static MysqlDataSource dataSource = null;

    /**
     * 得到 Connection 的通用方法
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {    //选择 java.sql下的 Connection
        if (dataSource == null) {
            // 第一次调用
            dataSource = new MysqlDataSource();
           // dataSource.setURL("jdbc:mysql://127.0.0.1:3306/myblog?characterEncoding=utf-8");
            dataSource.setURL("jdbc:mysql://127.0.0.1:3306/myblog?characterEncoding=utf-8");
            dataSource.setUseSSL(false);
            dataSource.setUser("root");

            dataSource.setPassword("jhy1241692733");
        }
        return dataSource.getConnection();
    }

    /**
     * 通用关闭方法
     * @param connection
     * @param statement
     * @param resultSet
     * @throws SQLException
     */
    public static void close(Connection connection,
                             PreparedStatement statement,
                             ResultSet resultSet) throws SQLException {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
}
