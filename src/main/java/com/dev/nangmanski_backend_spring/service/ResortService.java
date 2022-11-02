package com.dev.nangmanski_backend_spring.service;

import com.dev.nangmanski_backend_spring.mapper.ResortMapper;
import com.dev.nangmanski_backend_spring.vo.ResortVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResortService {
    @Autowired
    private ResortMapper resortMapper;

    public String getMessage(String msg) {

        return "return " + msg + "by mainService";
    }

    public Map<String, List<ResortVo>> getResortList() {
        List<ResortVo> resortList = resortMapper.getResortList();
        Map<String, List<ResortVo>> resortAreaMap = new HashMap<>();

        for(ResortVo resort: resortList) {
            resortAreaMap.computeIfAbsent(resort.getAddressDepth(), k -> new ArrayList<>()).add(resort);
        }

        return resortAreaMap;
    }

    public Map<String, List<ResortVo>> getResortListOnly() {
        List<ResortVo> resortList = resortMapper.getResortListOnly();
        Map<String, List<ResortVo>> resortAreaMap = new HashMap<>();

        for(ResortVo resort: resortList) {
            resortAreaMap.computeIfAbsent(resort.getAddressDepth(), k -> new ArrayList<>()).add(resort);
        }

        return resortAreaMap;
    }


    public ResortVo getResortDetail(String resortCode) {
        ResortVo resort = resortMapper.getResortDetail(resortCode);
        return resort;
    }

}
