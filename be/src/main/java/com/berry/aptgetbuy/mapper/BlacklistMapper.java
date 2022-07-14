package com.berry.aptgetbuy.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlacklistMapper {

    List<String> findById(String id);

    void add(String id);

    void remove(String id);

}
