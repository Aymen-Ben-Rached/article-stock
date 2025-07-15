package com.esprit.sharedlibrary.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private String id;
    private Long articleId;
    private Integer quantity;
}