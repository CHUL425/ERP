package com.miraeasset.biz.common.auth.vo;

import io.swagger.annotations.ApiModelProperty;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

@Component
public class AuthGA09N204In00VO extends BaseVO {

    @ApiModelProperty(notes= "사원번호", required = true, example="s1213617")
    private String epno;            // 사원번호
    @ApiModelProperty(notes= "상위메뉴ID", required = true, example="M20230619145728414_hrk")
    private String hrkMenuId;
    
	public String getEpno() {
		return epno;
	}

	public void setEpno(String epno) {
		this.epno = epno;
	}

	public String getHrkMenuId() {
		return hrkMenuId;
	}

	public void setHrkMenuId(String hrkMenuId) {
		this.hrkMenuId = hrkMenuId;
	}
	
}
