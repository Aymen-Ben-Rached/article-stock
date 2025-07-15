package com.esprit.stockservice.repository;

import com.esprit.stockservice.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockRepository extends MongoRepository<Stock, String> {
    Stock findByArticleId(Long articleId);
    List<Stock> findAll();
}