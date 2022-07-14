package com.berry.aptgetbuy.domain.dto;

public class CommentRequestDto {

    private Long article_id;
    private String author;
    private String content;

    public CommentRequestDto() { }

    public CommentRequestDto(Long article_id, String author, String content) {
        this.article_id = article_id;
        this.author = author;
        this.content = content;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
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
