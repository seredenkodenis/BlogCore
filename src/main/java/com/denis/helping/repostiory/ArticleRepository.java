package com.denis.helping.repostiory;


import com.denis.helping.model.Article;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
        List<Article> findArticleByTag(String Tag);
        Article findArticleById(int id);


}