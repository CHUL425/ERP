/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N304VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N411Vs01InVO	첨부파일상세관리테이블 PK input
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N411Vs01InVO extends BaseVO {
	
    @ApiModelProperty(notes= "파일번호")
	private String fileNo               ; /*파일번호      */
	@ApiModelProperty(notes= "파일상세번호")
	private String fileDlNo             ; /*파일상세번호  */
    @Override
    public String toString() {
        return "GA09N411Vs01InVO{" +
        		"fileNo     ='" + fileNo   + "'" +
        		"fileDlNo   ='" + fileDlNo + "'" +
                '}';    	
    }
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileDlNo() {
		return fileDlNo;
	}
	public void setFileDlNo(String fileDlNo) {
		this.fileDlNo = fileDlNo;
	}
    
    
}
