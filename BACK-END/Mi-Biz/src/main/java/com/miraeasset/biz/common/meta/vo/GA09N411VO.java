/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: GA
*	03. 파    일   명	: GA01N304VO.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: GA09N411	첨부파일상세관리테이블 원장 항목
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.common.meta.vo;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.miraeasset.biz.common.vo.BaseVO;

import io.swagger.annotations.ApiModelProperty;

@Component
public class GA09N411VO extends BaseVO {
	
    @ApiModelProperty(notes= "파일번호")
	private String fileNo               ; /*파일번호      */
	@ApiModelProperty(notes= "파일상세번호")
	private String fileDlNo             ; /*파일상세번호  */
	@ApiModelProperty(notes= "파일종류코드")
	private String fileKcd              ; /*파일종류코드  */
	@ApiModelProperty(notes= "파일종류코드명")
	private String fileKcdNm            ; /*파일종류코드명 */
	@ApiModelProperty(notes= "파일명(논리파일명 화면업로드파일명)")
	private String fileNm               ; /*파일명        */
	@ApiModelProperty(notes= "파일크기", example = "0")
	private long   fileSize             ; /*파일크기      */
	@ApiModelProperty(notes= "첨부파일이미지")
	private byte[] atcFileImg           ; /*첨부파일이미지*/
	@ApiModelProperty(notes= "첨부파일경로명")
	private String atcFilePathNm        ; /*첨부파일경로명*/
	@ApiModelProperty(notes= "첨부파일물리명(서버에 저장된실제파일명)")
	private String atcFilePhysNm        ; /*첨부파일물리명*/
	@ApiModelProperty(notes= "사용여부")
	private String useYn                ; /*사용여부      */
	
	private String optrId;
	private String oprtChnlCd;
	private String oprtOrzCd;
	private String oprtIpAdr;
	private String oprtDttm;
	
    @Override
    public String toString() {
        return "GA09N411VO{" +
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

	public String getFileKcd() {
		return fileKcd;
	}

	public void setFileKcd(String fileKcd) {
		this.fileKcd = fileKcd;
	}

	public String getFileKcdNm() {
		return fileKcdNm;
	}

	public void setFileKcdNm(String fileKcdNm) {
		this.fileKcdNm = fileKcdNm;
	}

	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public byte[] getAtcFileImg() {
		return atcFileImg;
	}

	public void setAtcFileImg(byte[] atcFileImg) {
		this.atcFileImg = atcFileImg;
	}

	public String getAtcFilePathNm() {
		return atcFilePathNm;
	}

	public void setAtcFilePathNm(String atcFilePathNm) {
		this.atcFilePathNm = atcFilePathNm;
	}

	public String getAtcFilePhysNm() {
		return atcFilePhysNm;
	}

	public void setAtcFilePhysNm(String atcFilePhysNm) {
		this.atcFilePhysNm = atcFilePhysNm;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getOptrId() {
		return optrId;
	}

	public void setOptrId(String optrId) {
		this.optrId = optrId;
	}

	public String getOprtChnlCd() {
		return oprtChnlCd;
	}

	public void setOprtChnlCd(String oprtChnlCd) {
		this.oprtChnlCd = oprtChnlCd;
	}

	public String getOprtOrzCd() {
		return oprtOrzCd;
	}

	public void setOprtOrzCd(String oprtOrzCd) {
		this.oprtOrzCd = oprtOrzCd;
	}

	public String getOprtIpAdr() {
		return oprtIpAdr;
	}

	public void setOprtIpAdr(String oprtIpAdr) {
		this.oprtIpAdr = oprtIpAdr;
	}

	public String getOprtDttm() {
		return oprtDttm;
	}

	public void setOprtDttm(String oprtDttm) {
		this.oprtDttm = oprtDttm;
	}


}
