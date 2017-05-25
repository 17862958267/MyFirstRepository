package cn.qlu.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/one")
public class OneServlet extends HttpServlet {
	protected static final long serialVersionUID = 1L;
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//在servlet中，对数据进行压缩
    	int times = 1;
		times = Integer.parseInt(req.getParameter("times"));
		String str = "你好同学";
		for (int i = 0; i < times; i++) {
			str += "你好同学" + i;
		}
		// 1：获取压缩源的字节码
		byte[] bs = str.getBytes();// 12 bytes
		// 2:声明压缩工工具流
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(bout);
		gzip.write(bs);
		gzip.close();
		// 获取压缩以后的数据
		byte[] dest = bout.toByteArray();
		System.err.println("压缩之前：" + bs.length);// 12
		System.err.println("压缩之后：" + dest.length);

		resp.setContentType("text/html;charset=UTF-8");
		// 输出压缩后的数据
		// 必须要通知浏览器这个是压缩过的数据
		resp.setHeader("Content-Encoding","gzip");
		resp.setContentLength(dest.length);
		resp.getOutputStream().write(dest);
    }
}
