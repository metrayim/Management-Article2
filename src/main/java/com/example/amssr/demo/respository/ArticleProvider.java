package com.example.amssr.demo.respository;

import com.example.amssr.demo.Model.Article;
import com.example.amssr.demo.Model.ArticleFilter;
import com.example.amssr.demo.Model.Category;
import com.example.amssr.demo.utility.Paging;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.context.annotation.Profile;


public class ArticleProvider {
    public String findAll(){
        return new SQL(){{
           SELECT("*");
           FROM("tb_article ");

        }}.toString();

    }
    public String findOne2(){
        return new SQL(){{
            SELECT("*");
            FROM("tbl_category");
            WHERE("id=#{id}");
        }}.toString();
    }
    public String findById(){
        return  new SQL(){{
            SELECT("*");
            FROM("tb_article");
            WHERE("id=#{id}");

        }
        }.toString();
    }
    public String Insert(Article article){{
        return new SQL(){{
            INSERT_INTO("tb_article");
            VALUES("title","'"+article.getTitle()+"'");
            VALUES("description","'"+article.getDescription()+"'");
            VALUES("author","'"+article.getAuthor()+"'");
            VALUES("image","'"+article.getImage()+"'");
            VALUES("create_date","'"+article.getCreatedData()+"'");
            VALUES("category_id","'"+article.getCategory().getId()+"'");
        }}.toString();
    }
    }
    public String delete(){
        return new SQL(){{
            DELETE_FROM("tb_article");
            WHERE("id=#{id}");
        }}.toString();
    }

    public String update(Article article){
        return new SQL(){{
            UPDATE("tb_article");
            SET("id="+article.getId());
            SET("title="+"'"+article.getTitle()+"'");
            SET("description="+"'"+article.getDescription()+"'");
            SET("author="+"'"+article.getAuthor()+"'");
            SET("image="+"'"+article.getImage()+"'");
            SET("create_date="+"'"+article.getCreatedData()+"'");
            SET("category_id="+"'"+article.getCategory().getId()+"'");



            WHERE("id="+"'"+article.getId()+"'");
        }}.toString();
    }
    public String countAllAritcle(Article article){
        return  new SQL(){{
            SELECT("COUNT(id)");
            FROM("tb_article");


        }}.toString();
    }



    public String findAllFilter(@Param("filter") ArticleFilter filter,@Param("paging")Paging paging){
        return new SQL(){{
            SELECT("a.id,a.title,a. description,a.author,a.image,a.create_date,a.category_id");
            FROM("tb_article a ");
            if(filter.getTitle() !=null){
                WHERE("a.title ILIKE '%' ||  #{filter.title} || '%' ");
            }
            if(filter.getCate_id() !=null){
                WHERE("a.category_id=#{filter.cate_id}");
            }
            ORDER_BY("a.id ASC LIMIT #{paging.limit} OFFSET #{paging.offset}");

        }}.toString();

    }
    public String findFilterOne2(){
        return new SQL(){{
            SELECT("*");
            FROM("tbl_category");
            WHERE("id=#{id}");
        }}.toString();
    }
    public String countAllArtilces(ArticleFilter filter){
        return  new SQL(){{
            SELECT("COUNT(id)");
            FROM("tb_article");
            if(filter.getTitle() !=null){
                WHERE("title ILIKE '%' ||  #{title} || '%' ");
            }
            if(filter.getCate_id() !=null){
                WHERE("category_id=#{cate_id}");
            }

        }}.toString();
    }
    public String deleteCategory(){
        return new SQL(){{
            DELETE_FROM("tbl_category");
            WHERE("id=#{id}");
        }}.toString();
    }
    public String updateCategory(Category category){
        return new SQL(){{
            UPDATE("tbl_category");
            SET("category_name="+"'"+category.getNameCategory()+"'");

            WHERE("id="+category.getId());
        }}.toString();
    }
}
