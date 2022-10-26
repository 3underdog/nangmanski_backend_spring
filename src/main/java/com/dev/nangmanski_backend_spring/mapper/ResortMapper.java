package com.dev.nangmanski_backend_spring.mapper;

import com.dev.nangmanski_backend_spring.vo.ResortVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ResortMapper {
    List<ResortVo> getResortList();

    ResortVo getResortDetail(String resortCode);
}
