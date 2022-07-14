package com.berry.aptgetbuy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
class NewsServiceTest {

    @Autowired NewsService newsService;

    @Test
    void getNewsWithKeyword() throws UnsupportedEncodingException, JsonProcessingException {
        String res = newsService.getNewsWithKeyword("얼룩말", 1, 15);
        System.out.println(res);
    }

}