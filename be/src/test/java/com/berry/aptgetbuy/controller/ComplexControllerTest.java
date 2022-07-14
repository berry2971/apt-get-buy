package com.berry.aptgetbuy.controller;

import com.berry.aptgetbuy.domain.entity.Complex;
import com.berry.aptgetbuy.mapper.ComplexMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class ComplexControllerTest {

    @Autowired ComplexController complexController;
    @Autowired ComplexMapper complexMapper;
    @Autowired MockMvc mockMvc;

    @Test
    void where() {
    }

    @Test
    void printComplexes() {
        List<Complex> complexes = complexMapper.findByAddr("대전광역시", "유성구", "관평동");
        System.out.println(complexes.size());
        for (int i = 0; i < complexes.size() && i < 10; i++) {
            System.out.println(complexes.get(i).getAddr_road());
        }
    }

    @Test
    void printComplexesWithBunji() throws Exception {
        mockMvc.perform(get("/complex/where")
                        .param("addr_lv1", "서울특별시")
                        .param("addr_lv2", "강남구")
                        .param("addr_lv3", "")
                        .param("addr_lv4", "도곡동")
                        .param("bunji_main", "963")
                        .param("bunji_sub", "0")
                )
                .andExpect(status().isOk())
                .andExpect(result -> {
                    // JSON json = JSON.result.getResponse().getContentAsString()
                });
    }

}
