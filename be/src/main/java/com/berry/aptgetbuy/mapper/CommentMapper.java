package com.berry.aptgetbuy.mapper;

import com.berry.aptgetbuy.domain.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    Comment findById(Long id) throws Exception;

    List<Comment> findByArticleIdAndOffsetAndLimit(Long articleId, int offset, int commentsPerPage) throws Exception;

    void remove(Long id) throws Exception;

    void save(Comment comment) throws Exception;

}
