package com.erp.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.erp.mvc.dto.Board;
import com.erp.mvc.dto.User;

//import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller				// Controller 로 지정하고 빈 등록
@RequestMapping("/request")
public class RequestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);
	
	// 업로드 경로
	//@Resource(name = "uploadPath")
    @Value("${upload.path}")            // application.properties 에 설정한 업로드 경로 속성명
    private String uploadPath;          // 업로드 경로

	/**
	 * @RequestMapping : 요청 경로 매핑
	 *  - /request/board 로 요청
	 *  - /request/board.jsp 응답
	 * @return
	 */
//	@RequestMapping(value = "/request/board", method = RequestMethod.GET)		
//	@RequestMapping("/request/board")		
	@RequestMapping("/board")		
	public String request() {
		logger.info("[GET] - /request/board");
		return "request/board";
	}
	
	/**
	 * 경로 패턴 매핑
	 * @param no
	 * @return
	 */
	@RequestMapping(value = "/board/{no}", method = RequestMethod.GET)
	public String requestPath(@PathVariable("no") int no) {
		logger.info("[GET] - /request/board/{no}");
		logger.info("no : " + no);
		
		return "request/board";
	}
	
	/**
	 * 요청 메소드 매핑
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/board", method = RequestMethod.POST)
	// public String requestPost(@RequestParam("no") int data) {
	public String requestPost(@RequestParam int no) {
		logger.info("[POST] - /request/post");
		logger.info("no : " + no);
		return "SUCCESS - no : " + no;
	}
	
	/**
	 * 파라미터 매핑
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/board", method = RequestMethod.GET, params = "id")
	public String requestParams(@RequestParam String id) {
		logger.info("[GET] - /request/board?id=board_123");
		logger.info("id : " + id);
		
		return "request/board";
	}
	

	/**
	 * 헤더 매핑
	 * @return
	 */
	// headers = "헤더명=값"
	@ResponseBody
	@RequestMapping(value = "/board", method = RequestMethod.POST, headers = "Content-Type=application/json" )
	public String requestHeader() {
		logger.info("[POST] - /request/board");
		logger.info("헤더 매핑...");
		return "SUCCESS";
	}
	
	
	/*
	 	@ResponseBody O : return "데이터"; 	---> 응답메시지( 본문: 데이터 )
	 	@ResponseBody X : return "화면이름";	---> 뷰 리졸버가 jsp 선택->렌더링->html 응답
	*/
	@RequestMapping(value = "/board", method = RequestMethod.PUT)
	public String requestPut() {
		logger.info("[POST] (PUT) - /request/board");
		return "redirect:/";
	}
	
	
	/**
	 * 컨텐츠 타입 매핑
	 * - Content-Type 헤더의 값으로 매핑
	 * - consumes = "컨텐츠타입값"
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/board", method = RequestMethod.POST, consumes = "application/xml")
	public String requestContentType() {
		logger.info("[POST] - /board/request");
		logger.info("컨텐츠 타입 매핑...");
		return "SUCCESS";
	}
	
	
	/**
	 * Accept 매핑
	 * - Accept 헤더의 값으로 매핑 (Accept 헤더는 응답 답을 컨텐츠 타입을 지정)
	 * - produces = "컨텐츠타입값"
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/board", method = RequestMethod.POST, produces = "application/json")
	public String requestAccept() {
		logger.info("[POST] - /board/request");
		logger.info("Accept 매핑...");
		return "SUCCESS";
	}
	
	
	/* ---------------------- [요청 경로 매핑 ] ------------------------- */
	/* --------------------------------------------------------------- */
	/* ---------------------- [요청 처리 ] ----------------------------- */
	

	/**
	 * 요청 헤더를 가져오기
	 * @param accept
	 * @param userAgent
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header(@RequestHeader("Accept") String accept
	                   , @RequestHeader("User-Agent") String userAgent
					   , HttpServletRequest request) {
		// @RequestHeader : 헤더명을 지정하여 헤더 값을 가져오는 어노테이션
		// * @RequestHeader("헤더명") 타입 매개변수
		logger.info("[GET] - /request/header");
		logger.info("@RequestHeader 를 통한 헤더 정보 가져오기");
		logger.info("Accept - " + accept);
		logger.info("User-Agent - " + userAgent);
		
		String requestAccept = request.getHeader("Accept");
		String requestUserAgent = request.getHeader("User-Agent");
		logger.info("HttpServletRequest 을 통한 헤더 정보 가져오기");
		logger.info("Accept - " + requestAccept);
		logger.info("User-Agent - " + requestUserAgent);
		
		return "SUCCESS";
	}
	
	/**
	 * 요청 본문 가져오기
	 * @param board
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/body", method = RequestMethod.POST)
	// public String requestBody(@RequestBody Board board) {   // 에러남..... @RequestBody를 빼야함.
	public String requestBody(Board board) {
		// @RequestBody
		// : HTTP 요청 메시지의 본문(body)의 내용을 객체로 변환하는 어노테이션
		//  ****** 클라이언트에서 contentType: JSON 형식에 데이터를 보낸 경우 !!!!!!
		//	 객체로 변환하기 위해 사용한다.
		// * 생략가능 (주로 생략하고 쓴다.)
		logger.info("[POST] - /request/body");
		logger.info(board.toString());
		
		return "SUCCESS";
	}
	/**
	 * 체크박스 데이터 가져오기
	 * @param hobbies
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	//public String requestCheck(@RequestParam("hobby") String[] hobbies) {  // 아무것도 선택하지 않는 경우  Error
	public String requestCheck(String[] hobbies) {
			// 체크박스 다중 데이터는 배열로 전달 받을 수 있다.
		logger.info("[POST] - /request/check");
		
		if (hobbies == null) return "FAIL";
		
		logger.info(hobbies.toString());
		
		for (String hobby : hobbies) {
			logger.info("hobby : " + hobby);
		}
		
		return "SUCCESS";
	}
	
	
	/**
	 * date 형식과, 여러 요청 정보를 객체로 가져오기
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user", method = RequestMethod.POST)
//	public String requestUser(String birth) {
//	public String requestUser(@DateTimeFormat(pattern="yyyy-MM-dd") Date birth) {
	public String requestUser(User user) throws Exception {
		// 체크박스 다중 데이터는 배열로 전달 받을 수 있다.
		logger.info("[POST] - /request/user");
		// logger.info("birth : " + birth);
		logger.info("user - " + user);
		
		logger.info("hobbies 출력 - 시작 ");		
		String[] hobbies = user.getHobby();
		
		if( hobbies == null ) return "FAIL";
		
		System.out.println("hobbies.length : " + hobbies.length);  // hobbies null인경우 에러 남.
		
		for (String hobby : hobbies) {
			logger.info("hobby : " + hobby);
		}
		logger.info("hobbies 출력 - 종료 ");		
				
		return "SUCCESS";
	}
	
	/**
	 * Map 컬렉션으로 요청 파라미터 가져오기
	 * 요청경로 : http://localhost:8080/request/map?name=정연철&age=54
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/map")
	public String requestMap(@RequestParam Map<String, String> map) {
		String name = map.get("name");
		String age = map.get("age");
		
		logger.info("name : " + name);
		logger.info("age : " + age);
		return "SUCCESS";
	}
	
	// 파일 업로드
	// 파일을 복수로 선택하는 경우 1개의 파일만 처리함.
	@ResponseBody
	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public String fileUpload(MultipartFile file) throws Exception {
		logger.info("/requet/file");
		logger.info("uploadPath : " + uploadPath);
		
		if( file == null ) return "FAIL";
		
		logger.info("originalFileName : " + file.getOriginalFilename());
		logger.info("size : " + file.getSize());
		logger.info("contentType : " + file.getContentType());

		if( file.getSize() == 0 ) return "FAIL";
		
		// 파일 데이터
		byte[] fileData = file.getBytes();
		
		// 파일 업로드
		String filePath = uploadPath;
		String fileName = file.getOriginalFilename();
		File uploadFile = new File(filePath, fileName);
		
		FileCopyUtils.copy(fileData, uploadFile); // 파일 업로드(저장)
		// FileCopyUtils.copy(파일 데이터, 파일 객체);
		// : 내부적으로 InputStream, OutputStream 을 이용하여 입력받은 파일을 출력한다.
		
		return "SUCCESS";
	}
	
	
	// 다중 파일 업로드
	@ResponseBody
	@RequestMapping(value = "/file/multi", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile[] fileList) throws Exception {
		logger.info("/requet/file/multi");
		logger.info("uploadPath : " + uploadPath);
		
		if( fileList == null ) return "FAIL";
		
		if( fileList.length > 0 ) {
			for (MultipartFile file : fileList) {
				logger.info("originalFileName : " + file.getOriginalFilename());
				logger.info("size : " + file.getSize());
				logger.info("contentType : " + file.getContentType());
				
				if( file.getSize() == 0 ) return "FAIL";
				
				// 파일 데이터
				byte[] fileData = file.getBytes();
				
				// 파일 업로드
				String filePath = uploadPath;
				String fileName = file.getOriginalFilename();
				File uploadFile = new File(filePath, fileName);
				
				FileCopyUtils.copy(fileData, uploadFile); // 파일 업로드(저장)
			}
		}
		return "SUCCESS";
	}
	
	
	// 게시판 파일 업로드
	@ResponseBody
	@RequestMapping(value = "/file/board", method = RequestMethod.POST)
	public String fileUpload(Board board) throws Exception {
		logger.info("/requet/file/board");
		logger.info("uploadPath : " + uploadPath);
		logger.info("board : " + board);
		
		// MultipartFile[] fileList = board.getFileList();
		List<MultipartFile> fileList = board.getFileList();
		if( fileList == null ) return "FAIL";
		
//		if( fileList.length > 0 ) {
		if( !fileList.isEmpty() ) {
			for (MultipartFile file : fileList) {
				logger.info("originalFileName : " + file.getOriginalFilename());
				logger.info("size : " + file.getSize());
				logger.info("contentType : " + file.getContentType());
				
				if( file.getSize() == 0 ) return "FAIL";
				
				// 파일 데이터
				byte[] fileData = file.getBytes();
				
				// 파일 업로드
				String filePath = uploadPath;
				String fileName = file.getOriginalFilename();
				File uploadFile = new File(filePath, fileName);
				
				FileCopyUtils.copy(fileData, uploadFile); // 파일 업로드(저장)
			}
		}
		return "SUCCESS";
	}
	
	/**
	 * request/ajax.jsp 
	 * @return
	 */
	@RequestMapping("/ajax")
	public String ajax() {
		
		return "request/ajax";
	}
	
	
	/**
	 * AJAX 비동기 파일 업로드
	 * @param board
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/ajax", method = RequestMethod.POST)
	public String ajaxUploadPost(Board board) throws IOException {
		logger.info("/request/ajax");
		logger.info("uploadPath : " + uploadPath);
		logger.info(board.toString());
		
		List<MultipartFile> fileList = board.getFileList();
		
		//if( fileList == null ) return "FAIL";
		
		if( fileList != null && !fileList.isEmpty() ) {
			for (MultipartFile file : fileList) {
				logger.info("originalFileName : " + file.getOriginalFilename());
				logger.info("size : " + file.getSize());
				logger.info("contentType : " + file.getContentType());
				
				byte[] fileData = file.getBytes();
				
				String filePath = uploadPath;
				String fileName = file.getOriginalFilename();
				File uploadFile = new File(filePath, fileName);
				FileCopyUtils.copy(fileData, uploadFile);			// 파일 업로드
			}
		}

		return "SUCCESS";
	}
}