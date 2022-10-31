package com.dev.nangmanski_backend_spring.controller;

import com.dev.nangmanski_backend_spring.service.MainService;
import com.dev.nangmanski_backend_spring.service.ResortService;
import com.dev.nangmanski_backend_spring.vo.ResortVo;
import com.dev.nangmanski_backend_spring.vo.common.CommonApiResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/resorts")
@CrossOrigin(origins = "*")
public class ResortController {
    @Autowired
    private ResortService resortService;

    @GetMapping("")
    public CommonApiResponseVo resortList() {
        long time = System.currentTimeMillis();
        CommonApiResponseVo r = new CommonApiResponseVo();
        log.info("getResortList, process time = {}sec, data = {}", (time * 0.001));
        Map<String, List<ResortVo>> resortAreaMap = resortService.getResortList();

        r.setResult(true);
        r.setData(resortAreaMap);
        r.setMessage("api response success");

        time = (System.currentTimeMillis() - time);
        return r;
    }

    @GetMapping("/{resortCode}")
    public CommonApiResponseVo resortDetail(@PathVariable String resortCode) {
//        resortCode = "R0001";
//        Map<String, String> param = new HashMap<>();
//        param.put("resortCode", resortCode);

        CommonApiResponseVo r = new CommonApiResponseVo();
        long time = System.currentTimeMillis();
        log.info("getResortDetail, process time = {}sec, data = {}", (time * 0.001));
        ResortVo resort = resortService.getResortDetail(resortCode);
        r.setResult(true);
        r.setData(resort);
        r.setMessage("api response success");

        time = (System.currentTimeMillis() - time);
        return r;
    }
}
