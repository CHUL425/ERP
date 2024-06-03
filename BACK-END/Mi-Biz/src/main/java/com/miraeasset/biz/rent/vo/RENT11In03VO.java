package com.miraeasset.biz.rent.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class RENT11In03VO {

    @ApiModelProperty(notes= "접수번호", required = true)
    private String rctNo;            // 접수번호

    @ApiModelProperty(notes= "신청분류코드")
    private List<ArrayList> grid;            // 신청분류코드

	public String getRctNo() {
		return rctNo;
	}

	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
	}

	public List<ArrayList> getGrid() {
		return grid;
	}

	public void setGrid(List<ArrayList> grid) {
		this.grid = grid;
	}


    @Override
    public String toString() {
        return "RENT11In03VO{" +
                "rctNo     ='" + rctNo    + "'" +
                "grid     ='" + grid.size()    + "'" +
                '}';    	
    }
	
	
}
