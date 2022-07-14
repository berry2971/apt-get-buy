package com.berry.aptgetbuy.mapper;

import com.berry.aptgetbuy.domain.entity.Deal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class DealMapperTest {

    @Autowired
    DealMapper dealMapper;

    @Test
    void findAll() throws Exception {
        List<Deal> deals = dealMapper.findAll();
        assertThat(deals.size()).isGreaterThan(1000);
        for (Deal deal : deals) {
            assertThat(deal.getAddr_lv1()).isNotBlank();
            assertThat(deal.getPrice()).isNotNull();
        }
    }

    @Test
    void saveAndFind() throws Exception {
        Deal deal1 = new Deal(0L, "테스트lv1-1", "테스트lv2-1", "테스트lv3-1", "테스트lv4-1",
                "150-3", "150", "3", "테스트아파트1", "123.456",
                "205001", "15", 12345L, 100, "1234",
                "테스트도로명주소1", null, "-", null);
        Deal deal2 = new Deal(0L, "테스트lv1-2", "테스트lv2-2", "테스트lv3-2", "테스트lv4-2",
                "73", "73", "0", "테스트아파트2", "38.6",
                "199110", "1", 12345L, 1, "1234",
                "테스트도로명주소2", null, "-", null);

        dealMapper.save(deal1);
        dealMapper.save(deal2);

        Deal findDeal1 = dealMapper.findById(deal1.getId());
        System.out.println("ID:");System.out.println(deal1.getId());
        assertThat(findDeal1.getAddr_road()).isEqualTo(deal1.getAddr_road());

        Deal findDeal2 = dealMapper.findById(deal2.getId());
        assertThat(findDeal2.getPrice()).isEqualTo(deal2.getPrice());
    }

}
