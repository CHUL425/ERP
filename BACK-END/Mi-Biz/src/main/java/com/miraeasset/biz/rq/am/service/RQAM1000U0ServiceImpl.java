package com.miraeasset.biz.rq.am.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.CB01N112VO;
import com.miraeasset.biz.common.meta.vo.CB01N210VO;
import com.miraeasset.biz.common.meta.vo.CB01N310VO;
import com.miraeasset.biz.common.meta.vo.GA01N101VO;
import com.miraeasset.biz.common.meta.vo.GA09N602Vf02OutVO;
import com.miraeasset.biz.common.meta.vo.GA09N607aprvVO;
import com.miraeasset.biz.common.service.CommonService;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.rq.am.dao.RQAM1000U0Dao;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In00VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In01VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0In02VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0Out00VO;
import com.miraeasset.biz.rq.am.vo.RQAM1000U0Out01VO;
import com.miraeasset.biz.rq.rr.vo.RQRR1000U0In06VO;

@Service
@Transactional
public class RQAM1000U0ServiceImpl implements RQAM1000U0Service {

	@Autowired
	RQAM1000U0Dao RQAM1000U0Dao;
	
	@Autowired
	CodeDao CodeDao;
	
	@Autowired
	AprvWrrpt aprvWrrpt;

	@Autowired
	CommonService commonService;

	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/* 승댄대기 내역조회 */	
	@Override
	public List<RQAM1000U0Out00VO> selectAprvList(RQAM1000U0In00VO vo) {
		return RQAM1000U0Dao.selectAprvList(vo);
	}	
	
	/* 반려 처리 - 단건 */	
	@Override
	public int updateAprvRtrn(RQAM1000U0In02VO vo) {
		int mCnt = 0;
		mCnt = aprvWrrpt.aprvRtrn(vo);
		log.info("mCnt  ============"+mCnt);
		return mCnt;
	}
	
