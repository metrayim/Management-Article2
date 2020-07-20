package com.example.amssr.demo.respository;

import com.example.amssr.demo.Model.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategotyRepository {
    @Select("select * from tbl_category")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "nameCategory",column = "category_name")

    })
    List<Category> findAll();


        @Select("select * from tbl_category where id=#{id}")
        @Results({
                @Result(property = "id",column = "id"),
                @Result(property = "nameCategory",column = "category_name")

        })
     Category findOne(int id);

    @Select("Insert into tbl_category (category_name) values (#{nameCategory})")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "nameCategory",column = "category_name")

    })
     void addCategory(Category category);

    @DeleteProvider(method = "deleteCategory",type = ArticleProvider.class)
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "nameCategory",column = "category_name")

    })
    void deleteCategory(int id);


    @UpdateProvider(method = "updateCategory",type = ArticleProvider.class)
    void updateCategory(Category category);
}
