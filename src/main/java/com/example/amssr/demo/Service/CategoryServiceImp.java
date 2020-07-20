package com.example.amssr.demo.Service;

import com.example.amssr.demo.Model.Article;
import com.example.amssr.demo.Model.ArticleFilter;
import com.example.amssr.demo.Model.Category;
import com.example.amssr.demo.respository.ArticleRepository;
import com.example.amssr.demo.respository.CategotyRepository;
import com.example.amssr.demo.utility.Paging;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategotyRepository categotyRepository;
    @Override
    public List<Category> findAll() {
        return categotyRepository.findAll();
    }

    @Override
    public Category findOne(int id) {
        return categotyRepository.findOne(id);
    }

    @Override
    public List<Article> findAllFilter(@Param("filter") ArticleFilter filter,@Param("paging") Paging paging) {
        return articleRepository.findAllFilter(filter,paging);
    }
    @Override
    public  void addCategory(Category category){
         categotyRepository.addCategory(category);
    }

    @Override
    public void deleteCategory(int id){
        categotyRepository.deleteCategory(id);
    }
    @Override
    public void updateCategory(Category category){
        categotyRepository.updateCategory(category);
    }
}
