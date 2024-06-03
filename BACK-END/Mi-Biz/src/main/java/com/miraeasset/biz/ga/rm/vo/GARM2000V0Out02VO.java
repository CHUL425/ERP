package com.miraeasset.biz.ga.rm.vo;


import java.util.List;

import org.springframework.stereotype.Component;


import io.swagger.annotations.ApiModelProperty;

@Component
public class GARM2000V0Out02VO {
	
	@ApiModelProperty(notes = "렌탈관리(복합기)조회")
	List<GARM2000V0Out00VO> gridList;

	@ApiModelProperty(notes = "렌탈관리요약정보(복합기)조회")
	List<GARM2000V0Out01VO> smarList;

	public List<GARM2000V0Out00VO> getGridList() {
		return gridList;
	}

	public void setGridList(List<GARM2000V0Out00VO> gridList) {
		this.gridList = gridList;
	}

	public List<GARM2000V0Out01VO> getSmarList() {
		return smarList;
	}

	public void setSmarList(List<GARM2000V0Out01VO> smarList) {
		this.smarList = smarList;
	}

	@Override
	public String toString() {
		return "GARM2000V0Out02VO [gridList=" + gridList + ", smarList=" + smarList + "]";
	}
}
