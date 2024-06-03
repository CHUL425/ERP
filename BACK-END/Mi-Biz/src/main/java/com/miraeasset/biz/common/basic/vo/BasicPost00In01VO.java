package com.miraeasset.biz.common.basic.vo;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class BasicPost00In01VO {

    @ApiModelProperty(notes= "조건검색1")
    private String schWhere1     ;  /* 조건검색1 */

    @ApiModelProperty(notes= "조건검색2")
    private String schWhere2     ;  /* 조건검색2 */
    
	@ApiModelProperty(notes= "페이지순번", example="0")          
	private BigDecimal pageIndex  ;  /* 페이지순번 */
	@ApiModelProperty(notes= "페이지사이즈", example="0")          
	private BigDecimal pageSize   ;  /* 페이지사이즈 */
    
	@ApiModelProperty(notes= "건물본주소")          
	private String bdno   ;  /* 건물본주소 */
	
	@ApiModelProperty(notes= "건물상세주소")          
	private String bdsno   ;  /* 건물상세주소 */
	
	@ApiModelProperty(notes= "동적조건")          
	private ArrayList<String> whereList    ;  /* 동적조건 */
	
	
    @Override
    public String toString() {
        return  "  BasicPost00Out00VO{ "+
        		", schWhere1           = '" + schWhere1           + "'" +
        		", schWhere2            = '" + schWhere2            + "'" +
        		", bdno            = '" + bdno            + "'" +
        		", bdsno            = '" + bdsno            + "'" +
        		", pageIndex            = '" + pageIndex            + "'" +
        		", pageSize            = '" + pageSize            + "'" +
        		"}";
    }	
	
	public String getSchWhere1() {
		return schWhere1;
	}

	public void setSchWhere1(String schWhere1) {
		this.schWhere1 = schWhere1;
	}

	public String getSchWhere2() {
		return schWhere2;
	}

	public void setSchWhere2(String schWhere2) {
		this.schWhere2 = schWhere2;
	}

	public BigDecimal getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(BigDecimal pageIndex) {
		this.pageIndex = pageIndex;
	}

	public BigDecimal getPageSize() {
		return pageSize;
	}

	public void setPageSize(BigDecimal pageSize) {
		this.pageSize = pageSize;
	}

	public String getBdno() {
		return bdno;
	}

	public void setBdno(String bdno) {
		this.bdno = bdno;
	}

	public String getBdsno() {
		return bdsno;
	}

	public void setBdsno(String bdsno) {
		this.bdsno = bdsno;
	}

	public ArrayList<String> getWhereList() {
		return whereList;
	}

	public void setWhereList(ArrayList<String> whereList) {
		this.whereList = whereList;
	}
    
	
    

}
