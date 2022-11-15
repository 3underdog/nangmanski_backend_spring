package com.dev.nangmanski_backend_spring.controller;

import com.dev.nangmanski_backend_spring.vo.common.CommonApiResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class MainController {

    @GetMapping("")
    public CommonApiResponseVo HealthCheck() {
        long time = System.currentTimeMillis();
        CommonApiResponseVo r = new CommonApiResponseVo();
        log.info("getResortList, process time = {}sec, data = {}", (time * 0.001));
        r.setMessage("api response success");

        System.out.println(time);
        return r;
    }
}
