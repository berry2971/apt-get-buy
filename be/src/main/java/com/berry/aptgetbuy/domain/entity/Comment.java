package com.berry.aptgetbuy.domain.entity;

import java.time.LocalDateTime;

public class Comment {

    private Long id;
    private Long article_id;
    private LocalDateTime write_time;
    private String author;
    private String content;

    public Comment() { }

    public Comment(Long id, Long article_id, LocalDateTime write_time, String author, String content) {
        this.id = id;
        this.article_id = article_id;
        this.write_time = write_time;
        this.author = author;
        this.content = content;
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

    public LocalDateTime getWrite_time() {
        return write_time;
    }

    public void setWrite_time(LocalDateTime write_time) {
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
