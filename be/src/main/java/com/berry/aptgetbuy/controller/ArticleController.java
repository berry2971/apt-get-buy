package com.berry.aptgetbuy.controller;

import com.berry.aptgetbuy.domain.dto.ArticleRequestDto;
import com.berry.aptgetbuy.domain.dto.ArticleResponseDto;
import com.berry.aptgetbuy.domain.entity.Article;
import com.berry.aptgetbuy.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("articles")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ApiOperation(value = "게시글 목록 조회", notes = "특정 게시판의 게시글 목록 반환")
    @GetMapping("")
    public List<ArticleResponseDto> getArticles(
            @RequestParam String boardName,
            @RequestParam(required = false, defaultValue = "1") int page
    ) throws Exception {
        List<Article> articles = articleService.getArticlesByBoardName(boardName, page);
        List<ArticleResponseDto> articleResponseDtos = new ArrayList<>();
        for (Article article : articles) {
            articleResponseDtos.add(new ArticleResponseDto(article));
        }
        return articleResponseDtos;
    }

    @ApiOperation(value = "게시글 조회", notes = "id에 해당하는 게시글 반환")
    @GetMapping("/{id}")
    public ArticleResponseDto getArticle(
            @PathVariable Long id
    ) throws Exception {
        Article article = articleService.getArticle(id);
        return new ArticleResponseDto(article);
    }

    @ApiOperation(value = "게시글 작성", notes = "게시글 작성 후 게시글 반환")
    @PostMapping("")
    public ArticleResponseDto writeArticle(
            @RequestBody ArticleRequestDto articleRequestDto,
            HttpServletRequest request
    ) throws Exception {
        Article article = new Article(
                null,
                articleRequestDto.getBoard_name(),
                articleRequestDto.getSubject(),
                articleRequestDto.getTitle(),
                articleRequestDto.getAuthor(),
                null,
                articleRequestDto.getContent()
        );
        String loginId = (String)request.getAttribute("userId");
        article.setAuthor(loginId);
        return new ArticleResponseDto(articleService.createArticle(article));
    }

    @ApiOperation(value = "게시글 삭제", notes = "게시글 삭제 후 boolean 반환")
    @DeleteMapping("/{id}")
    public boolean removeArticle(
            @PathVariable Long id,
            HttpServletRequest request
    ) throws Exception {
        String loginId = (String)request.getAttribute("userId");
        return articleService.removeArticle(id, loginId);
    }

    @ApiOperation(value = "게시글 수정", notes = "게시글 수정 후 게시글 반환")
    @PutMapping("/{id}")
    public ArticleResponseDto modifyArticle(
            @PathVariable Long id,
            @RequestBody Article article,
            HttpServletRequest request
    ) throws Exception {
        String loginId = (String)request.getAttribute("userId");
        return new ArticleResponseDto(articleService.modifyArticle(id, article, loginId));
    }

}
