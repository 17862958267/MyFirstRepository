package cn.qlu.tag;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TokenTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		//将任意值放到session中去，将hidden表单信息输出到页面
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		PageContext pc = (PageContext) getJspContext();
		HttpSession session = pc.getSession();
		session.setAttribute("_token_", id);
		String html ="<input type='hidden' name='_token_' value='"+id+"'>";
		pc.getOut().print(html);
		
	}

}
