package com.esprit.stockservice.service;

import com.esprit.stockservice.dto.StockDTO;
import com.esprit.stockservice.model.Stock;
import com.esprit.stockservice.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockDTO createStock(StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setArticleId(stockDTO.getArticleId());
        stock.setQuantity(stockDTO.getQuantity());
        return toDTO(stockRepository.save(stock));
    }

    public StockDTO updateStock(Long articleId, Integer quantity) {
        Stock stock = stockRepository.findByArticleId(articleId);
        if (stock == null) {
            stock = new Stock();
            stock.setArticleId(articleId);
        }
        stock.setQuantity(quantity);
        return toDTO(stockRepository.save(stock));
    }

    public StockDTO getStockByArticleId(Long articleId) {
        return Optional.ofNullable(stockRepository.findByArticleId(articleId))
                .map(this::toDTO)
                .orElseThrow();
    }

    private StockDTO toDTO(Stock stock) {
        return new StockDTO(stock.getId(), stock.getArticleId(), stock.getQuantity());
    }

    public List<StockDTO> getAllStocks() {
        return stockRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}