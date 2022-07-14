package com.berry.aptgetbuy.controller;

import com.berry.aptgetbuy.domain.entity.Complex;
import com.berry.aptgetbuy.mapper.ComplexMapper;
import com.berry.aptgetbuy.util.AddressUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("complex")
public class ComplexController {

    private final ComplexMapper complexMapper;

    @Autowired
    public ComplexController(ComplexMapper complexMapper) {
        this.complexMapper = complexMapper;
    }

    @GetMapping("where")
    public Complex where(
            @RequestParam(value = "addr_lv1") String state,
            @RequestParam(value = "addr_lv2") String city,
            @RequestParam(value = "addr_lv3") String town,
            @RequestParam(value = "bunji_main") String bunji_main,
            @RequestParam(value = "bunji_sub") String bunji_sub
    ) {
        List<Complex> complexes = complexMapper.findByAddr(state, city, town);
        String targetLegacyAddr = AddressUtil.assembleAddrPartsToLegacyAddr(state, city, town, bunji_main, bunji_sub);
        log.info("TARGET LEGACY ADDR: {}", targetLegacyAddr);
        for (Complex complex : complexes) {
            String findLegacyAddr = AddressUtil.changeComplexAddrToLegacyAddr(complex.getDanji_name(), complex.getAddr_legacy());
            if (targetLegacyAddr.equals(findLegacyAddr)) {
                return complex;
            }
        }
        return null;
    }

}
