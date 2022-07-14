package com.berry.aptgetbuy.domain.dto;

public class UserFindPasswordDto {

    private String id;
    private String name;
    private String tel;
    private String newPw;

    UserFindPasswordDto() { }

    public UserFindPasswordDto(String id, String name, String tel, String newPw) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.newPw = newPw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNewPw() {
        return newPw;
    }

    public void setNewPw(String newPw) {
        this.newPw = newPw;
    }

}