	/* 승인 처리 - 다건 */	
	@Override
	public int updateAprvList(RQAM1000U0In01VO vo) {
		int mCnt = 0;
		mCnt = aprvWrrpt.aprvPrc(vo);
		log.info("mCnt  ============"+mCnt);
		return mCnt;
	}
	
	
	/* 2023.09.18 */
	/* 일반싱청 - 철회 */
	/*****************************************************************************
	 *	1. 메 소 드 명	: rqsWdral
	 *  2. 기      능	: 일반신청 철회
	 *	3. 주 요 사 항	: 1. 임대신청 신청상태 변경
	 *                2. 결재정보상세 접수자 데이터에 결재사유내용 => 철회사유 입력( 철회사번, 철회사유 기입 )
	 ****************************************************************************/
	@Override
	public int rqsWdral(RQRR1000U0In06VO vo) {
		int mCnt = 0;
		mCnt = aprvWrrpt.aprvWdral(vo.getRctNo(), vo.getAprvRsnCn(), vo.getPrcEpno(), vo.getPrcOrzCd());
		return mCnt;
	}
	
	
	/* 2023.09.07 */
	/* 기본결재선 조회 */
	@Override
	public List<GA09N607aprvVO> selectBaseAprvLineList(GA09N607aprvVO vo) {
		
		String useSealYn  = vo.getUseSealYn();  // 사용인감계여부(인감날인) 
		String unifRqsPcd = vo.getUnifRqsPcd(); // 통합신청유형코드
		String unifRqsTcd = vo.getUnifRqsTcd(); // 통합신청구분코드
		String horbTcd    = vo.getHobrTcd(); 	// 본지점구분
		String aprvlTpVl2 = "";
		String aprvMtNo  = ""; 				// 디폴트결재선관리번호
		
		String rctNo      = vo.getRctNo();      // 저장된 결제선 조회시 셋팅
		
		List<GA09N607aprvVO> list = null;

		if (StringUtils.isBlank(rctNo)) {
			
			// 결재선관리번호 조회
			GA09N602Vf02OutVO GA09N602Vf02OutVO = new GA09N602Vf02OutVO();
			GA09N602Vf02OutVO.setHobrTcd(horbTcd); 			// 본지점구분
			GA09N602Vf02OutVO.setUnifRqsPcd(unifRqsPcd);	// 통합신청유형코드
			GA09N602Vf02OutVO.setUnifRqsTcd(unifRqsTcd);	// 통합신청구분코드
			GA09N602Vf02OutVO.setAprvlTpVl2(aprvlTpVl2);    // 포탈관리 결재선용
			GA09N602Vf02OutVO.setUseSealYn(useSealYn);
			GA09N602Vf02OutVO = RQAM1000U0Dao.baseAprvLine(GA09N602Vf02OutVO);
			 
			aprvMtNo = GA09N602Vf02OutVO.getAprvlMtNo();
			
			// 결재선관리번호 기준으로 결재선 조회
			vo.setAprvlMtNo(aprvMtNo);
			list = RQAM1000U0Dao.selectBaseAprvLineList(vo);

			/**
			 * 1. GA09N602 리스트를 조회한다
			 * 2. GA09N602의 APRV_UNIT_TCD에 맞게 결재선(GA09N607)을 생성한다
			 *
			 * 01 : 상신자
			 * 06 : APRV_UNIT_GRP_CD(조직) 또는 APRV_UNIT_HR_OSDT_CD(직책)이 비어있지 않은 경우 사용
			 * 07 : (신규) APRV_UNIT_DL_VL을 기준으로 상위조직의 조직대표자 참고해 사용
			 * 10 : 화면담당자
			 * 95 : APRV_UNIT_GRP_CD 해당 조직 모든 사람이 결재 가능
			 * */
			
			// 신청자 소속팀포함한 상위조직코드 리스트 조회
			List<Map<String, String>> hrkOrzCdList = findHrkOrzCdForAprvl(vo.getEpno());
			
			// 기본결재선 기준 상위결제선 정보 설정
			for(GA09N607aprvVO e : list) {
				
				String vl = e.getAprvUnitDlVl(); // 신청자소속팀:0, 상위조직:1, 상상위조직:2
				String tcd = e.getAprvUnitTcd();   
				
				if(!StringUtils.isBlank(vl) && "07".equals(tcd) && hrkOrzCdList!= null) {
					
					int idx = Integer.parseInt(vl);
					
					if((idx+1) > hrkOrzCdList.size()) {
						
						// hrkOrzCdList 기준, 상위조직 없을때 해당row 삭제 - 전처리
						e.setAprvlMtNo(null);
						
					} else if(hrkOrzCdList.get(idx)!=null) {
					
						String strOrzCd = hrkOrzCdList.get(idx).get("orzCd");
						String strOrzNm = hrkOrzCdList.get(idx).get("orzNm");
						String stEpNm = hrkOrzCdList.get(idx).get("epNm");
						String stHrCd = hrkOrzCdList.get(idx).get("hrOsdtCd");
						String stHrNm = hrkOrzCdList.get(idx).get("hrOsdtCdNm");
						
						// 결제선 정보 설정
						e.setAprvUnitGrpCd(strOrzCd);
						e.setAprvOrzCd(strOrzCd);
						e.setAprvUnitGrpNm(strOrzNm);
						e.setAprvOrzNm(strOrzNm);
						e.setAprvOrzOsdtCdEpnm(stEpNm);
						e.setAprvOrzOsdtCdNm(stHrNm);
						e.setAprvUnitTcdNm(stEpNm+"("+stHrNm+","+strOrzNm+")");
						e.setAprvUnitHrOsdtCd(stHrCd);
							
					} else {
						 throw new CustomBadRequestException("결재선조회오류", ErrorCode.BAD_REQUEST);	
					}
				}
			}
			
			// hrkOrzCdList 기준, 상위조직 없을때 해당row 삭제 
			list.removeIf( map -> StringUtils.isBlank(map.getAprvlMtNo()));
			
			// 인감결재선 예외상황(결재선에서 삭제) 
			if(Arrays.asList("BASE10","BASE11").contains(aprvMtNo)) {
				
				// IT지원팀의 경우,2차승인자 부문대표_14 일때 결재선에서 삭제
				if("F00001".equals(list.get(0).getAprvWrrptOrzCd())
				    && "14".equals(list.get(2).getAprvUnitHrOsdtCd())){
					list.remove(2);
				}
				
				// 1차승인자와 2차승인자가 모두 결재선에 있고
				// 1차승인자가 본부장_21, 단장_36, 센터장_50, CISO_70 이고 
				// 2차승인자가 부문대표_14, 준법감시인_26, 대표_35, CRO_38 이면
				// 2차승인자는 결재선에서 삭제
				if(list.size() > 3 
				   && Arrays.asList("21","36","50","70").contains(list.get(1).getAprvUnitHrOsdtCd())
				   && Arrays.asList("14","26","35","38").contains(list.get(2).getAprvUnitHrOsdtCd())){
					list.remove(2);
				}
				
				// 09 사전참조, 직책이 대표_35 일때 결재선에서 삭제
				if("09".equals(list.get(list.size()-1).getDcfcPcd())
				&& "35".equals(list.get(list.size()-1).getAprvUnitHrOsdtCd())) {
					list.remove(list.get(list.size()-1));
				}
			}
			
		} else {
			
			GA01N101VO selVo = new GA01N101VO();
			selVo.setRctNo(rctNo);
			selVo = RQAM1000U0Dao.selectGA01N101Pk(selVo);
			
			// 결재선관리번호 
			vo.setAprvWrrptMtNo(selVo.getAprvWrrptMtNo());
			vo.setRctNo(selVo.getRctNo());
			list = RQAM1000U0Dao.selectTmpStrgAprvLineList(vo);
		}
		
		return list;
	}
	
