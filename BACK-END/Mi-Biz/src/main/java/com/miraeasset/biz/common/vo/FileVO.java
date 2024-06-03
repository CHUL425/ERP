package com.miraeasset.biz.common.vo;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class FileVO {
	private String atcFileGuid;
	private String tskId;
	private String atcFileLgcNm;
	private long atcFileSize;
	private String atcFileExtsNm;
	private String pubYn;
	private String delYn;
	private String optrId;
	private String oprtChnlCd;
	private String oprtOrzCd;
	private String oprtIpAdr;
	private String oprtDttm;
	
	@ApiModelProperty(notes= "파일번호")
	private String fileNo               ; /*파일번호      */
	@ApiModelProperty(notes= "파일상세번호")
	private String fileDlNo             ; /*파일상세번호  */
	@ApiModelProperty(notes= "파일종류코드")
	private String fileKcd              ; /*파일종류코드  */
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
	
    @Override
    public String toString() {
        return "FileVO{" +
        		"fileNo            ='" + fileNo         + "'" + "\n" + 
        		"fileDlNo          ='" + fileDlNo       + "'" + "\n" + 
        		"fileKcd           ='" + fileKcd        + "'" + "\n" + 
        		"fileNm            ='" + fileNm         + "'" + "\n" + 
        		"fileSize          ='" + fileSize       + "'" + "\n" + 
        		"atcFilePathNm     ='" + atcFilePathNm  + "'" + "\n" + 
        		"atcFilePhysNm     ='" + atcFilePhysNm  + "'" + "\n" + 
        		"useYn             ='" + useYn          + "'" + "\n" + 
                '}';    	
    }		

	public String getAtcFileGuid() { return atcFileGuid; } public void setAtcFileGuid(String atcFileGuid) { this.atcFileGuid = atcFileGuid; }
	public String getTskId() { return tskId; } public void setTskId(String tskId) { this.tskId = tskId; }
	public String getAtcFilePathNm() { return atcFilePathNm; } public void setAtcFilePathNm(String atcFilePathNm) { this.atcFilePathNm = atcFilePathNm; }
	public String getAtcFilePhysNm() { return atcFilePhysNm; } public void setAtcFilePhysNm(String atcFilePhysNm) { this.atcFilePhysNm = atcFilePhysNm; }
	public String getAtcFileLgcNm() { return atcFileLgcNm; } public void setAtcFileLgcNm(String atcFileLgcNm) { this.atcFileLgcNm = atcFileLgcNm; }
	public long getAtcFileSize() { return atcFileSize; } public void setAtcFileSize(long atcFileSize) { this.atcFileSize = atcFileSize; }
	public String getAtcFileExtsNm() { return atcFileExtsNm; } public void setAtcFileExtsNm(String atcFileExtsNm) { this.atcFileExtsNm = atcFileExtsNm; }
	public String getPubYn() { return pubYn; } public void setPubYn(String pubYn) { this.pubYn = pubYn; }
	public String getDelYn() { return delYn; } public void setDelYn(String delYn) { this.delYn = delYn; }
	public String getOptrId() { return optrId; } public void setOptrId(String optrId) { this.optrId = optrId; }
	public String getOprtChnlCd() { return oprtChnlCd; } public void setOprtChnlCd(String oprtChnlCd) { this.oprtChnlCd = oprtChnlCd; }
	public String getOprtOrzCd() { return oprtOrzCd; } public void setOprtOrzCd(String oprtOrzCd) { this.oprtOrzCd = oprtOrzCd; }
	public String getOprtIpAdr() { return oprtIpAdr; } public void setOprtIpAdr(String oprtIpAdr) { this.oprtIpAdr = oprtIpAdr; }
	public String getOprtDttm() { return oprtDttm; }
	
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
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public void setOprtDttm(String oprtDttm) {
		this.oprtDttm = oprtDttm;
	}
	
	
}
