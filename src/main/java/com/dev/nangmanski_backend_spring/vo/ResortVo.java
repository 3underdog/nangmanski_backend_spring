package com.dev.nangmanski_backend_spring.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
@Builder
public class ResortVo {
    private String resortCode;
    private String resortName;
    private String address;
    private String addressDepth;
    private String addressDtlDepth;
    private String phoneNo;
    private String startTime;
    private String endTime;
    private String slopesImageUrl;
    private String slopesWebcamUrl;
    private char status;
    private char fetchStatus;
    private String openSlopeNameListStr;
    private List<ArrayList> slopeSummary;
    private List<SlopeVo> slopeList;
}
