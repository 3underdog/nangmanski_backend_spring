package com.dev.nangmanski_backend_spring.service;

import org.springframework.stereotype.Service;

@Service
public class MainService {
    public String getMessage(String msg) {

        return "return " + msg + "by mainService";
    }

}
