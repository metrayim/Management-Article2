package com.example.amssr.demo.Model;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Article {

    private Integer id;
    @NotNull
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    @NonNull
    @Size(min = 3,max = 8)
    private String author;
    private String createdData;

    private String image;

    private Category category;

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", createdData='" + createdData + '\'' +
                ", image='" + image + '\'' +
                ", category=" + category +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreatedData() {
        return createdData;
    }

    public void setCreatedData(String createdData) {
        this.createdData = createdData;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Article(Integer id, @NotNull @NotBlank String title, @NotBlank String description, @NotBlank @Size(min = 3, max = 8) String author, String createdData, String image, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.createdData = createdData;
        this.image = image;
        this.category = category;
    }
}