	/* 임대신청 상태 수정 */
	@Override
	public int updateAprvRqsScd(GA01N101VO vo) {
		return RQAM1000U0Dao.updateAprvRqsScd(vo);
	}

	/**
	 * 조직코드 -> 상위조직코드(본인 조직 포함)
	 * */
	@Override
	public List<Map<String,String>> findHrkOrzCdForAprvl(String epno) {
		/* 사번 -> 인사조직코드 조회 */
		CB01N310VO cb01N310VO = commonService.selectOneCB01N310ByEpno( epno );
		String hrNewOrzCd = cb01N310VO.getHrNewOrzCd();

		/* 인사조직코드 -> 상위 인사조직코드 리스트 조회(본인조직 포함) */
		CB01N112VO cb01N112VO = commonService.selectOneCB01N112ByHrNewOrzCd( hrNewOrzCd );
		List<String> hrkHrNewOrzCdList = new ArrayList<>();
		if( cb01N112VO.getHrLevl9OrzCd() != null && !!!cb01N112VO.getHrLevl9OrzCd().equals("") ) hrkHrNewOrzCdList.add( cb01N112VO.getHrLevl9OrzCd() );
		if( cb01N112VO.getHrLevl8OrzCd() != null && !!!cb01N112VO.getHrLevl8OrzCd().equals("") ) hrkHrNewOrzCdList.add( cb01N112VO.getHrLevl8OrzCd() );
		if( cb01N112VO.getHrLevl7OrzCd() != null && !!!cb01N112VO.getHrLevl7OrzCd().equals("") ) hrkHrNewOrzCdList.add( cb01N112VO.getHrLevl7OrzCd() );
		if( cb01N112VO.getHrLevl6OrzCd() != null && !!!cb01N112VO.getHrLevl6OrzCd().equals("") ) hrkHrNewOrzCdList.add( cb01N112VO.getHrLevl6OrzCd() );
		if( cb01N112VO.getHrLevl5OrzCd() != null && !!!cb01N112VO.getHrLevl5OrzCd().equals("") ) hrkHrNewOrzCdList.add( cb01N112VO.getHrLevl5OrzCd() );
		if( cb01N112VO.getHrLevl4OrzCd() != null && !!!cb01N112VO.getHrLevl4OrzCd().equals("") ) hrkHrNewOrzCdList.add( cb01N112VO.getHrLevl4OrzCd() );
		if( cb01N112VO.getHrLevl3OrzCd() != null && !!!cb01N112VO.getHrLevl3OrzCd().equals("") ) hrkHrNewOrzCdList.add( cb01N112VO.getHrLevl3OrzCd() );
		if( cb01N112VO.getHrLevl2OrzCd() != null && !!!cb01N112VO.getHrLevl2OrzCd().equals("") ) hrkHrNewOrzCdList.add( cb01N112VO.getHrLevl2OrzCd() );
		if( cb01N112VO.getHrLevl1OrzCd() != null && !!!cb01N112VO.getHrLevl1OrzCd().equals("") ) hrkHrNewOrzCdList.add( cb01N112VO.getHrLevl1OrzCd() );

		/* 상위 인사조직코드 리스트 -> 상위 조직코드 리스트 */
		List<String> hrkOrzCdList = new ArrayList<>();
		for( String hrkHrNewOrzCd : hrkHrNewOrzCdList ) {
			CB01N112VO hrkCb01N112VO = commonService.selectOneCB01N112ByHrNewOrzCd( hrkHrNewOrzCd );
			if( hrkCb01N112VO == null ) continue;
			String hrkOrzCd = hrkCb01N112VO.getOrzCd();
			if( !!!hrkOrzCdList.contains(hrkOrzCd) && !StringUtils.isEmpty(hrkOrzCd)) {
				hrkOrzCdList.add(hrkOrzCd);
			}
		}

		/* 상위 조직코드 리스트 -> 조직장 존재 여부 확인된 상위 조직코드 리스트 */
		List<Map<String,String>> filteredHrkOrzCdList = new ArrayList<>();
		for( String hrkOrzCd : hrkOrzCdList ) {
			CB01N210VO hrkCb01N210 = commonService.selectOneCB01N210ByOrzCd( hrkOrzCd );
			if( hrkCb01N210 == null ) continue;

			String orzRptvEpno = hrkCb01N210.getOrzRptvEpno();
			if( orzRptvEpno != null && !!!orzRptvEpno.equals("") ) {
				
				/* 추후 제외조건을 공통코드화 */
				/* 현재 하드코딩한 제외조건: WM팀장(82), 대표이사(01), 사외이사(B8) */
				List<String> exceptHrOsdtCd = Arrays.asList(new String[]{"82", "01", "B8"});
				CB01N310VO rptvCb01n310 = commonService.selectOneCB01N310ByEpno( orzRptvEpno );
				if( exceptHrOsdtCd.contains(rptvCb01n310.getHrOsdtCd()) ) continue;
				
				HashMap<String, String> rtnMap = new HashMap<String,String>();
				rtnMap.put("orzCd", hrkOrzCd);
				rtnMap.put("orzNm", hrkCb01N210.getOrzNm());
				
				rtnMap.put("epno", rptvCb01n310.getEpno());
				rtnMap.put("epNm", rptvCb01n310.getEpNm());
				
				rtnMap.put("hrOsdtCd", rptvCb01n310.getHrOsdtCd());
				if(!StringUtils.isBlank(rptvCb01n310.getHrOsdtCdNm())){
					rtnMap.put("hrOsdtCdNm", rptvCb01n310.getHrOsdtCdNm().replace("(실)", ""));
				} 
				
				filteredHrkOrzCdList.add( rtnMap );
			}
		}

		return filteredHrkOrzCdList;
	}
	
