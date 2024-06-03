package com.miraeasset.biz.common.aprv.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class Aprv00In01VO {

    @ApiModelProperty(notes= "결재자사원번호")
    private String aprvEpno          ; /* 결재자사원번호 */

    List<Aprv00In11VO> grid11;    // 결제대상내역

	public String getAprvEpno() {
		return aprvEpno;
	}

	public void setAprvEpno(String aprvEpno) {
		this.aprvEpno = aprvEpno;
	}

	public List<Aprv00In11VO> getGrid11() {
		return grid11;
	}

	public void setGrid11(List<Aprv00In11VO> grid11) {
		this.grid11 = grid11;
	}

    
}
    
