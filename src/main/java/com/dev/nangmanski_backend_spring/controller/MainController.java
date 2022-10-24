package com.dev.nangmanski_backend_spring.controller;

import com.dev.nangmanski_backend_spring.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
