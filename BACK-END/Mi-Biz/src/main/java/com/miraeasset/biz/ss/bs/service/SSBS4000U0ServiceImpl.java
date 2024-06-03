/*******************************************************************************************************
* 	01. 프 로 젝 트 명	: 총무포털
*	02. 업 무 구 분 명	: SS
*	03. 파    일   명	: SSBS4000U0Service.java
*	04. 작  성  일  자	: 2023.10.05
*	05. 작   성   자	: LKM
*	06. 관 련 기 능	: 포털관리 메뉴관리 ServiceImpl
*	07. 주  요  사  항	: 키값 조회
*******************************************************************************************************/
package com.miraeasset.biz.ss.bs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.meta.vo.GA09N203VO;
import com.miraeasset.biz.common.util.ObjectCopyUtil;
import com.miraeasset.biz.common.util.aprvWrrpt.AprvWrrpt;
import com.miraeasset.biz.rq.sr.dao.RQSR1000U0Dao;
import com.miraeasset.biz.ss.bs.dao.SSBS1000V0Dao;
import com.miraeasset.biz.ss.bs.dao.SSBS4000U0Dao;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0In02VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS4000U0Out01VO;

@Service
@Transactional
public class SSBS4000U0ServiceImpl implements SSBS4000U0Service {
	
	@Autowired
	SSBS4000U0Dao SSBS4000U0Dao;
	
	@Autowired
	RQSR1000U0Dao RQSR1000U0Dao;
	
	@Autowired
	CommonDao CommonDao;	
	
	@Autowired
	CodeDao CodeDao;
	
	@Autowired
	AprvWrrpt aprvWrrpt;		
	
	private final String PSIT_MENU_ID_92 = "SSBS7000m0";
	private final String PSIT_MENU_ID_91 = "SSBS7100m0";

	/* RQS_CD 코드값 정의 */
	private final String CD_RQS_SCD_TMP_STRG = "00"; // 임시저장 
	private final String CD_RQS_SCD_APV_ING  = "05"; // 승인중 
	private final String CD_RQS_SCD_APV_CMPN = "10"; // 승인완료 
	private final String CD_RQS_SCD_CMPN     = "99"; // 완료 
	private final String CD_RQS_SCD_RTRN     = "30"; // 반려
	private final String CD_RQS_SCD_WDRAL    = "35"; // 철회
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
		

	/* 메뉴관리 목록조회 */
	@Override
	public List<SSBS4000U0Out00VO> selectListGA09N203(SSBS4000U0In00VO vo) {
		// TODO Auto-generated method stub
		return SSBS4000U0Dao.selectListGA09N203(vo);
	}		
	
    /* 메뉴관리 상세조회 PK */
	@Override
	public SSBS4000U0Out01VO selectGA09N203PK(SSBS4000U0In01VO vo)  {
		// TODO Auto-generated method stub
		GA09N203VO GA09N203VO = new GA09N203VO();
		SSBS4000U0Out01VO outVo = new SSBS4000U0Out01VO();
		ObjectCopyUtil.copyFields(vo, GA09N203VO);
		GA09N203VO = SSBS4000U0Dao.selectGA09N203PK(GA09N203VO);
		
		ObjectCopyUtil.copyFields(GA09N203VO, outVo);
		return outVo;
	}
	
