/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: RQ
*	03. 파    일   명	: RQSR1000U0Controller.java
*	04. 작  성  일  자	: 2023.08.17
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 인감날인증명서신청 컨트롤러
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.rq.sr.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.CustomRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.ExcelFile;
import com.miraeasset.biz.common.util.excel.OneSheetExcelFile;
import com.miraeasset.biz.common.util.excel.resource.DefaultDataFormatDecider;
import com.miraeasset.biz.rq.sr.service.RQSR1000U0Service;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In00VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In01VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In03VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In04VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In05VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In17VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In19VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In20VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In21VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In23VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In24VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In25VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0In26VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out00VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out01VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out02VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out11VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out15VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out17VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out18VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out19VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out20VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out21VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out24VO;
import com.miraeasset.biz.rq.sr.vo.RQSR1000U0Out25VO;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/main/rqsr1000u0")
public class RQSR1000U0Controller extends CustomRequestException{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RQSR1000U0Service RQSR1000U0Service;

	/**
	 * 인감날인증명서신청 목록조회
	 */
	@ApiOperation(value="인감날인증명서신청 목록조회")
	@RequestMapping(value= "/selectListGA01N101BySeal", method = RequestMethod.POST)
	@ResponseBody
	public List<RQSR1000U0Out00VO> selectListGA01N101BySeal(@RequestBody RQSR1000U0In00VO vo, HttpServletRequest request) {
		return RQSR1000U0Service.selectListGA01N101BySeal(vo, request);
	}
	
	
	/**
	 * 인감날인증명서신청 상세조회
	 */
	@ApiOperation(value="인감날인증명서신청 상세조회")
	@RequestMapping(value= "/selectUnifRqsBySeal", method = RequestMethod.POST)
	@ResponseBody
	public RQSR1000U0Out01VO selectUnifRqsBySeal(@RequestBody RQSR1000U0In01VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		vo.setEpno(loginVo.getEpno());
		return RQSR1000U0Service.selectUnifRqsBySeal(vo);
	}	
	
	
	/**
	 * 인장신청_인감날인신청신청상태 정보조회
	 */
	@ApiOperation(value="인장신청_인감날인신청신청상태 정보조회")
	@RequestMapping(value= "/selectInfoGA01N101BySeal", method = RequestMethod.POST)
	@ResponseBody
	public RQSR1000U0Out11VO selectInfoGA01N101BySeal(@RequestBody RQSR1000U0In00VO vo, HttpServletRequest request) {
		return RQSR1000U0Service.selectInfoGA01N101BySeal(vo, request);
	}
	
	
	/**
	 * 인감날인증명서신청 임시저장/상신
	 */
	@ApiOperation(value="인감날인증명서신청 임시저장/상신")
	@RequestMapping(value= "/reqRegi", method = RequestMethod.POST)
	@ResponseBody
	public  String reqRegi(@RequestBody RQSR1000U0In03VO vo) {
		return RQSR1000U0Service.reqRegi(vo);
	}		

	
	/**
	 * 인감날인증명서신청 삭제
	 */
	@ApiOperation(value="인감날인증명서신청 삭제")
	@RequestMapping(value= "/deleteUnifRqsBySeal", method = RequestMethod.POST)
	@ResponseBody
	public  int deleteUnifRqsBySeal(@RequestBody RQSR1000U0In04VO vo) {
		return RQSR1000U0Service.deleteUnifRqsBySeal(vo);
	}
	
	
	/**
	 * 인감날인증명서신청 반려건 재신청
	 */
	@ApiOperation(value="인감날인증명서신청 반려건 재신청")
	@RequestMapping(value= "/reApplyByRctNo", method = RequestMethod.POST)
	@ResponseBody
	public  String reApplyByRctNo(@RequestBody RQSR1000U0In05VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		return RQSR1000U0Service.reApplyByRctNo(vo,loginVo);
	}	
	
	
	/**
	 * 인감날인증명서신청내역 엑셀다운로드
	 */
	@ApiOperation(value="인감날인증명서신청내역 엑셀다운로드")
	@RequestMapping(value= "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadExcel(RQSR1000U0In00VO vo, HttpServletRequest request, HttpServletResponse response) throws IOException {

		String fileName = "인감날인증명서신청내역_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		List<RQSR1000U0Out00VO> list = RQSR1000U0Service.selectListGA01N101BySeal(vo,request);
		ExcelFile<RQSR1000U0Out00VO> excelFile = new OneSheetExcelFile<>(list, RQSR1000U0Out00VO.class, new DefaultDataFormatDecider());
		excelFile.write2(response, downFileName);
	}	
	
	
	/**
	 * 인감날인증명서 승인대기 목록조회
	 */
	@ApiOperation(value="인감날인증명서 승인대기 목록조회")
	@RequestMapping(value= "/selectListApvIng", method = RequestMethod.POST)
	@ResponseBody
	public List<RQSR1000U0Out21VO> selectListApvIng(@RequestBody RQSR1000U0In21VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setEpno(loginVo.getEpno()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return RQSR1000U0Service.selectListApvIng(vo);
	}    
	
	
	/**
	 * 인감날인증명서 사전참조 목록조회
	 */
	@ApiOperation(value="인감날인증명서 사전참조 목록조회")
	@RequestMapping(value= "/selectListApvRef", method = RequestMethod.POST)
	@ResponseBody
	public List<RQSR1000U0Out21VO> selectListApvRef(@RequestBody RQSR1000U0In21VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setEpno(loginVo.getEpno()); // 로그인사번
			
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return RQSR1000U0Service.selectListApvRef(vo);
	} 
	
	
	/**
	 * 인감날인증명서 사전참조 다건 확인처리
	 */
	@ApiOperation(value="인감날인증명서 사전참조 다건 확인처리")
	@RequestMapping(value= "/updateGA09N607ForCfmt", method = RequestMethod.POST)
	@ResponseBody
	public  int updateGA09N607ForCfmt(@RequestBody RQSR1000U0In23VO vo, HttpServletRequest request) {
		return RQSR1000U0Service.updateGA09N607ForCfmt(vo, request);
	}
	
	
	/**
	 * 인감날인증명서 승인완료 목록조회
	 */
	@ApiOperation(value="인감날인증명서 승인완료 목록조회")
	@RequestMapping(value= "/selectListApvCmpn", method = RequestMethod.POST)
	@ResponseBody
	public List<RQSR1000U0Out20VO> selectListApvCmpn(@RequestBody RQSR1000U0In20VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setAprvEpno(loginVo.getEpno()); //로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		return RQSR1000U0Service.selectListApvCmpn(vo);
	}
	
	/**
	 * 인감날인증명서 승인완료내역 엑셀다운로드
	 */
	@ApiOperation(value="인감날인증명서 승인완료내역 엑셀다운로드")
	@RequestMapping(value= "/CmpnExcel", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody void downloadCmpnExcel(RQSR1000U0In20VO vo, HttpServletRequest request, HttpServletResponse response) throws IOException {

		String fileName = "인감날인증명서승인완료내역_"+DateUtil.getDate()+".xlsx";
		String downFileName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setAprvEpno(loginVo.getEpno()); // 로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		
		List<RQSR1000U0Out20VO> list = RQSR1000U0Service.selectListApvCmpn(vo);
		ExcelFile<RQSR1000U0Out20VO> excelFile = new OneSheetExcelFile<>(list, RQSR1000U0Out20VO.class, new DefaultDataFormatDecider());
		excelFile.write2(response, downFileName);
	}	
	
	/**
	 * 인감날인증명서 승인완료 신청상태 정보조회
	 */
	@ApiOperation(value="인감날인증명서 승인완료 신청상태 정보조회")
	@RequestMapping(value= "/selectListApvCmpnBySeal", method = RequestMethod.POST)
	@ResponseBody
	public RQSR1000U0Out11VO selectListApvCmpnBySeal(@RequestBody RQSR1000U0In20VO vo, HttpServletRequest request) {
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
			vo.setAprvEpno(loginVo.getEpno()); //로그인사번
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		return RQSR1000U0Service.selectListApvCmpnBySeal(vo);
	}
	
	
	/**
	 * 완료 당일잔여수량 조회
	 */
	@ApiOperation(value="완료 당일잔여수량 조회")
	@RequestMapping(value= "/selectInfoGA01N510BalPstt", method = RequestMethod.POST)
	@ResponseBody
	public List<RQSR1000U0Out17VO> selectInfoGA01N510BalPstt() {
		return RQSR1000U0Service.selectInfoGA01N510BalPstt();
	}
	
	
	/**
	 * 인감날인증명서신청 사용처제출, 원본폐기 처리
	 */
	@ApiOperation(value="인감날인증명서신청 사용처제출, 원본폐기 처리")
	@RequestMapping(value= "/rqspBzPrc", method = RequestMethod.POST)
	@ResponseBody
	public int rqspBzPrc(@RequestBody RQSR1000U0In01VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		return RQSR1000U0Service.rqspBzPrc(vo, loginVo);
	}
	
	
	/**
	 * 출고 - 조회
	 */
	@ApiOperation(value="출고 - 조회")
	@RequestMapping(value= "/selectUnifRqsBySealForCmpn", method = RequestMethod.POST)
	@ResponseBody
	public RQSR1000U0Out02VO selectUnifRqsBySealForCmpn(@RequestBody RQSR1000U0In01VO vo, HttpServletRequest request) {
		return RQSR1000U0Service.selectUnifRqsBySealForCmpn(vo);
	}
	
	
	/**
	 * 출고 - 인감증명서 출력
	 */
	@ApiOperation(value="출고 - 인감증명서 출력")
	@RequestMapping(value= "/updateGA01N510Oput", method = RequestMethod.POST)
	@ResponseBody
	public int updateGA01N510Oput(@RequestBody RQSR1000U0In24VO vo, HttpServletRequest request) {
		return RQSR1000U0Service.updateGA01N510Oput(vo, request);
	}
	
	
	/**
	 * 출고 - 출력후 미리보기
	 */
	@ApiOperation(value="출고 - 출력후 미리보기")
	@RequestMapping(value= "/selectGA01N510Oput", method = RequestMethod.POST)
	@ResponseBody
	public List<RQSR1000U0Out24VO> selectGA01N510Oput(@RequestBody RQSR1000U0In24VO vo, HttpServletRequest request) {
		return RQSR1000U0Service.selectGA01N510Oput(vo);
	}
	
	
	/**
	 * 출고 - 재출력/폐기 조회
	 */
	@ApiOperation(value="출고 - 재출력/폐기 조회")
	@RequestMapping(value= "/selectListGA01N510Oput", method = RequestMethod.POST)
	@ResponseBody
	public RQSR1000U0Out25VO selectListGA01N510Oput(@RequestBody RQSR1000U0In24VO vo) {
		return RQSR1000U0Service.selectListGA01N510Oput(vo);
	}
	
	
	/**
	 * 출고 - 재출력/폐기 재출력
	 */
	@ApiOperation(value="출고 - 재출력/폐기 재출력")
	@RequestMapping(value= "/updateGA01N510ReOput", method = RequestMethod.POST)
	@ResponseBody
	public int updateGA01N510ReOput(@RequestBody RQSR1000U0In26VO vo, HttpServletRequest request) { 
		return RQSR1000U0Service.updateGA01N510ReOput(vo, request);
	}
	
	
	/**
	 * 출고 - 완료
	 */
	@ApiOperation(value="출고 - 완료")
	@RequestMapping(value= "/updateGA01N510Cmpn", method = RequestMethod.POST)
	@ResponseBody
	public int updateGA01N510Cmpn(@RequestBody RQSR1000U0In25VO vo, HttpServletRequest request) {
		LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");
		return RQSR1000U0Service.updateGA01N510Cmpn(vo, loginVo);
	}
	
	
	/**
	 * 입고/폐기관리 증명서유형 조회
	 */
	@ApiOperation(value="입고/폐기관리 증명서유형 조회")
	@RequestMapping(value= "/selectListSealDocPcd", method = RequestMethod.POST)
	@ResponseBody
	public List<RQSR1000U0Out15VO> selectListSealDocPcd(HttpServletRequest request) {
		return RQSR1000U0Service.selectListSealDocPcd();
	}	
	
	/**
	 * 입고/폐기관리 조회
	 */
	@ApiOperation(value="입고/폐기관리 조회")
	@RequestMapping(value= "/selectListGA01N510", method = RequestMethod.POST)
	@ResponseBody
	public List<RQSR1000U0Out19VO> selectListGA01N510(@RequestBody RQSR1000U0In19VO vo) {
		return RQSR1000U0Service.selectListGA01N510(vo);
	}
	
	/**
	 * 입고/폐기관리 등록
	 */
	@ApiOperation(value="입고/폐기관리 등록")
	@RequestMapping(value= "/updateGA01N510", method = RequestMethod.POST)
	@ResponseBody
	public int updateGA01N510(@RequestBody RQSR1000U0In17VO vo, HttpServletRequest request) {
		
		if( request.getSession().getAttribute("loginOutVO") != null ){
			LoginOutVO loginVo = (LoginOutVO) request.getSession().getAttribute("loginOutVO");

			vo.setEpno(loginVo.getEpno()); // 로그인사번
			
		} else {
			throw new CustomBadRequestException("서버 세션이 만료되었습니다. 로그인해주세요.", ErrorCode.UNAUTHORIZED);
		}
		return RQSR1000U0Service.updateGA01N510(vo);
	}	
	
	
	/**
	 * 입고/폐기관리 증명서잔고현황 조회
	 */
	@ApiOperation(value="입고/폐기관리 증명서잔고현황 조회")
	@RequestMapping(value= "/selectListGA01N510BalPstt", method = RequestMethod.POST)
	@ResponseBody
	public List<RQSR1000U0Out18VO> selectListGA01N510BalPstt(@RequestBody RQSR1000U0In19VO vo) {
		return RQSR1000U0Service.selectListGA01N510BalPstt(vo);
	}
	
	
	
	
	
	
	
	/**
	 * 입고폐기관리 목록조회
	 */
//	@ApiOperation(value="입고폐기관리 목록조회")
//	@RequestMapping(value= "/selectListIoqMt", method = RequestMethod.POST)
//	@ResponseBody
//	public List<RQSR1000U0Out13VO> selectListIoqMt(@RequestBody RQSR1000U0In13VO vo, HttpServletRequest request) {
//		return RQSR1000U0Service.selectListIoqMt(vo);
//	}       

    /**
	 * 인감증명서잔고 조회
	 */
//	@ApiOperation(value="인감증명서잔고 조회 ")
//	@RequestMapping(value= "/selectGA01N507", method = RequestMethod.POST)
//	@ResponseBody
//	public RQSR1000U0Out14VO selectGA01N507( HttpServletRequest request) {
//		return RQSR1000U0Service.selectGA01N507();
//	}

	
	
	/**
	 * 인감날인 인감증명서 출고완료
	 */
//	@ApiOperation(value="인감날인 인감증명서 출고완료")
//	@RequestMapping(value= "/updateGA01N505Cmpn", method = RequestMethod.POST)
//	@ResponseBody
//	public  int updateGA01N505Cmpn(@RequestBody RQSR1000U0In12VO vo, HttpServletRequest request) {
//		return RQSR1000U0Service.updateGA01N505Cmpn(vo);
//	}	    

	/**
	 * 입고폐기관리 추가등록 
//	 */
//	@ApiOperation(value="입고폐기관리 추가등록")
//	@RequestMapping(value= "/insertGA01N508WithGA01N507", method = RequestMethod.POST)
//	@ResponseBody
//	public  int insertGA01N508WithGA01N507(@RequestBody RQSR1000U0In15VO vo, HttpServletRequest request) {
//		return RQSR1000U0Service.insertGA01N508WithGA01N507(vo);
//	}
	
	/**
	 * 입고폐기관리 삭제 
	 */
//	@ApiOperation(value="입고폐기관리 삭제")
//	@RequestMapping(value= "/deleteGA01N508WithGA01N507", method = RequestMethod.POST)
//	@ResponseBody
//	public  int deleteGA01N508WithGA01N507(@RequestBody RQSR1000U0In16VO vo, HttpServletRequest request) {
//		return RQSR1000U0Service.deleteGA01N508WithGA01N507(vo);
//	}	

}