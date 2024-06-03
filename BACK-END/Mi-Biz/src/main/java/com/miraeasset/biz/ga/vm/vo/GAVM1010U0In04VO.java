package com.miraeasset.biz.ga.vm.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAVM1010U0In04VO {
	
	@ApiModelProperty(notes = "차량정보변경 삭제 - 다건처리")
	List<GAVM1010U0In03VO> inpuData;

	public List<GAVM1010U0In03VO> getInpuData() {
		return inpuData;
	}

	public void setInpuData(List<GAVM1010U0In03VO> inpuData) {
		this.inpuData = inpuData;
	}
	
}
