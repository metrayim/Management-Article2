package com.example.amssr.demo.utility;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Paging {
    private int page;
    private int limit;

    private int nextPage;
    private int previousPage;

    private int totalCout;
    private int totalPage;

    private int pageToShow;
    private int startPage;
    private int endPage;


    @JsonIgnore
    private int offset;

    public Paging(){
        this(1,10,0,0,5);
    }

    public Paging(int page, int limit, int totalCout, int totalPage, int pageToShow) {
        this.page = page;
        this.limit = limit;
        this.totalCout = totalCout;
        this.totalPage = totalPage;
        this.pageToShow = pageToShow;

    }

    public int getPage() {
        return page;
    }

    public void setPage(int currentPage){
        this.page=(currentPage<=1)?1:currentPage;
    }
    public int getLimit(){
        return limit;
    }
    public void setLimit(int limit){
        this.limit=limit;
    }
    public int getTotalPage(){
        return (int)Math.ceil((double)this.totalCout/limit);
    }
    public void setTotalPage(int totalPage){
        this.totalPage=totalPage;
    }
    public int getOffset(){
        return (this.page-1)*this.limit;
    }
    public int getNextPage(){
        return (int) (page>=getTotalPage()? getTotalPage():page+1);
    }
    public int getPreviousPage(){
        return (page<=1)?1:page-1;
    }
    public int getStartPage(){
        return startPage;
    }
    public int getEndPage(){
        return endPage;
    }
    public int getPageToShow(){
        return pageToShow;
    }
    public void setPageToShow(int pageToShow){
        this.pageToShow=pageToShow;
    }
    public int getTotalCout(){
        return totalCout;
    }
    public void setTotalCout(int totalCout){
        this.totalCout=totalCout;
        this.setStarPageEndPage(getTotalPage());
    }
    private void setStarPageEndPage(int totalPage){
        int halfPagesToShow=pageToShow/2;
        if(totalPage<=pageToShow){
            startPage=1;
            endPage=totalPage;
        }
        else if(page-halfPagesToShow<=0){
            startPage=1;
            endPage=pageToShow;
        }else if(page+halfPagesToShow==totalPage){
            startPage=page-halfPagesToShow;
            endPage=totalPage;
        }
        else if (page+halfPagesToShow>totalPage){
            startPage=totalPage-pageToShow+1;
            endPage=totalPage;
        }
        else {
            startPage=page-halfPagesToShow;
            endPage=page+halfPagesToShow;
        }
    }

    @Override
    public String toString() {
        return "Paging{" +
                "page=" + page +
                ", limit=" + limit +
                ", nextPage=" + nextPage +
                ", previousPage=" + previousPage +
                ", totalCout=" + totalCout +
                ", totalPage=" + totalPage +
                ", pageToShow=" + pageToShow +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", offset=" + offset +
                '}';
    }
}
