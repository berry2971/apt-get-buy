package com.berry.aptgetbuy.mapper;

import com.berry.aptgetbuy.domain.dto.DealSummaryDto;
import com.berry.aptgetbuy.domain.entity.Deal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DealMapper {

    List<Deal> findAll() throws Exception;

    List<Deal> findByLegacyAddress(String addr_lv1, String addr_lv2, String addr_lv3, String bunji)  throws Exception;

    Deal findById(Long id) throws Exception;

    void save(Deal deal) throws Exception;

    DealSummaryDto findDealSummaryByLegacyAddress(String addr_lv1, String addr_lv2, String addr_lv3, String bunji) throws Exception;

}
