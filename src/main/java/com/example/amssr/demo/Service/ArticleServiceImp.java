package com.example.amssr.demo.Service;

import com.example.amssr.demo.Model.Article;
import com.example.amssr.demo.Model.ArticleFilter;
import com.example.amssr.demo.Model.Category;
import com.example.amssr.demo.respository.ArticleRepository;
import com.example.amssr.demo.utility.Paging;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ArticleServiceImp implements ArticleService{
    private ArticleRepository articleRepository;
    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }



    @Override
    public List<Article> findAll() {
//        paging.setTotalCout(articleRepository.countAllArticle());
        return articleRepository.findAll();
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id);
    }
    @Override
    public void add(Article article){
        article.setCreatedData(new Date().toString());
        articleRepository.add(article);
    }
    @Override
    public void delete(int id){
        articleRepository.delete(id);
    }

    @Override
    public void update(Article article) {
        article.setCreatedData(new Date().toString());
        articleRepository.update(article);
    }
    public List<Article> findAllFilter(@Param("filter") ArticleFilter filter, @Param("paging") Paging paging){
        paging.setTotalCout(articleRepository.countAllArtilces(filter));
        return  articleRepository.findAllFilter(filter,paging);
    }


}
