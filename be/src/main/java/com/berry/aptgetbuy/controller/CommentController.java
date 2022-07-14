package com.berry.aptgetbuy.controller;

import com.berry.aptgetbuy.service.CommentService;
import com.berry.aptgetbuy.domain.dto.CommentRequestDto;
import com.berry.aptgetbuy.domain.dto.CommentResponseDto;
import com.berry.aptgetbuy.domain.entity.Comment;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "댓글 목록 조회", notes = "특정 게시글의 댓글 목록 반환")
    @GetMapping("")
    public List<CommentResponseDto> getComment(
            @RequestParam Long articleId,
            @RequestParam(required = false, defaultValue = "1") int page
    ) throws Exception {
        List<Comment> comments = commentService.getCommentsByArticleId(articleId, page);
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for (Comment comment : comments) {
            commentResponseDtos.add(new CommentResponseDto(comment));
        }
        return commentResponseDtos;
    }

    @ApiOperation(value = "댓글 조회", notes = "id에 해당하는 댓글 반환")
    @GetMapping("/{id}")
    public CommentResponseDto getComment(
            @PathVariable Long id
    ) throws Exception {
        return new CommentResponseDto(commentService.getComment(id));
    }

    @ApiOperation(value = "댓글 작성", notes = "댓글 작성 후 댓글 반환")
    @PostMapping("")
    public CommentResponseDto writeComment(
            @RequestBody CommentRequestDto commentRequestDto,
            HttpServletRequest request
    ) throws Exception {
        String loginId = (String)request.getAttribute("userId");
        Comment comment = new Comment(
                null,
                commentRequestDto.getArticle_id(),
                null,
                commentRequestDto.getAuthor(),
                commentRequestDto.getContent()
        );
        comment.setAuthor(loginId);
        return new CommentResponseDto(commentService.createComment(comment));
    }

    @ApiOperation(value = "댓글 삭제", notes = "댓글 삭제 후 boolean 반환")
    @DeleteMapping("/{id}")
    public boolean removeArticle(
            @PathVariable Long id
    ) throws Exception {
        return commentService.removeComment(id);
    }

}
