package cn.qlu.netstore.regist;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/image")
public class ImgServlet extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   //1.设置输出格式
	   resp.setContentType("image/jpeg");
	   //2.设置响应头信息
	   resp.setHeader("Param","No-cache");
	   resp.setHeader("Cache-Control","no-cache");
	   resp.setDateHeader("Expires", -1);//立即过期
	   //3.创建随机对象
	   Random r = new Random();
	   int strCount = 4;//四个随机字符
	   int lineCount =10;//干扰线数量
	   char[] codeSequence = {'A','B','C','D','E','1','2','3','4','5','6','7','8','9'};
	   //4.创建内存中的图
	   int width = 60;
	   int height =30;
	   BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_4BYTE_ABGR);
	   //5.获取画布
	   Graphics g = img.getGraphics();
	   g.setColor(Color.WHITE);
	   g.fillRect(0, 0, width, height);
	   //6.设置字体
	   g.setFont(new Font("宋体",Font.BOLD,30));
	   g.setColor(Color.BLACK);
	   //7.产生随机干扰线
	   for(int i = 1; i<lineCount;i++){
		   int x = r.nextInt(width);
		   int y = r.nextInt(height);
		   int x1 = r.nextInt(12);
		   int y1 = r.nextInt(12);
		   g.drawLine(x, y, x1, y1); 
	   }
	   //8.randomCode 用于保存随机产生的验证码，以便登录验证
	   StringBuffer randomCode = new StringBuffer();
	   int red=0,green=0,blue=0;
	   for(int i =0; i<strCount;i++){
		   //9.获取验证码
		   String strRand = String.valueOf(codeSequence[r.nextInt(14)]);
		   //10.产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值将不同
	       red = r.nextInt(255);
	       green =r.nextInt(255);
	       blue = r.nextInt(255);
	       g.setColor(new Color(blue,green,red));
	       //11.用随机产生的颜色将验证码绘制到图像中
	       g.drawString(strRand,(i+1)*(width/(strCount+1)) ,height-5); 
	       //12.将产生的四个随机数结合在一起。
		   randomCode.append(strRand);
	   }
	     //13.将验证码保存到session中
	   req.getSession().setAttribute("validateCode", randomCode.toString());
	     //14.让图片生效
	    g.dispose();
	    ImageIO.write(img, "jpeg", resp.getOutputStream());   
}
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
