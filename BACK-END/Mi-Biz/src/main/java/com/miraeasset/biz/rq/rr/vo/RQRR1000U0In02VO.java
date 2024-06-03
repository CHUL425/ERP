package com.miraeasset.biz.rq.rr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQRR1000U0In02VO {

    @ApiModelProperty(notes= "완료대상 렌탈신청목록")
    List<RQRR1000U0In05VO> grid5;    // 완료대상 렌탈신청목록

	public List<RQRR1000U0In05VO> getGrid5() {
		return grid5;
	}

	public void setGrid5(List<RQRR1000U0In05VO> grid5) {
		this.grid5 = grid5;
	}

    
}
