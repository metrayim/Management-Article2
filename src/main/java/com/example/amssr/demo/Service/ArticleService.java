package com.example.amssr.demo.Service;

import com.example.amssr.demo.Model.Article;
import com.example.amssr.demo.Model.ArticleFilter;
import com.example.amssr.demo.Model.Category;
import com.example.amssr.demo.utility.Paging;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ArticleService {
    List<Article> findAll();
    Article findById(int id);
    void add(Article article);
    void delete(int id);
    void update(Article article);

    List<Article> findAllFilter(@Param("filter") ArticleFilter filter,@Param("paging") Paging paging);






}
