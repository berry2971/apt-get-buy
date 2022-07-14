package com.berry.aptgetbuy.mapper;

import com.berry.aptgetbuy.domain.entity.Complex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComplexMapper {

    List<Complex> findByAddr(String state, String city, String town);

}
