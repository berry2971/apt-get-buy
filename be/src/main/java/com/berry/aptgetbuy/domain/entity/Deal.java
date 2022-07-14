package com.berry.aptgetbuy.domain.entity;

public class Deal {

    private Long id;
    private String addr_lv1;
    private String addr_lv2;
    private String addr_lv3;
    private String addr_lv4;
    private String bunji;
    private String bunji_main;
    private String bunji_sub;
    private String apt_name;
    private String square;
    private String deal_year_month;
    private String deal_day;
    private Long price;
    private Integer floor;
    private String built_year;
    private String addr_road;
    private String rel_data;
    private String deal_type;
    private String dealer_loc;

    public Deal() { }

    public Deal(Long id, String addr_lv1, String addr_lv2, String addr_lv3, String addr_lv4,
                String bunji, String bunji_main, String bunji_sub, String apt_name, String square,
                String deal_year_month, String deal_day, Long price, Integer floor, String built_year,
                String addr_road, String rel_data, String deal_type, String dealer_loc) {
        this.id = id;
        this.addr_lv1 = addr_lv1;
        this.addr_lv2 = addr_lv2;
        this.addr_lv3 = addr_lv3;
        this.addr_lv4 = addr_lv4;
        this.bunji = bunji;
        this.bunji_main = bunji_main;
        this.bunji_sub = bunji_sub;
        this.apt_name = apt_name;
        this.square = square;
        this.deal_year_month = deal_year_month;
        this.deal_day = deal_day;
        this.price = price;
        this.floor = floor;
        this.built_year = built_year;
        this.addr_road = addr_road;
        this.rel_data = rel_data;
        this.deal_type = deal_type;
        this.dealer_loc = dealer_loc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddr_lv1() {
        return addr_lv1;
    }

    public void setAddr_lv1(String addr_lv1) {
        this.addr_lv1 = addr_lv1;
    }

    public String getAddr_lv2() {
        return addr_lv2;
    }

    public void setAddr_lv2(String addr_lv2) {
        this.addr_lv2 = addr_lv2;
    }

    public String getAddr_lv3() {
        return addr_lv3;
    }

    public void setAddr_lv3(String addr_lv3) {
        this.addr_lv3 = addr_lv3;
    }

    public String getAddr_lv4() {
        return addr_lv4;
    }

    public void setAddr_lv4(String addr_lv4) {
        this.addr_lv4 = addr_lv4;
    }

    public String getBunji() {
        return bunji;
    }

    public void setBunji(String bunji) {
        this.bunji = bunji;
    }

    public String getBunji_main() {
        return bunji_main;
    }

    public void setBunji_main(String bunji_main) {
        this.bunji_main = bunji_main;
    }

    public String getBunji_sub() {
        return bunji_sub;
    }

    public void setBunji_sub(String bunji_sub) {
        this.bunji_sub = bunji_sub;
    }

    public String getApt_name() {
        return apt_name;
    }

    public void setApt_name(String apt_name) {
        this.apt_name = apt_name;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public String getDeal_year_month() {
        return deal_year_month;
    }

    public void setDeal_year_month(String deal_year_month) {
        this.deal_year_month = deal_year_month;
    }

    public String getDeal_day() {
        return deal_day;
    }

    public void setDeal_day(String deal_day) {
        this.deal_day = deal_day;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getBuilt_year() {
        return built_year;
    }

    public void setBuilt_year(String built_year) {
        this.built_year = built_year;
    }

    public String getAddr_road() {
        return addr_road;
    }

    public void setAddr_road(String addr_road) {
        this.addr_road = addr_road;
    }

    public String getRel_data() {
        return rel_data;
    }

    public void setRel_data(String rel_data) {
        this.rel_data = rel_data;
    }

    public String getDeal_type() {
        return deal_type;
    }

    public void setDeal_type(String deal_type) {
        this.deal_type = deal_type;
    }

    public String getDealer_loc() {
        return dealer_loc;
    }

    public void setDealer_loc(String dealer_loc) {
        this.dealer_loc = dealer_loc;
    }

}