	/*****************************************************************************
	 *	1. 메 소 드 명	: rqsWtdw
	 *  2. 기      능	: 일반신청 회수[2024.03.08]
	 *	3. 주 요 사 항	: 1. 접수번호 유지
	 *                2. [공사,렌탈,문서] 팀장 승인전
	 *                3. [인감] 사전참조 확인전
	 *                4. 상태: 승인중 -> 임시저장 수정
	 ****************************************************************************/
	@Override
	public int rqsWtdw(RQAM1000U0In02VO vo) {
		int mCnt = 0;
		
		String rctNo = vo.getRctNo();
		// 입력값 체크
		{
			if( rctNo == null || rctNo.equals("")) {
	            throw new CustomBadRequestException("접수번호를 확인하세요 rctNo["+rctNo+"]", ErrorCode.BAD_REQUEST);		
			}
		}

		// 회수가능여부 조회
		RQAM1000U0Out01VO rtnVo = RQAM1000U0Dao.selectGA01N101Wtdw(rctNo);
		
		// 조회결과
		if(rtnVo == null) {
			throw new CustomBadRequestException("회수 대상이 존재하지 않습니다. 접수번호를 확인하세요["+rctNo+"]", ErrorCode.BAD_REQUEST);	
		}
		
		// 신청상태: 05 승인중
		if ( !rtnVo.getRqsScd().equals("05")) {
            throw new CustomBadRequestException("신청상태를 확인하세요 [승인중]일경우 회수가능합니다. ["+rctNo+"]["+rtnVo.getRqsScd()+"]", ErrorCode.BAD_REQUEST);		
		}
		
		// 팀장 결재전 가능
		if(!StringUtils.isBlank(rtnVo.getAprvRtrnTcd())) {
			throw new CustomBadRequestException("신청팀장 승인전 회수가능합니다. ["+rctNo+"]["+rtnVo.getRqsScd()+"]", ErrorCode.BAD_REQUEST);		
		}
		
		// [인감날인증명서] 사전참조 결재전 가능
		if("05".equals(rtnVo.getUnifRqsPcd())
			&& !StringUtils.isBlank(rtnVo.getAprvRtrnTcdRef())) {
			throw new CustomBadRequestException("사전참조 확인전일경우 회수가능합니다. ["+rctNo+"]["+rtnVo.getRqsScd()+"]", ErrorCode.BAD_REQUEST);		
		}
		
		// 상태: 05 승인중-> 00 임시저장 업데이트
		{
			GA01N101VO wtdwVo = new GA01N101VO();
			wtdwVo.setRctNo(rctNo);
			wtdwVo.setRqsScd("00");
			RQAM1000U0Dao.updateAprvRqsScd(wtdwVo);
		}
		return mCnt;
	}
}