	/* 메뉴관리 신규등록 */	
	@Override
	public int insertGA09N203(SSBS4000U0In02VO vo) {
		String psitMenuId   = null;  /*매뉴ID*/    
		String menuNm       = null;  /*메뉴명          */    
		String psitScrnId   = null;  /*화면ID */
		String hrkMenuId    = null;  /*상위메뉴ID      */    
		String urlAdr       = null;  /*URL주소         */    
		String useYn        = null;  /*사용여부        */    
		String scrnOputSqn  = null;  /*화면출력순서    */    
		String menuDpthVl   = null;  /*메뉴깊이값      */    
	
		GA09N203VO GA09N203VO = null; /* 메뉴관리 */
		List<GA09N203VO> dataSqnListVo = null;		
		
		int cnt = 0;
		int mCnt = 0;
		
		// 전처리 : 입력값 체크
		{
			//psitMenuId   = vo.getPsitMenuId();/*포털사이트메뉴ID*/          
			menuNm       = vo.getMenuNm();  /*메뉴명          */        
			hrkMenuId    = vo.getHrkMenuId();  /*상위메뉴ID      */        
			urlAdr       = vo.getUrlAdr();  /*URL주소         */        
			useYn        = vo.getUseYn();  /*사용여부        */        
			scrnOputSqn  = vo.getScrnOputSqn();  /*화면출력순서    */        
			//menuDpthVl   = vo;  /*메뉴깊이값      */        
			psitScrnId   = vo.getPsitScrnId();   /*화면id*/         
			
			// 입력값 체크
			{
				// 메뉴명 필수 체크
				if(menuNm == null || "".equals(menuNm) ) {
			        throw new CustomBadRequestException("필수입력항목 메뉴관리[메뉴명] 오류. 입력값을 확인하세요["+menuNm+"]", ErrorCode.BAD_REQUEST);		
				}
				
				// 화면출력순서 필수 체크
				if(scrnOputSqn == null || "".equals(scrnOputSqn) ) {
			        throw new CustomBadRequestException("필수입력항목 메뉴관리[화면출력순서] 오류. 입력값을 확인하세요["+scrnOputSqn+"]", ErrorCode.BAD_REQUEST);		
				}				
			}

			// 기등록 중복 체크
			if(false){
				GA09N203VO = new GA09N203VO();
				ObjectCopyUtil.copyFields(vo, GA09N203VO);
				
				GA09N203VO = SSBS4000U0Dao.selectGA09N203PK(GA09N203VO);
				
				if(GA09N203VO != null) {
			        throw new CustomBadRequestException("신규등록 대상건이 이미 존재합니다. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
				}
			}
		}

		// 신규등록 처리
		{
			
			
			// 메뉴ID 신규 채번
			{
				GA09N203VO = SSBS4000U0Dao.selectNewMenuIdGA09N203();
				psitMenuId = GA09N203VO.getPsitMenuId();
				log.info("메뉴ID 채번 ["+psitMenuId+"] ");
			}

			GA09N203VO = new GA09N203VO();

			// 메뉴관리 신규등록
			{
				ObjectCopyUtil.copyFields(vo, GA09N203VO);			
				GA09N203VO.setPsitMenuId(psitMenuId);
				
				cnt = SSBS4000U0Dao.insertGA09N203(GA09N203VO);
				
				if(cnt <= 0) {
			        throw new CustomBadRequestException("신규등록(insert) 오류. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
				}
			}
			
			// 메뉴깊이depth 조회
			{
				GA09N203VO.setPsitMenuId(psitMenuId);				
				GA09N203VO = SSBS4000U0Dao.selectGA09N203PK(GA09N203VO);
				
				menuDpthVl = GA09N203VO.getMenuDpthVl();

			}
			
			// 화면출력순서 재설정
			{
				ObjectCopyUtil.copyFields(vo, GA09N203VO);
				GA09N203VO.setPsitMenuId(psitMenuId);
				GA09N203VO.setMenuDpthVl(menuDpthVl);
				GA09N203VO.setStrtScrnOputSqn(scrnOputSqn);
				GA09N203VO.setEndScrnOputSqn("100");
				
				boolean upYn = false; // 신규추가데이터 이후건 1단게 DOWN
				
				dataSqnListVo = SSBS4000U0Dao.selectListGA09N203NewSqn(GA09N203VO);
				
				for(int i=0;i<dataSqnListVo.size();i++) {
					GA09N203VO = dataSqnListVo.get(i);
					GA09N203VO.setScrnOputSqn(GA09N203VO.getDownScrnOputSqn()); // 화면출력순서 하위출력순서세팅
					mCnt = SSBS4000U0Dao.updateGA09N203NewSqn(GA09N203VO);
				}
				
			}
			


		}

		return cnt;
	}	  
	
	/* 메뉴관리 수정 */	
	@Override
	public int updateGA09N203(SSBS4000U0In02VO vo) {
		String psitMenuId   = null;  /*메뉴ID*/    
		String menuNm       = null;  /*메뉴명          */    
		String hrkMenuId    = null;  /*상위메뉴ID      */    
		String urlAdr       = null;  /*URL주소         */    
		String useYn        = null;  /*사용여부        */    
		String scrnOputSqn  = null;  /*화면출력순서    */    
		String scrnOputSqnBf  = null;  /*화면출력순서-변경전    */    
		String menuDpthVl   = null;  /*메뉴깊이값      */    
		String psitScrnId   = null;   /*화면id*/             
	
		GA09N203VO GA09N203VO = null; /* 메뉴관리 */
		List<GA09N203VO> dataSqnListVo = null;		
		
		int cnt = 0;
		int mCnt = 0;
		
		// 전처리 : 입력값 체크
		{
			
			psitMenuId   = vo.getPsitMenuId();/*메뉴ID*/          
			menuNm       = vo.getMenuNm();  /*메뉴명          */        
			hrkMenuId    = vo.getHrkMenuId();  /*상위메뉴ID      */        
			urlAdr       = vo.getUrlAdr();  /*URL주소         */        
			useYn        = vo.getUseYn();  /*사용여부        */        
			scrnOputSqn  = vo.getScrnOputSqn();  /*화면출력순서    */        
			//menuDpthVl   = vo.getMenuDpthVl();  /*메뉴깊이값      */        
			psitScrnId   = vo.getPsitScrnId();   /*화면id*/         
			
			// 입력값 체크
			{
				// 포털사이트메뉴ID 필수 체크
				if(psitMenuId == null || "".equals(psitMenuId) ) {
			        throw new CustomBadRequestException("필수입력항목 메뉴관리[포털사이트메뉴ID] 오류. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
				}
				
				// 메뉴명 필수 체크
				if(menuNm == null || "".equals(menuNm) ) {
			        throw new CustomBadRequestException("필수입력항목 메뉴관리[메뉴명] 오류. 입력값을 확인하세요["+menuNm+"]", ErrorCode.BAD_REQUEST);		
				}
				
				// 화면출력순서 필수 체크
				if(scrnOputSqn == null || "".equals(scrnOputSqn) ) {
			        throw new CustomBadRequestException("필수입력항목 메뉴관리[화면출력순서] 오류. 입력값을 확인하세요["+scrnOputSqn+"]", ErrorCode.BAD_REQUEST);		
				}		


			}

			// 기등록 중복 체크 
			{
				GA09N203VO = new GA09N203VO();
				ObjectCopyUtil.copyFields(vo, GA09N203VO);
				
				GA09N203VO = SSBS4000U0Dao.selectGA09N203PK(GA09N203VO);
				
				if(GA09N203VO == null) {
			        throw new CustomBadRequestException("수정 대상건이 존재하지않습니다. 입력값을 확인하세요 메뉴id["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
				}
				// 메뉴depth
				menuDpthVl = GA09N203VO.getMenuDpthVl();
				// 변경전 화면출력순서
				scrnOputSqnBf = GA09N203VO.getScrnOputSqn();
			}
		}

		// 수정 처리
		{
			
			
			GA09N203VO = new GA09N203VO();
			int scrnOputSqnBfInt = Integer.parseInt(scrnOputSqnBf);
			int scrnOputSqnInt = Integer.parseInt(scrnOputSqn);
			
			log.info("scrnOputSqnBfInt ["+scrnOputSqnBfInt+"] scrnOputSqnInt["+scrnOputSqnInt+"]");
			
			// 화면출력순서 재설정
			{
				// 화면출력순서 변경일경우
				if(scrnOputSqnBfInt != scrnOputSqnInt) {
					
					log.info("=============> 화면출력순서 변경일경우");
					ObjectCopyUtil.copyFields(vo, GA09N203VO);
					GA09N203VO.setMenuDpthVl(menuDpthVl);
					
					log.info("=============> ["+GA09N203VO.getScrnOputSqn()+"]");
					boolean upYn = false;
					
					// 변경후 화면출력순서가 변경전 화면출력순서보다 작을경우 
					if(scrnOputSqnInt < scrnOputSqnBfInt) {
						upYn = false;
						GA09N203VO.setStrtScrnOputSqn(scrnOputSqnInt+"");
						GA09N203VO.setEndScrnOputSqn(scrnOputSqnBfInt+"");
						// 구간데이터 1단계 UP
						dataSqnListVo = SSBS4000U0Dao.selectListGA09N203NewSqn(GA09N203VO);
						
					}else {
						upYn = true;
						GA09N203VO.setStrtScrnOputSqn(scrnOputSqnBfInt+"");
						GA09N203VO.setEndScrnOputSqn(scrnOputSqnInt+"");
						// 구간데이터 1단계 DOWN
						dataSqnListVo = SSBS4000U0Dao.selectListGA09N203NewSqn(GA09N203VO);
						
					}

					for(int i=0;i<dataSqnListVo.size();i++) {
						GA09N203VO = dataSqnListVo.get(i);
						if(upYn) {
							GA09N203VO.setScrnOputSqn(GA09N203VO.getUpScrnOputSqn());
						}else {
							GA09N203VO.setScrnOputSqn(GA09N203VO.getDownScrnOputSqn());
						}
						mCnt = SSBS4000U0Dao.updateGA09N203NewSqn(GA09N203VO);
					}
					
				}
			}
			
			// 메뉴관리 수정처리
			{
				ObjectCopyUtil.copyFields(vo, GA09N203VO);	
				cnt = SSBS4000U0Dao.updateGA09N203(GA09N203VO);
				
				if(cnt <= 0) {
			        throw new CustomBadRequestException("수정처리(update) 오류. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
				}
			}
			
			
		}

		return cnt;
	}	 	
	
	/* 메뉴관리 삭제 */	
	@Override
	public int deleteGA09N203(SSBS4000U0In01VO vo) {
		String psitMenuId   = null;  /*메뉴ID*/    
		String scrnOputSqn  = null;  /*화면출력순서    */    
		String hrkMenuId    = null;  /*상위메뉴ID      */    
		String menuDpthVl   = null;  /*메뉴깊이값      */    

		GA09N203VO GA09N203VO = null; /* 메뉴관리 */
		List<GA09N203VO> dataSqnListVo = null;		
		
		int cnt = 0;
		int mCnt = 0;
		
		// 전처리 : 입력값 체크
		{
			
			psitMenuId   = vo.getPsitMenuId();/*메뉴ID*/          

			// 포털사이트메뉴ID 필수 체크
			if(psitMenuId == null || "".equals(psitMenuId) ) {
		        throw new CustomBadRequestException("필수입력항목 메뉴관리[메뉴ID] 오류. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
			}
			
			// 대상기 기등록 체크
			{
				GA09N203VO = new GA09N203VO();
				ObjectCopyUtil.copyFields(vo, GA09N203VO);
				
				GA09N203VO = SSBS4000U0Dao.selectGA09N203PK(GA09N203VO);
				
				if(GA09N203VO == null) {
			        throw new CustomBadRequestException("삭제 대상건이 존재하지않습니다. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
				}
				
				scrnOputSqn  = GA09N203VO.getScrnOputSqn();
				hrkMenuId    = GA09N203VO.getHrkMenuId();  /*상위메뉴ID      */    
				menuDpthVl   = GA09N203VO.getMenuDpthVl();  /*메뉴깊이값      */    				
			}
			
			// 하위메뉴 존재여부 체크
			{
				
				GA09N203VO = new GA09N203VO();
				GA09N203VO.setHrkMenuId(psitMenuId);
				GA09N203VO.setPsitMenuId(psitMenuId);
				GA09N203VO.setMenuDpthVl((Integer.parseInt(menuDpthVl) + 1)+"");
				GA09N203VO.setStrtScrnOputSqn("0");
				GA09N203VO.setEndScrnOputSqn("100");
				
				dataSqnListVo = SSBS4000U0Dao.selectListGA09N203NewSqn(GA09N203VO);
				
				if(dataSqnListVo !=null && dataSqnListVo.size() > 0) {
			        throw new CustomBadRequestException("삭제처리(delete) 대상건 하위메뉴가 존재합니다. 하위메뉴를 모두 삭제하고 대상건 삭제가능합니다.["+dataSqnListVo.size()+"]", ErrorCode.BAD_REQUEST);		
				}
		
			}
		}

		// 삭제 처리
		{
			GA09N203VO = new GA09N203VO();

			// 화면출력순서 재설정
			{
				// 삭제대상 화면출력순서 이전순서 가져요기
				ObjectCopyUtil.copyFields(vo, GA09N203VO);
				GA09N203VO.setStrtScrnOputSqn(scrnOputSqn);
				GA09N203VO.setHrkMenuId(hrkMenuId);
				GA09N203VO.setMenuDpthVl(menuDpthVl);
				GA09N203VO.setEndScrnOputSqn("100");
				
				boolean upYn = true; // 삭제데이터 이후건 1단게 UP
				
				dataSqnListVo = SSBS4000U0Dao.selectListGA09N203NewSqn(GA09N203VO);
				
				for(int i=0;i<dataSqnListVo.size();i++) {
					GA09N203VO = dataSqnListVo.get(i);
					if(upYn) {
						GA09N203VO.setScrnOputSqn(GA09N203VO.getUpScrnOputSqn());
					}else {
						GA09N203VO.setScrnOputSqn(GA09N203VO.getDownScrnOputSqn());
					}					
					mCnt = SSBS4000U0Dao.updateGA09N203NewSqn(GA09N203VO);
				}
			}
			
			// 메뉴관리 삭제처리
			{
				ObjectCopyUtil.copyFields(vo, GA09N203VO);			
				cnt = SSBS4000U0Dao.deleteGA09N203(GA09N203VO);
				
				if(cnt <= 0) {
			        throw new CustomBadRequestException("삭제처리(delete) 오류. 입력값을 확인하세요["+psitMenuId+"]", ErrorCode.BAD_REQUEST);		
				}
			}

		}

		return cnt;
	}	 		
	
 
	
}
