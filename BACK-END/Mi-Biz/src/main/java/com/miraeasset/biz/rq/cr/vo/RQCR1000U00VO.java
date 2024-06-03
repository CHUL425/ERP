package com.miraeasset.biz.rq.cr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQCR1000U00VO {
	
	@ApiModelProperty(notes = "공사신청목록조회")
	List<RQCR1000U0Out00VO> gridList;
	
	@ApiModelProperty(notes = "공사신청상태정보조회")
	List<RQCR1000U0Out01VO> rqsStat;

	public List<RQCR1000U0Out00VO> getGridList() {
		return gridList;
	}

	public void setGridList(List<RQCR1000U0Out00VO> gridList) {
		this.gridList = gridList;
	}

	public List<RQCR1000U0Out01VO> getRqsStat() {
		return rqsStat;
	}

	public void setRqsStat(List<RQCR1000U0Out01VO> rqsStat) {
		this.rqsStat = rqsStat;
	}

	@Override
	public String toString() {
		return "RQCR1000U01VO [gridList=" + gridList + ", rqsStat=" + rqsStat + "]";
	}
}
