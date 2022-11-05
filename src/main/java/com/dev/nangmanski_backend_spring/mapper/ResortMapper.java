package com.dev.nangmanski_backend_spring.mapper;

import com.dev.nangmanski_backend_spring.vo.ResortVo;
import com.dev.nangmanski_backend_spring.vo.SlopeTimeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ResortMapper {
    List<ResortVo> getResortList();


    List<SlopeTimeVo> getSlopeTimeList();

//    List<ResortVo> getResortListCollections();
//
//    List<ResortVo> getResortListOnly();
//
//    ResortVo getResortDetail(String resortCode);
}
