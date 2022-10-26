package com.dev.nangmanski_backend_spring.controller;

import com.dev.nangmanski_backend_spring.service.MainService;
import com.dev.nangmanski_backend_spring.service.ResortService;
import com.dev.nangmanski_backend_spring.vo.MainVo;
import com.dev.nangmanski_backend_spring.vo.ResortListVo;
import com.dev.nangmanski_backend_spring.vo.ResortVo;
import com.dev.nangmanski_backend_spring.vo.common.CommonApiResponseVo;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@CrossOrigin(origins = "*")
public class MainController {
    @Autowired
    private MainService mainService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        String massage = "test message";
        String msg = mainService.getMessage(massage);
        System.out.println(msg);

        mv.setViewName("index");
        mv.addObject("message", massage);
        return mv;
    }
}
