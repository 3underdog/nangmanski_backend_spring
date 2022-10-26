package com.dev.nangmanski_backend_spring.controller;

import com.dev.nangmanski_backend_spring.service.MainService;
import com.dev.nangmanski_backend_spring.service.ResortService;
import com.dev.nangmanski_backend_spring.vo.ResortVo;
import com.dev.nangmanski_backend_spring.vo.common.CommonApiResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class ResortController {
    @Autowired
    private MainService mainService;
    @Autowired
    private ResortService resortService;

    @RequestMapping("/resorts")
    public CommonApiResponseVo resortList() {
        long time = System.currentTimeMillis();
        CommonApiResponseVo r = new CommonApiResponseVo();
        log.info("getResortList, process time = {}sec, data = {}", (time * 0.001));
        List<ResortVo> resortList = resortService.getResortList();

        r.setResult(true);
        r.setData(resortList);
        r.setMessage("api response success");

        time = (System.currentTimeMillis() - time);
        return r;
    }

    @RequestMapping("/resortDetail")
    public CommonApiResponseVo resortDetail(String resortCode) {
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
