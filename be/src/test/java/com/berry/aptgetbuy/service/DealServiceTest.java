package com.berry.aptgetbuy.service;

import com.berry.aptgetbuy.domain.dto.DealSummaryDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class DealServiceTest {

    @Autowired
    DealService dealService;

    @Test
    void getAll() {
    }

    @Test
    void getDealsByLegacyAddress() {
    }

    @Test
    void getDealSummaryByLegacyAddress() throws Exception {
        DealSummaryDto dealSummaryDto1 = dealService.getDealSummaryByLegacyAddress("서울특별시", "강남구", "역삼동", "762", "3");
        Assertions.assertThat(dealSummaryDto1.getMinPrice()).isEqualTo(170000);
        Assertions.assertThat(dealSummaryDto1.getMaxPrice()).isEqualTo(270000);
        Assertions.assertThat(dealSummaryDto1.getCount()).isEqualTo(5);

        DealSummaryDto dealSummaryDto2 = dealService.getDealSummaryByLegacyAddress("경상남도", "창원성산구", "가음동", "16", "0");
        Assertions.assertThat(dealSummaryDto2.getMinPrice()).isEqualTo(35500);
        Assertions.assertThat(dealSummaryDto2.getMaxPrice()).isEqualTo(74500);
        Assertions.assertThat(dealSummaryDto2.getCount()).isEqualTo(24);
    }

}
