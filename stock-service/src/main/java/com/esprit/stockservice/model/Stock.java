package com.esprit.stockservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "stocks")
public class Stock {
    @Id
    private String id;
    private Long articleId;
    private Integer quantity;
}