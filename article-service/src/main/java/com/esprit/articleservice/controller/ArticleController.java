package com.esprit.articleservice.controller;

import com.esprit.articleservice.dto.ArticleDTO;
import com.esprit.articleservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ArticleDTO create(@RequestBody ArticleDTO articleDTO) {
        return articleService.createArticle(articleDTO);
    }

    @GetMapping
    public List<ArticleDTO> getAll() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ArticleDTO getById(@PathVariable Long id) {
        return articleService.getArticleById(id).orElseThrow();
    }

    @PutMapping
    public ArticleDTO update(@RequestBody ArticleDTO articleDTO) {
        return articleService.updateArticle(articleDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}