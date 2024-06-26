package com.erp.mvc.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Board {
	
	private int no;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private Date updDate;
	
	// 파일 정보
//	MultipartFile[] fileList;
	List<MultipartFile> fileList;
	
	
	public Board() {}
	
	public Board(int no, String title, String writer, String content) {
		this.no      = no     ;
		this.title   = title  ;
		this.writer  = writer ;
		this.content = content;
	}
}