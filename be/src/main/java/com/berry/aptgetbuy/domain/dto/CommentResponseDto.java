package com.berry.aptgetbuy.domain.dto;

import com.berry.aptgetbuy.domain.entity.Comment;

public class CommentResponseDto {

    private Long id;
    private Long article_id;
    private String write_time;
    private String author;
    private String content;

    public CommentResponseDto() { }

    public CommentResponseDto(Long id, Long article_id, String write_time, String author, String content) {
        this.id = id;
        this.article_id = article_id;
        this.write_time = write_time;
        this.author = author;
        this.content = content;
    }

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.article_id = comment.getArticle_id();
        this.write_time = comment.getWrite_time().toString();
        this.author = comment.getAuthor();
        this.content = comment.getContent();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    public String getWrite_time() {
        return write_time;
    }

    public void setWrite_time(String write_time) {
        this.write_time = write_time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
