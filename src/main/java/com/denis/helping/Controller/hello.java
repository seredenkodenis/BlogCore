package com.denis.helping.Controller;


import com.denis.helping.model.Article;
import com.denis.helping.repostiory.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class hello {



    @Autowired
    private ArticleRepository articleRepository;



    @GetMapping("/greeting")
    public String greeting(@RequestParam(name= "name",required = false,defaultValue = "World") String name , Model model){
        model.addAttribute("name", name);
        return "greeting";
    }



    @GetMapping("/main")
    public String mainpage(Model model){
        return "main";
    }


    @GetMapping("/news")
    public String news(Model model){
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles",articles);
        return "news";
    }

    @GetMapping(value = "/news/{id}")
    public String getFoosBySimplePathWithPathVariable(@PathVariable("id") int  id, Model model){
        Article article = articleRepository.findArticleById(id);
        String arttitle = article.getTitle();
        String artcontent = article.getContent();
        model.addAttribute("arttitle",arttitle);
        model.addAttribute("artcontent",artcontent);
        return "fullnews";
    }




    @PostMapping("/news")
    public String news(@RequestParam String tag, Model model){
        Iterable<Article> articles;
        if(tag != null && !tag.isEmpty()){
            articles = articleRepository.findArticleByTag(tag);
        }else {
            articles = articleRepository.findAll();
        }
        model.addAttribute("articles", articles);
        return "news";
    }






    @GetMapping("/edit")
    public String edit(Model model){
        return "edit";
    }

    @PostMapping("/edit")
    public String editt(@RequestParam int id, @RequestParam String title, @RequestParam String content, @RequestParam String tag, Model model){
        Article articleidi = articleRepository.findArticleById(id);
        articleidi.setTag(tag);
        articleidi.setContent(content);
        articleidi.setTitle(title);
        articleRepository.save(articleidi);
        return "edit";
    }






    @GetMapping("/addnews")
    public String add(Model model){
        return "addnews";
    }

    @PostMapping("/addnews")
    public String addnews(@RequestParam String title, @RequestParam String content, @RequestParam String tag, Model model){
        Article article = new Article(title,content,tag);
        articleRepository.save(article);
        return "/news";
    }

    @GetMapping("/delete")
    public String delete(Model model){
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id){
        Article article = articleRepository.findArticleById(id);
        articleRepository.delete(article);
        return "delete";
    }
}


