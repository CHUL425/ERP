package com.miraeasset.biz.common.code.dao;

import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.code.vo.Code00In00VO;
import com.miraeasset.biz.common.code.vo.Code00Out00VO;
import com.miraeasset.biz.common.code.vo.Code01In00VO;
import com.miraeasset.biz.common.code.vo.Code01Out00VO;
import com.miraeasset.biz.common.code.vo.GaCode00In00VO;
import com.miraeasset.biz.common.code.vo.GaCode00Out00VO;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.code.vo.GaSrno00In00VO;
import com.miraeasset.biz.common.code.vo.GaSrno00Out00VO;
import com.miraeasset.biz.common.code.vo.TeamCode00In00VO;
import com.miraeasset.biz.common.code.vo.TeamCode00Out00VO;
import com.miraeasset.biz.common.code.vo.TeamCode01In00VO;
import com.miraeasset.biz.common.code.vo.TeamCode01Out00VO;
import com.miraeasset.biz.common.code.vo.UserCode00In00VO;
import com.miraeasset.biz.common.code.vo.UserCode00Out00VO;

public interface CodeDao {

	List<Code00Out00VO> selectListCode00(Code00In00VO vo);
	
	List<Code01Out00VO> selectListCode01(Code01In00VO vo);

	List<GaCode00Out00VO> selectListGaCode00(GaCode00In00VO vo);
	
	List<GaCode01Out00VO> selectListGaCode01(GaCode01In00VO vo);	
    
    /* 팀점코드팝업조회 */
	List<TeamCode00Out00VO> selectListTeamCode00(TeamCode00In00VO vo);	

    /* 팀점코드팝업조회(검색일자) - 사용안함 */
	List<TeamCode01Out00VO> selectListTeamCode01(TeamCode01In00VO vo);
		
    /* 사원코드팝업 조회 */
	List<UserCode00Out00VO> selectListUserCode00(UserCode00In00VO vo);
    
    /* 업무별 신규채번 조회 */    
    List<GaCode01Out00VO> selectChaebun(GaCode01In00VO vo);    
    
    /* 업무별 일련번호 채번 생성 2023.08.21 추가 */
    GaSrno00In00VO prbzSrnoGnoCrn(GaSrno00In00VO vo);
    
    /* 업무별 관리항목 조회 */    
    List<GaCode01Out00VO> selectBzMtCode(GaCode01In00VO vo);        

    /* 업무별 관리항목 수정 */    
    int updateBzMtCode(GaCode01In00VO vo);     
    
    /* 업무별 신규채번 수정 */    
    int updateChaebun(GaCode01In00VO vo);

    List<GaCode00Out00VO> selectListAtCode00(GaCode00In00VO vo);

    List<GaCode01Out00VO> selectListAtCode01(GaCode01In00VO vo);


    /* 알림 전송에 사용 할 메시지 조회 */
    Map<String, Object> selectMsgEnrollNotiTxt(Map<String, Object> map);


    GaCode01Out00VO selectGA09C302OrderRandom1Row(GaCode01In00VO vo);
}
