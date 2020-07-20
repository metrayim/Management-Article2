package com.example.amssr.demo.Model;

public class ArticleFilter {
    private String title;
    private Integer cate_id;

    public ArticleFilter() {
    }

    public ArticleFilter(String title, Integer cate_id) {
        this.title = title;
        this.cate_id = cate_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    @Override
    public String toString() {
        return "ArticleFilter{" +
                "title='" + title + '\'' +
                ", cate_id=" + cate_id +
                '}';
    }
}
