package com.berry.aptgetbuy.controller;

import com.berry.aptgetbuy.mapper.DistrictMapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("districts")
public class DistrictController {

    private final DistrictMapper districtMapper;

    @Autowired
    public DistrictController(DistrictMapper districtMapper) {
        this.districtMapper = districtMapper;
    }

    @ApiOperation(value = "행정구역 조회", notes = "상위 행정구역의 하위 행정구역 반환")
    @GetMapping("")
    public List<String> getDistrictsWithPreviousLevels(
            @RequestParam String addr_lv1,
            @RequestParam(required = false, defaultValue = "") String addr_lv2
    ) {
        if (addr_lv2.equals("")) {
            return districtMapper.findLv2(addr_lv1);
        } else {
            return districtMapper.findLv3(addr_lv1, addr_lv2);
        }
    }

}
