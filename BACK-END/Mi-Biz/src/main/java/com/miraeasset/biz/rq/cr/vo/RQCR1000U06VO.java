package com.miraeasset.biz.rq.cr.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQCR1000U06VO {
	
	@ApiModelProperty(notes = "공사신청다건삭제처리")
	List<RQCR1000U05VO> delList;

	public List<RQCR1000U05VO> getDelList() {
		return delList;
	}

	public void setDelList(List<RQCR1000U05VO> delList) {
		this.delList = delList;
	}
}
