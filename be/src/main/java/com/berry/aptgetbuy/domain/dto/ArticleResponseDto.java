package com.berry.aptgetbuy.domain.dto;

import com.berry.aptgetbuy.domain.entity.Article;

public class ArticleResponseDto {

    private Long id;
    private String board_name;
    private String subject;
    private String title;
    private String author;
    private String write_time;
    private String content;

    public ArticleResponseDto() { }

    public ArticleResponseDto(Long id, String board_name, String subject, String title, String author, String write_time, String content) {
        this.id = id;
        this.board_name = board_name;
        this.subject = subject;
        this.title = title;
        this.author = author;
        this.write_time = write_time;
        this.content = content;
    }

    public ArticleResponseDto(Article article) {
        this.id = article.getId();
        this.board_name = article.getBoard_name();
        this.subject = article.getSubject();
        this.title = article.getTitle();
        this.author = article.getAuthor();
        this.write_time = article.getWrite_time().toString();
        this.content = article.getContent();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoard_name() {
        return board_name;
    }

    public void setBoard_name(String board_name) {
        this.board_name = board_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWrite_time() {
        return write_time;
    }

    public void setWrite_time(String write_time) {
        this.write_time = write_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
