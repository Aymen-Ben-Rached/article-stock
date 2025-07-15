package com.esprit.articleservice.service;

import com.esprit.articleservice.dto.ArticleDTO;
import com.esprit.articleservice.entity.Article;
import com.esprit.articleservice.mapper.ArticleMapper;
import com.esprit.articleservice.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public ArticleService(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Article article = articleMapper.toEntity(articleDTO);
        return articleMapper.toDTO(articleRepository.save(article));
    }

    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(articleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ArticleDTO> getArticleById(Long id) {
        return articleRepository.findById(id).map(articleMapper::toDTO);
    }

    public ArticleDTO updateArticle(ArticleDTO articleDTO) {
        Article article = articleMapper.toEntity(articleDTO);
        return articleMapper.toDTO(articleRepository.save(article));
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}