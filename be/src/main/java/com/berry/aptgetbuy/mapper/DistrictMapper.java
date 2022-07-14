package com.berry.aptgetbuy.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DistrictMapper {

    List<String> findLv2(String lv1);

    List<String> findLv3(String lv1, String lv2);

}
