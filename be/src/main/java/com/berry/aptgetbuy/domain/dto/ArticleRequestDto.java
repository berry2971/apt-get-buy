package com.berry.aptgetbuy.domain.dto;

public class ArticleRequestDto {

    private String board_name;
    private String subject;
    private String title;
    private String author;
    private String content;

    public ArticleRequestDto() { }

    public ArticleRequestDto(String board_name, String subject, String title, String author, String content) {
        this.board_name = board_name;
        this.subject = subject;
        this.title = title;
        this.author = author;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
