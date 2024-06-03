package com.miraeasset.biz.common.basic.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicPost00Out00VO {

	@ApiModelProperty(notes= "일련번호")
	private String srno1          ; /* 일련번호             */
	
	@ApiModelProperty(notes= "검색어")
	private String schw1          ; /* 검색어1             */        
	
	@ApiModelProperty(notes= "검색어")
	private String schw2          ; /* 검색어2             */

	
    @Override
    public String toString() {
        return  "  BasicPost00Out00VO{ "+
        		", srno1           = '" + srno1           + "'" +
        		", schw1            = '" + schw1            + "'" +
        		", schw2            = '" + schw2            + "'" +
        		"}";
    }
    
	public String getSrno1() {
		return srno1;
	}

	public void setSrno1(String srno1) {
		this.srno1 = srno1;
	}

	public String getSchw1() {
		return schw1;
	}

	public void setSchw1(String schw1) {
		this.schw1 = schw1;
	}

	public String getSchw2() {
		return schw2;
	}

	public void setSchw2(String schw2) {
		this.schw2 = schw2;
	}        


	
}
