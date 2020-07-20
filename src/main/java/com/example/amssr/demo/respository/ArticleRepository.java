package com.example.amssr.demo.respository;

import com.example.amssr.demo.Model.Article;
import com.example.amssr.demo.Model.ArticleFilter;
import com.example.amssr.demo.Model.Category;
import com.example.amssr.demo.respository.ArticleProvider;
import com.example.amssr.demo.utility.Paging;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArticleRepository  {


    @SelectProvider(method ="findAll",type = ArticleProvider.class)
    @Results({
            @Result(property="createdData",column = "create_date"),
          @Result(property="category",column = "category_id", one = @One(select ="findOne2"))


    })

    List<Article> findAll();


    @SelectProvider(method = "findOne2",type = ArticleProvider.class)
    @Results({
            @Result(property="nameCategory",column = "category_name")
    })
    Category findOne2(int id);


   @Select("select * from tb_article where id=#{id}")
   // @SelectProvider(method = "findById",type=ArticleProvider.class)
    @Results({
            @Result(property="createdData",column = "create_date"),
            @Result(property="category",column = "category_id", one = @One(select ="findOne2"))
    })
    Article findById(int id);


//    @Insert("Insert into tb_article (title,description,author,image,create_date,category_id)"+
//            "values(#{title},#{description},#{author},#{image},#{createdData},#{article.getCategory().getId())})")

    @InsertProvider(method = "Insert",type = ArticleProvider.class)
    @Results({
            @Result(property="createdData",column = "create_date"),
            @Result(property="nameCategory",column = "category_name"),
            @Result(property="id",column = "category_id")
    })
    void add(Article article);



//    @Delete("delete from tb_article where id=#{id}")
    @DeleteProvider(method = "delete",type = ArticleProvider.class)
    @Results({
            @Result(property="createdData",column = "create_date"),
            @Result(property="nameCategory",column = "category_name")
    })
    void delete(int id);




//    @Update("update tb_article set title=#{title},description=#{description},author=#{author},image=#{image},create_date=#{createdData} where id=#{id}")
   @UpdateProvider(method="update",type=ArticleProvider.class)
    @Results({
            @Result(property="createdData",column = "create_date"),
            @Result(property="nameCategory",column = "category_name")
    })
    void update(Article article);




    @SelectProvider(method ="findAllFilter",type = ArticleProvider.class)
    @Results({
            @Result(property="createdData",column = "create_date"),
            @Result(property="category",column = "category_id", one = @One(select ="findFilterOne2"))


    })

    List<Article> findAllFilter(@Param("filter") ArticleFilter  filter,@Param("paging")Paging paging);


    @SelectProvider(method = "findOne2",type = ArticleProvider.class)
    @Results({
            @Result(property="nameCategory",column = "category_name")
    })
    Category findFilterOne2(int id);

    @SelectProvider(method = "countAllArtilces",type = ArticleProvider.class)
    public Integer countAllArtilces(ArticleFilter filter);


}
