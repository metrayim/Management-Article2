package com.example.amssr.demo.Controller;

import com.example.amssr.demo.Model.Article;
import com.example.amssr.demo.Model.ArticleFilter;
import com.example.amssr.demo.Model.Category;
import com.example.amssr.demo.Service.ArticleService;
import com.example.amssr.demo.Service.ArticleServiceImp;
import com.example.amssr.demo.Service.CategoryService;
//import com.example.amssr.demo.Service.CategoryServiceImpl;
import com.example.amssr.demo.respository.CategotyRepository;
import com.example.amssr.demo.utility.Paging;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@PropertySource("classpath:ams.properties")
public class HomeController {

    private CategoryService categoryService;

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService=categoryService;
    }




    @GetMapping("/")
    public String home(@Param("filter") ArticleFilter filter,@Param("paging")Paging paging, Model model){

            List<Article> articles=articleService.findAllFilter(filter,paging);
        model.addAttribute("articles",articles);
        model.addAttribute("filter",filter);
        model.addAttribute("paging", paging);
        model.addAttribute("categories", categoryService.findAll());
        return"index";
    }
    @GetMapping("/add")
        public String add(ModelMap m, @ModelAttribute Article article){
        m.addAttribute("article",new Article());
        m.addAttribute("categories", categoryService.findAll());
        m.addAttribute("isAdd",true);
        return "add";
        }


    @Value("${file.image.clint}")
        String clint;
    @PostMapping("/add")
        public String intsertArticle(@Valid @ModelAttribute Article article, BindingResult result,Model m,@RequestParam("file")MultipartFile file){

            if(result.hasErrors()){
                m.addAttribute("article",article);
                m.addAttribute("categories",categoryService.findAll());
                m.addAttribute("categoryName",categoryService.findOne(article.getCategory().getId()));
                m.addAttribute("isAdd",true);
                return "add";
            }
            if(!file.isEmpty()){
                try {
                    String nameFile= UUID.randomUUID().toString()+file.getOriginalFilename();
                    Files.copy(file.getInputStream(), Paths.get(clint,nameFile));
                    article.setImage(nameFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else{
                article.setImage("6f7bf6cf-d154-4ad4-907b-5e024e610b4d33599867_146811572843226_8285361190977142784_n.jpg");
            }


//            article.setCategory(categoryService.findOne(article.getCategory().getId()));
        System.out.println(article.getCategory().getId());

            articleService.add(article);

             return "redirect:/";
      }


      @GetMapping("/delete/{id}")
            public String delete(@PathVariable Integer id){
            articleService.delete(id);
            return "redirect:/";
    }
    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);

        return "redirect:/viewCategory";
    }


    @GetMapping("/update/{id}")
        public String update(ModelMap m ,@PathVariable Integer id){
            articleService.findById(id).getId();
            m.addAttribute("article",articleService.findById(id));
            m.addAttribute("categories",categoryService.findAll());
            m.addAttribute("isAdd",false);
            return "add";
    }


    @PostMapping("/update")
        public String SaveUpdate( @ModelAttribute Article article,@RequestParam("file")MultipartFile file){
              if(!file.isEmpty()){

                try {
                    String nameFile= UUID.randomUUID().toString()+file.getOriginalFilename();
                    Files.copy(file.getInputStream(), Paths.get(clint,nameFile));
                    article.setImage(nameFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            article.setCategory(categoryService.findOne(article.getCategory().getId()));
            articleService.update(article);
            return "redirect:/";
    }
    @PostMapping("/updateCategory")
    public String SaveUpdateCategory(@ModelAttribute Category category){
        System.out.println("hellldld");
        categoryService.updateCategory(category);
        return "redirect:/viewCategory";
    }
    @GetMapping("/Veiw/{id}")

        public String viewItem(Model m,@PathVariable Integer id){
            Article article = articleService.findById(id);
            m.addAttribute("article",article);
            return "Veiw";
    }
    @GetMapping("/viewCategory")
    public String viewCategory(ModelMap m){
    List<Category> categories=categoryService.findAll();
    m.addAttribute("categories",categories);
        return "listCategory";
    }
    @GetMapping("/addCategory")
    public String addCagtegory(ModelMap m,@ModelAttribute Category category){
        m.addAttribute("categoris",new Category());
        m.addAttribute("isAdd",true);
        return "addCategory";
    }
    @PostMapping("/addCategory")
    public String insertCategory(Model m,@ModelAttribute Category category){
        categoryService.addCategory(category);
        m.addAttribute("isAdd",true);
        return "redirect:/addCategory";
    }
    @GetMapping("/updateCategory/{id}")
    public String updateCategory(ModelMap m,@PathVariable Integer id){
        // categoryService.findOne(id).getId();
        m.addAttribute("categoris",categoryService.findOne(id));
        m.addAttribute("isAdd",false);
        return "addCategory";
    }

}
