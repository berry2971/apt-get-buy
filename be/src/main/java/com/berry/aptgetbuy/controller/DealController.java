package com.berry.aptgetbuy.controller;

import com.berry.aptgetbuy.domain.entity.Deal;
import com.berry.aptgetbuy.service.DealService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("deals")
public class DealController {

    private final DealService dealService;

    @Autowired
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @ApiOperation(value = "모든 거래내역 조회", notes = "모든 거래내역 리스트를 반환")
    @GetMapping("")
    public List<Deal> index() throws Exception {
         log.info("parameters: none");
        return dealService.getAll();
    }

    @ApiOperation(value = "지번주소 거래 내역 조회", notes = "구주소에 해당하는 거래내역 리스트를 반환")
    @GetMapping("/where")
    public List<Deal> where(
            @RequestParam(value = "addr_lv1") String addr_lv1,
            @RequestParam(value = "addr_lv2") String addr_lv2,
            @RequestParam(value = "addr_lv3") String addr_lv3,
            @RequestParam(value = "bunji_main") String bunji_main,
            @RequestParam(value = "bunji_sub") String bunji_sub
    ) throws Exception {
         log.info("parameters: address {}, {}, {}, number {}, {}", addr_lv1, addr_lv2, addr_lv3, bunji_main, bunji_sub);
        return dealService.getDealsByLegacyAddress(addr_lv1, addr_lv2, addr_lv3, bunji_main, bunji_sub);
    }

}
