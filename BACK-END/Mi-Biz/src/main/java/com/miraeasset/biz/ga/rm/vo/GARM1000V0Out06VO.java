package com.miraeasset.biz.ga.rm.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GARM1000V0Out06VO {
	
	@ApiModelProperty(notes = "연간렌탈료조회")
    List<GARM1000V0Out02VO> gridList;
    
    @ApiModelProperty(notes = "연간렌탈료요약정보")
    List<GARM1000V0Out03VO> smarList;

	public List<GARM1000V0Out02VO> getGridList() {
		return gridList;
	}

	public void setGridList(List<GARM1000V0Out02VO> gridList) {
		this.gridList = gridList;
	}

	public List<GARM1000V0Out03VO> getSmarList() {
		return smarList;
	}

	public void setSmarList(List<GARM1000V0Out03VO> smarList) {
		this.smarList = smarList;
	}

	@Override
	public String toString() {
		return "GARM1000V0Out06VO [gridList=" + gridList + ", smarList=" + smarList + "]";
	}
	
}
