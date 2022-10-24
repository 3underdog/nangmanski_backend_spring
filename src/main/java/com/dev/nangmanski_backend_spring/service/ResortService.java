package com.dev.nangmanski_backend_spring.service;

import com.dev.nangmanski_backend_spring.mapper.ResortMapper;
import com.dev.nangmanski_backend_spring.vo.ResortListVo;
import com.dev.nangmanski_backend_spring.vo.ResortVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResortService {
    @Autowired
    private ResortMapper resortMapper;

    public String getMessage(String msg) {

        return "return " + msg + "by mainService";
    }

    public List<ResortVo> getResortList() {
        return resortMapper.getResortList();
    }

}
