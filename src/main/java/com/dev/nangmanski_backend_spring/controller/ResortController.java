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
        long   time              = System.currentTimeMillis();
        CommonApiResponseVo r = new CommonApiResponseVo();
        log.info("Magic-Pin, process time = {}sec, data = {}", (time * 0.001));
        List<ResortVo> resortList = resortService.getResortList();

        r.setCode("success");
        r.setData(resortList);
        r.setMessage("api response success");

        time = (System.currentTimeMillis() - time);
        return r;
    }
}
