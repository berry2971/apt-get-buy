package com.berry.aptgetbuy.service;

import com.berry.aptgetbuy.domain.entity.Comment;
import com.berry.aptgetbuy.mapper.CommentMapper;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public Comment getComment(
            Long id
    ) throws Exception {
        return commentMapper.findById(id);
    }

    public List<Comment> getCommentsByArticleId(
            Long articleId,
            int page
    ) throws Exception {
        final int COMMENTS_PER_PAGE = 15;
        int offset = COMMENTS_PER_PAGE * (page - 1);
        return commentMapper.findByArticleIdAndOffsetAndLimit(articleId, offset, COMMENTS_PER_PAGE);
    }

    public Comment createComment(
            Comment comment
    ) throws Exception {
        commentMapper.save(comment);
        return commentMapper.findById(comment.getId());
    }

    public boolean removeComment(
            Long id
    ) throws Exception {
        Comment findComment = commentMapper.findById(id);
        if (findComment == null) {
            throw new NotFoundException("존재하지 않는 댓글입니다.");
        }
        commentMapper.remove(id);
        return true;
    }

}
