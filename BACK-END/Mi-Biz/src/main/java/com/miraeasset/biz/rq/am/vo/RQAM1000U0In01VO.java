package com.miraeasset.biz.rq.am.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.login.vo.LoginOutVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RQAM1000U0In01VO extends LoginOutVO {

    @ApiModelProperty(notes= "결재자사원번호")
    private String aprvEpno          ; /* 결재자사원번호 */
    
    List<RQAM1000U0In11VO> grid11;    // 결제대상내역

	public String getAprvEpno() {
		return aprvEpno;
	}

	public void setAprvEpno(String aprvEpno) {
		this.aprvEpno = aprvEpno;
	}

	public List<RQAM1000U0In11VO> getGrid11() {
		return grid11;
	}

	public void setGrid11(List<RQAM1000U0In11VO> grid11) {
		this.grid11 = grid11;
	}

    
}
    
