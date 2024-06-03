/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: SSBS9000V0In01VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 판관비계정과목관리 신규등록 다건 IN
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/

package com.miraeasset.biz.ss.bs.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.meta.vo.GA01C001VO;
import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class SSBS9000V0In01VO extends BaseVO {

	
	@ApiModelProperty(notes= "판관비계정과목관리 다건내역")
	List<GA01C001VO> gridGA01C001;    /*  판관비계정과목관리 다건내역 */

	public List<GA01C001VO> getGridGA01C001() {
		return gridGA01C001;
	}

	public void setGridGA01C001(List<GA01C001VO> gridGA01C001) {
		this.gridGA01C001 = gridGA01C001;
	}
	
	
}
