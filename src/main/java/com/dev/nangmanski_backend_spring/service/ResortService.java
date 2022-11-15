package com.dev.nangmanski_backend_spring.service;

import com.dev.nangmanski_backend_spring.mapper.ResortMapper;
import com.dev.nangmanski_backend_spring.vo.ResortVo;
import com.dev.nangmanski_backend_spring.vo.SlopeTimeVo;
import com.dev.nangmanski_backend_spring.vo.SlopeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResortService {
    @Autowired
    private ResortMapper resortMapper;

    public Map<String, List<ResortVo>> getResortList() {
        List<ResortVo> resortList = resortMapper.getResortList();
        List<SlopeTimeVo> slopeTimeList = resortMapper.getSlopeTimeList();

        Map<String, List<ResortVo>> resortAreaMap = new HashMap<>();
        Map<String, HashMap<String, HashMap<String, Character>>> resortMap = new LinkedHashMap<>();

        for(SlopeTimeVo slopeTime: slopeTimeList) {
            String timeResortCode = slopeTime.getResortCode();
            String timeSlopeCode = slopeTime.getSlopeCode();

            if(!resortMap.containsKey(timeResortCode)) {
                resortMap.put(timeResortCode, new LinkedHashMap<>());
            }
            if(!resortMap.get(timeResortCode).containsKey(timeSlopeCode)) {
                resortMap.get(timeResortCode).put(timeSlopeCode, new LinkedHashMap<>());
            }

            resortMap.get(timeResortCode).get(timeSlopeCode).put(slopeTime.getSlopeTimeName(), slopeTime.getOpenYn());
        }

        // TODO
        // HOW TO GET LIST OF CURRENT SLOPE STATUS
        // DB OR SERVICE LOGIC


        for(ResortVo resort: resortList) {
            String resortCode = resort.getResortCode();
            resort.setSlopeSummary(new ArrayList<>());

            Map<String, String> slopeMappingMap = new HashMap<>();
            List<String> slopeCodeList = new ArrayList<>();
            List<String> timeNameList = new ArrayList<>();

            List<String> slopeSummaryHeader = new ArrayList<>();

            boolean isFirstResortLoop = true;
            for(SlopeVo slope: resort.getSlopeList()) {
                String slopeCode = slope.getSlopeCode();
                if(isFirstResortLoop) {
                    slopeCodeList = new ArrayList(resortMap.get(resortCode).keySet());
                    timeNameList = new ArrayList(resortMap.get(resortCode).get(slopeCode).keySet());
                    isFirstResortLoop = false;
                }
                slopeMappingMap.put(slopeCode, slope.getSlopeName());
            }

            isFirstResortLoop = true;
            slopeSummaryHeader.add("운영시간/슬로프");
            for(String timeName: timeNameList) {
                List timeList = new ArrayList<>();
                timeList.add(timeName);
                for(String slopeCode: slopeCodeList) {
                    if(isFirstResortLoop) {
                        slopeSummaryHeader.add(slopeMappingMap.get(slopeCode));
                    }
                    timeList.add(resortMap.get(resortCode).get(slopeCode).get(timeName));
                }
                isFirstResortLoop = false;
                resort.getSlopeSummary().add(timeList);
            }
            resort.getSlopeSummary().add(0, slopeSummaryHeader);
        }

        for(ResortVo resort: resortList) {
            resortAreaMap.computeIfAbsent(resort.getAddressDepth(), k -> new ArrayList<>()).add(resort);
        }
        return resortAreaMap;
    }

    public Map<String, List<ResortVo>> getResortListTest() {
        List<ResortVo> resortList = resortMapper.getResortList();
        List<SlopeTimeVo> slopeTimeList = resortMapper.getSlopeTimeList();

        Map<String, List<ResortVo>> resortAreaMap = new HashMap<>();
        for(ResortVo resort: resortList) {
            resortAreaMap.computeIfAbsent(resort.getAddressDepth(), k -> new ArrayList<>()).add(resort);
        }
        return resortAreaMap;
    }

    public Map<String, List<ResortVo>> getResortListTestWith3Depth() {
        List<ResortVo> resortList = resortMapper.getResortList();
        List<SlopeTimeVo> slopeTimeList = resortMapper.getSlopeTimeList();

        Map<String, List<ResortVo>> resortAreaMap = new HashMap<>();

        Map<String, Map<String, Map<String, Character>>> resortMap = new HashMap<>();


        for(SlopeTimeVo slopeTime: slopeTimeList) {
            String timeResortCode = slopeTime.getResortCode();
            String timeSlopeCode = slopeTime.getSlopeCode();

            if(!resortMap.containsKey(timeResortCode)) {
                resortMap.put(timeResortCode, new HashMap<>());
            }

            if(!resortMap.get(timeResortCode).containsKey(timeSlopeCode)) {
                resortMap.get(timeResortCode).put(timeSlopeCode, new HashMap<>());
            }

            resortMap.get(timeResortCode).get(timeSlopeCode).put(slopeTime.getSlopeTimeName(), slopeTime.getOpenYn());
        }

        List<String> slopeSummaryInner = new ArrayList<>();
        Map<String, String> compareMap = new HashMap<>();

        for(ResortVo resort: resortList) {
            String resortCode = resort.getResortCode();
            slopeSummaryInner.clear();
            slopeSummaryInner.add("운영시간/슬로프");

            boolean isFirstIdx = true;
            for(SlopeVo slope: resort.getSlopeList()) {
                String slopeCode = slope.getSlopeCode();
                if(isFirstIdx) {
                    List timeNameList = new ArrayList<String>(resortMap.get(resortCode).get(slopeCode).keySet());
                    isFirstIdx = false;
                }


            }
        }

        for(ResortVo resort: resortList) {
            resortAreaMap.computeIfAbsent(resort.getAddressDepth(), k -> new ArrayList<>()).add(resort);
        }
        return resortAreaMap;
    }

    /* No use
    public Map<String, List<ResortVo>> getResortListCollections() {
        List<ResortVo> resortList = resortMapper.getResortListCollections();
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
     */
}
