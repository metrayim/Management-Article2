package com.example.amssr.demo.Service;

import com.example.amssr.demo.Model.Article;
import com.example.amssr.demo.Model.ArticleFilter;
import com.example.amssr.demo.Model.Category;
import com.example.amssr.demo.utility.Paging;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findOne(int id);
    List<Article> findAllFilter(@Param("filter") ArticleFilter filter,@Param("paging") Paging paging);
    void addCategory(Category category);
    void deleteCategory(int id);
    void updateCategory(Category category);

}
