package com.berry.aptgetbuy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@Slf4j
@Service
public class NewsService {

    private String NAVER_NEWS_API = "https://openapi.naver.com/v1/search/news.json";

    private ObjectMapper objectMapper;

    @Autowired
    public NewsService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getNewsWithKeyword(String keyword, int page, int itemPerPage) throws JsonProcessingException, UnsupportedEncodingException {
        keyword = URLEncoder.encode(keyword, "UTF-8");

        HttpURLConnection conn;
        String result;

        try {
            StringBuilder urlString = new StringBuilder(NAVER_NEWS_API);
            urlString.append("?");
            urlString.append("query").append("=").append(keyword);
            urlString.append("&").append("start").append(1 + (page - 1) * itemPerPage);
            urlString.append("&").append("display").append(itemPerPage);
            URL url = new URL(urlString.toString());

            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("X-Naver-Client-Id", "8Da5nkdf0NCRskU8_83j");
            conn.setRequestProperty("X-Naver-Client-Secret", "co27XaQD6d");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                result = inputStreamToString(conn.getInputStream());
            } else {
                result = inputStreamToString(conn.getErrorStream());
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    private String inputStreamToString(InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
