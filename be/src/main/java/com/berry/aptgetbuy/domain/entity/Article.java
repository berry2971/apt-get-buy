package com.berry.aptgetbuy.domain.entity;

import java.time.LocalDateTime;

public class Article {

    private Long id;
    private String board_name;
    private String subject;
    private String title;
    private String author;
    private LocalDateTime write_time;
    private String content;

    public Article() { }

    public Article(Long id, String board_name, String subject, String title, String author, LocalDateTime write_time, String content) {
        this.id = id;
        this.board_name = board_name;
        this.subject = subject;
        this.title = title;
        this.author = author;
        this.write_time = write_time;
        this.content = content;
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

    public LocalDateTime getWrite_time() {
        return write_time;
    }

    public void setWrite_time(LocalDateTime write_time) {
        this.write_time = write_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
