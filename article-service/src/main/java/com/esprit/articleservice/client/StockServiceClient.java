package com.esprit.articleservice.client;

import com.esprit.sharedlibrary.dto.StockDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service")
public interface StockServiceClient {

    @GetMapping("/stocks/article/{articleId}")
    StockDTO getStockByArticleId(@PathVariable Long articleId);
}
