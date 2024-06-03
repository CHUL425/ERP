package com.miraeasset.biz.in.in.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ININ2000V0VO {
	
	@ApiModelProperty(notes = "분기별 계정과목 집행율")
    List<ININ2000V0Out01VO> grid;
    
    @ApiModelProperty(notes = "합계예산 집행율")
    List<ININ2000V0Out01VO> total;

	public List<ININ2000V0Out01VO> getGrid() {
		return grid;
	}

	public void setGrid(List<ININ2000V0Out01VO> grid) {
		this.grid = grid;
	}

	public List<ININ2000V0Out01VO> getTotal() {
		return total;
	}

	public void setTotal(List<ININ2000V0Out01VO> total) {
		this.total = total;
	}
    
}