package com.jd.util;
public class Page {
	private int everyPage = 5; // 每页显示的条数
	private int totalCount; // 总共需要显示的条数
	private int totalPage; // 总共需要显示的页数
	private int PageNow = 1; // 开始的页数
	private int beginStart=0;
	/** 
	   * 初始化：当获得了总共需要显示的条数后即可执行这个方法 
	   */  
	  public void init(){  
	      int totalPage = totalCount % everyPage == 0 ? totalCount / everyPage : totalCount / everyPage + 1;  
	      this.setTotalPage(totalPage); 
	      int beginStart=(PageNow-1)*everyPage;
	      this.setBeginStart(beginStart);
	  }  
	public int getEveryPage() {
		return everyPage;
	}
	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageNow() {
		return PageNow;
	}
	public void setPageNow(int pageNow) {
		PageNow = pageNow;
	}
	public int getBeginStart() {
		return beginStart;
	}
	public void setBeginStart(int beginStart) {
		this.beginStart = beginStart;
	}

}
