package com.esprit.stockservice.mapper;

import com.esprit.sharedlibrary.dto.StockDTO;
import com.esprit.stockservice.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockMapper {

    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "articleId", target = "articleId")
    @Mapping(source = "quantity", target = "quantity")
    StockDTO toDTO(Stock stock);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "articleId", target = "articleId")
    @Mapping(source = "quantity", target = "quantity")
    Stock toEntity(StockDTO stockDTO);
}