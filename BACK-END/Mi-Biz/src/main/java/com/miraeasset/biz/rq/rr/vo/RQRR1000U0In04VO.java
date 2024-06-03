package com.miraeasset.biz.rq.rr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQRR1000U0In04VO {

    @ApiModelProperty(notes= "삭제대상 렌탈신청목록")
    List<RQRR1000U0In03VO> grid;    // 삭제대상 렌탈신청목록

	public List<RQRR1000U0In03VO> getGrid() {
		return grid;
	}

	public void setGrid(List<RQRR1000U0In03VO> grid) {
		this.grid = grid;
	}
    
	
}
