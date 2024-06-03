package com.miraeasset.biz.ga.rm.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GARM1000V0Out05VO {
	
	@ApiModelProperty(notes = "렌탈관리내역조회")
    List<GARM1000V0Out00VO> gridList;
    
    @ApiModelProperty(notes = "렌탈관리요약정보")
    List<GARM1000V0Out01VO> smarList;

	public List<GARM1000V0Out00VO> getGridList() {
		return gridList;
	}

	public void setGridList(List<GARM1000V0Out00VO> gridList) {
		this.gridList = gridList;
	}

	public List<GARM1000V0Out01VO> getSmarList() {
		return smarList;
	}

	public void setSmarList(List<GARM1000V0Out01VO> smarList) {
		this.smarList = smarList;
	}
    
}
