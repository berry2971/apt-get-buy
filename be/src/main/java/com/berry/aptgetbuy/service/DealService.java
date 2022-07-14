package com.berry.aptgetbuy.service;

import com.berry.aptgetbuy.domain.dto.DealSummaryDto;
import com.berry.aptgetbuy.domain.entity.Deal;
import com.berry.aptgetbuy.mapper.DealMapper;
import com.berry.aptgetbuy.util.AddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DealService {

    private final DealMapper dealMapper;

    @Autowired
    public DealService(DealMapper dealMapper) {
        this.dealMapper = dealMapper;
    }

    public List<Deal> getAll() throws Exception {
        return dealMapper.findAll();
    }

    public List<Deal> getDealsByLegacyAddress(
            String addr_lv1,
            String addr_lv2,
            String addr_lv3,
            String bunji_main,
            String bunji_sub
    ) throws Exception {
        String bunji = AddressUtil.assembleBunjiMainAndBunjiSub(bunji_main, bunji_sub);
        return dealMapper.findByLegacyAddress(addr_lv1, addr_lv2, addr_lv3, bunji);
    }

    public DealSummaryDto getDealSummaryByLegacyAddress(
            String addr_lv1,
            String addr_lv2,
            String addr_lv3,
            String bunji_main,
            String bunji_sub
    ) throws Exception {
        String bunji = AddressUtil.assembleBunjiMainAndBunjiSub(bunji_main, bunji_sub);
        return dealMapper.findDealSummaryByLegacyAddress(addr_lv1, addr_lv2, addr_lv3, bunji);
    }

}
