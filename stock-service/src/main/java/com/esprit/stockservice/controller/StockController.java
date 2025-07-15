package com.esprit.stockservice.controller;

import com.esprit.stockservice.dto.StockDTO;
import com.esprit.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public StockDTO create(@RequestBody StockDTO stockDTO) {
        return stockService.createStock(stockDTO);
    }

    @GetMapping("/article/{articleId}")
    public StockDTO getStock(@PathVariable Long articleId) {
        return stockService.getStockByArticleId(articleId);
    }

    @PutMapping("/article/{articleId}")
    public StockDTO updateStock(@PathVariable Long articleId, @RequestBody Integer quantity) {
        return stockService.updateStock(articleId, quantity);
    }

    @GetMapping("/all")
    public List<StockDTO> getAllStocks() {
        return stockService.getAllStocks();
    }
}