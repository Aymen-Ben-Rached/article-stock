package com.esprit.stockservice.client;

import com.esprit.sharedlibrary.dto.ArticleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "article-service")
public interface ArticleServiceClient {

    @GetMapping("/articles/{id}")
    ArticleDTO getArticleById(@PathVariable Long id);
}