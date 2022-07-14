package com.berry.aptgetbuy.domain.dto;

public class DealSummaryDto {

    private int count;
    private Long minPrice;
    private Long maxPrice;

    public DealSummaryDto() { }

    public DealSummaryDto(int count, Long minPrice, Long maxPrice) {
        this.count = count;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

}
