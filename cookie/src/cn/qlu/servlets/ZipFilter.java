package cn.qlu.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
@WebFilter("/two")
public class ZipFilter implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		       // 3:声明包装类
				MyResponse resp = new MyResponse((HttpServletResponse) response);
				// 4:放行
				chain.doFilter(request, resp);
				// 5:在Servlet执行完成以后，即数据输出完成了，获取Servlet输出的所有数据，开始压缩输出
				byte[] src = resp.getSrc();
				//6开始压缩
				ByteArrayOutputStream bout = new ByteArrayOutputStream();
				GZIPOutputStream zip = new GZIPOutputStream(bout);
				zip.write(src);
				zip.close();
				//7:获取压缩以后的数据
				byte[] desc = bout.toByteArray();
				System.err.println("..原来："+src.length);
				System.err.println("..压缩："+desc.length);
				//8：输出
				resp.setContentType("text/html;charset=UTF-8");
				resp.setHeader("Content-Encoding", "gzip");
				resp.getOutputStream().write(desc);
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	// 1:开发一个Response的包装类
	class MyResponse extends HttpServletResponseWrapper {
		private PrintWriter out;
		private ByteArrayOutputStream bout = new ByteArrayOutputStream();

		public MyResponse(HttpServletResponse response) {
			super(response);
		}
		// 2:重写增强的方法
		@Override
		public PrintWriter getWriter() throws IOException {
			out = new PrintWriter(bout);
			return out;
		}
		public byte[] getSrc() {
			if (out != null) {
				out.close();
				out = null;
			}
			return bout.toByteArray();
		}
	}

}
