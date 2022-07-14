package com.berry.aptgetbuy.mapper;

import com.berry.aptgetbuy.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    Article findById(Long id) throws Exception;

    List<Article> findByBoardNameAndOffsetAndLimit(String boardName, int offset, int articlesPerPage);

    void save(Article article) throws Exception;

    void modify(Article article) throws Exception;

    void remove(Long id) throws Exception;

}
