package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *      给前端输出 json 数据
 * User: hong yaO
 * Date: 2021-08-2021/8/23
 * Time: 12:33
 */
public class ResultJSONUtils {
    public static void write(HttpServletResponse response,
                             HashMap<String, Object> data) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(data);
        writer.println(result);
    }
}
