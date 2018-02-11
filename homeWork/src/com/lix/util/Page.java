package com.lix.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 15:302017/11/28
 * @modify by :
 */
public class Page implements Serializable {

    static private int DEFAULT_PAGE_SIZE = 20;

    /**
     * 分页大小
     */
    private int pageSize = DEFAULT_PAGE_SIZE;
    private int start;
    /**
     * 数据
     */
    private Object data;

    /**
     * 总记录数
     */
     private long totalCount;

     public Page(){
         this(0,0,DEFAULT_PAGE_SIZE,new ArrayList());
     }
     public Page(int start, long totalCount,int pageSize,Object data){
         this.start = start;
         this.data = data;
         this.totalCount = totalCount;
         this.pageSize = pageSize;
     }
     public long getTotalCount(){
         return  this.totalCount;
     }

     public void setTotalCount(long totalCount){
         this.totalCount = totalCount;
     }

     public long getTotalPageCount(){
         if (totalCount % pageSize == 0){
             return  totalCount / pageSize;
         }else {
             return totalCount / pageSize + 1;
         }
     }

     public int getPageSize(){
         return pageSize;
     }

    public Object getResult() {
        return data;
    }

    public void setList(List data){
         this.data = data;
    }

    public int getCurrentPageNo(){
        if (totalCount == 0)
            return  start / pageSize;
        else
            return start / pageSize + 1;
    }

    public boolean hasNextPage(){
        return  this.getCurrentPageNo() < this.getTotalCount() - 1;
    }

    public boolean  hasPreviousPage(){
        return this.getCurrentPageNo() > 1;
    }

    protected static  int getStartOfPage(int pageNo){
        return getStartOfPage(pageNo,DEFAULT_PAGE_SIZE);
    }

    public static int getStartOfPage(int pageNo,int pageSize){
        return (pageNo - 1) * pageSize;
    }

    public Object getData(){
        return data;
    }
    public void setData(Object data){
        this.data = data;
    }

    public long getFistPage(){
        return totalCount > 0 ? 1 : 0;
    }

    public long getLastPage(){
        return getTotalPageCount();
    }

    public long getNextPage(){
        if (getTotalCount() == 0 )
            return  0;
        long currPage = getCurrentPageNo();
        if (currPage > 0){
            currPage ++;
            if (currPage > getTotalPageCount())
                currPage = getTotalPageCount();
        }
        else  currPage = 0;
        return  currPage;
    }

    public long getPrevPage(){
        if (getTotalPageCount() == 0)
            return 0;
        long currPage = getCurrentPageNo();
        if (currPage > 0){
            currPage = (currPage == 1 ? 1 : currPage - 1);
        }
        else currPage = 0;
        return  currPage;
    }

    public int getStart(){
        return start;
    }
    public  void setStart(int start){
        this.start = start;
    }
}
