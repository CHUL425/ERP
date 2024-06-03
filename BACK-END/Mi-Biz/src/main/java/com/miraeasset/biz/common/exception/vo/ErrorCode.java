package com.miraeasset.biz.common.exception.vo;

public enum ErrorCode implements EnumModel{


	INVALID_CODE(400, "C001", "Invalid Code"),
	RESOURCE_NOT_FOUND(404, "C002", "Not Found"),
	BAD_REQUEST(400, "C003", "Bad Request"),
	SESSION_LESS(404, "C004", "No Session"),
	INTERNAL_SERVER_ERROR(500, "S001", "Internal Server Error"),
	// 엑셀전요 에러 메세지(임시)
	EXCEL_DRM_NOT_FOUND(500, "E016", "user not set HomeDir or required property"),
	NOT_EXCEL_EXTENSION(500, "E011", "not supported source file extension"),
	EXCEL_FILE_ERROR(500, "E002", "excel file error"),
	EXCEL_UPLOAD_FAIL(500, "E003", "excel file upload fail"),
	FILE_DIR_ERROR(500, "E001", "file Dir error"),
	EXCEL_FILE_READ_FAIL(500, "E004", "excel file read fail"),
	UNAUTHORIZED(401, "C005", "Unauthorized")
	;
	private int status;
	private final String code;
	private final String message;
	private String detail;

	ErrorCode(int status, String code, String message){
		this.status = status;
		this.code = code;
		this.message = message;
	}
	
	@Override
	public String getKey() {
		return this.code;
	}

	@Override
	public String getValue() {
		return this.message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
