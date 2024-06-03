package com.miraeasset.biz.ga.vm.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GAVM1010U0In05VO {
	
	@ApiModelProperty(notes = "처리일자")
	List<GAVM1010U0In02VO> inputList;

	public List<GAVM1010U0In02VO> getInputList() {
		return inputList;
	}

	public void setInputList(List<GAVM1010U0In02VO> inputList) {
		this.inputList = inputList;
	}
	
}
