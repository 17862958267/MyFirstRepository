package cn.qlu.netstore.book;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import cn.qlu.netstore.domain.Book;
import cn.qlu.netstore.domain.Category;
import cn.qlu.netstore.service.Service;
import cn.qlu.netstore.service.ServiceImpl;
import cn.qlu.netstore.utils.GenChildDirectory;
import cn.qlu.netstore.utils.IdGenerator;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	private Service service = new ServiceImpl();
     @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 //1.判断表单是否是multipart/form-data类型
    	 boolean isMultipart = ServletFileUpload.isMultipartContent(req);
         if(!isMultipart){
        	 throw new RuntimeException("the form is not multipart/form-data");
         }
        	 //2.请求解析内容
        	DiskFileItemFactory factory = new DiskFileItemFactory(); 
        	ServletFileUpload  sfu = new ServletFileUpload(factory);
        	List<FileItem> items = new ArrayList<FileItem>(); 
        	  try {
				items = sfu.parseRequest(req);
			} catch (FileUploadException e) {			
				e.printStackTrace();
			}
        	  Book book = new Book();//空对象
        	  //3.遍历表单获取数据
        	  for(FileItem item :items){
        		  if(item.isFormField()){
        			  //如果是普通表单数据，则将数据封装到javabean中
        			  processFormField(item,book);
        		  }else{
        			  //上传字段，处理上传
        			  processUploadField(item,book);  
        		  }
        		  
        	  } 
        	  service.addBook(book);//添加图书
        	  resp.sendRedirect(req.getContextPath()+"/common/message.jsp");
     }
          //处理文件上传
      private void processUploadField(FileItem item, Book book) {
		  //存放路径，不要放在web-INF中
    	  String storeDirectory = getServletContext().getRealPath("/images");
		  File rootDirectory = new File(storeDirectory);//这三行代码是如果存放的路径不存在就创建目录
		  if(!rootDirectory.exists()){
			  rootDirectory.mkdirs();
		  }
		  //解决文件名
		  String filename = item.getName();//比如上传的名为a.jpg
		  if(filename!=null){//更改后为283453fsdyfhu.jpg
			  filename = IdGenerator.genID()+"."+FilenameUtils.getExtension(filename);
			  book.setFilename(filename);
		  } 
		  //获取工具类，生成子目录
		  String path = GenChildDirectory.genChildDirectory();
		  book.setPath(path);
		  //开始上传
		  try{
			  item.write(new File(storeDirectory,filename));			  
		  }catch(Exception e){
			  e.printStackTrace();
		  }	  
	}
	//处理普通表单项
	private void processFormField(FileItem item, Book book) {
		try{
		String fieldName = item.getFieldName();//普通表单项的名称
		String fieldValue = item.getString("UTF-8");//对应名称的值
		BeanUtils.setProperty(book, fieldName, fieldValue);//封装数据
		//单独处理书籍所属的分类
		if("categoryId".equals(fieldName)){
			Category c = service.findById(fieldValue);
			book.setCategory(c);
		}
		}catch(Exception e){
			 throw new RuntimeException(e);
		}	
	}
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
      
}
