package com.esprit.articleservice.mapper;

import com.esprit.articleservice.dto.ArticleDTO;
import com.esprit.articleservice.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stockId", target = "stockId")
    Article toEntity(ArticleDTO articleDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stockId", target = "stockId")
    ArticleDTO toDTO(Article article);
}