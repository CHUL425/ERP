package com.miraeasset.biz.ga.vm.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAVM1000U0VO {
	
	@ApiModelProperty(notes = "차량임자관리 조회")
	List<GAVM1000U0Out00VO> gridList;
	
	@ApiModelProperty(notes = "차량임자관리 합계조회")
	List<GAVM1000U0Out01VO> totalList;

	public List<GAVM1000U0Out00VO> getGridList() {
		return gridList;
	}

	public void setGridList(List<GAVM1000U0Out00VO> gridList) {
		this.gridList = gridList;
	}

	public List<GAVM1000U0Out01VO> getTotalList() {
		return totalList;
	}

	public void setTotalList(List<GAVM1000U0Out01VO> totalList) {
		this.totalList = totalList;
	}

	@Override
	public String toString() {
		return "GAVM1000U0VO [gridList=" + gridList + ", totalList=" + totalList + "]";
	}
	
}