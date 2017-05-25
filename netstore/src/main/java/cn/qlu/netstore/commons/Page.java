package cn.qlu.netstore.commons;

import java.util.List;

public class Page {
	private List records;
	private Integer pageNum;//当前页码
	private Integer totalPageNum;//总页码数
	private Integer prePageNum;//上一页
	private Integer nextPageNum;//下一页
	private Integer pageSize = 3;//每页显示的记录数
	private Integer totalRecordsNum;//显示总记录条数
	private Integer startIndex;//每页开始记录的索引
	private String url;//请求查询分页的URL地址
	public Page(int pageNum, int totalRecordsNum){//传入当前页码以及总记录数
		this.pageNum = pageNum;
		this.totalPageNum = totalRecordsNum;
		//计算总页码数
		totalPageNum = totalRecordsNum%pageSize==0?totalRecordsNum/pageSize:(totalRecordsNum/pageSize+1);
		//计算开始索引
		startIndex = (pageNum-1)*pageSize;
		
	}
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(Integer totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public Integer getPrePageNum() {
		prePageNum = pageNum-1;
		if(prePageNum<1){
			prePageNum =1;
		}
		
		return prePageNum;
	}
	public void setPrePageNum(Integer prePageNum) {
		this.prePageNum = prePageNum;
	}
	public Integer getNextPageNum() {
		nextPageNum = pageNum+1;
		if(pageNum>totalPageNum){
			nextPageNum = totalPageNum;
		}
		return nextPageNum;
	}
	public void setNextPageNum(Integer nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalRecordsNum() {
		return totalRecordsNum;
	}
	public void setTotalRecordsNum(Integer totalRecordsNum) {
		this.totalRecordsNum = totalRecordsNum;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
