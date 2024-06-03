package com.miraeasset.biz.common.service;

import com.miraeasset.biz.common.code.service.CodeService;
import com.miraeasset.biz.common.code.vo.GaCode01In00VO;
import com.miraeasset.biz.common.code.vo.GaCode01Out00VO;
import com.miraeasset.biz.common.dao.CommonDao;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.altok.AltokService;
import com.miraeasset.biz.common.util.altok.vo.AltokOut01VO;
import com.miraeasset.biz.common.util.massage.MsgSenService;
import com.miraeasset.biz.common.vo.GA09N503In00VO;
import com.miraeasset.biz.common.vo.GA09N503VO;
import com.miraeasset.biz.ss.zs.service.SSZS2000U0Service;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In01VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0Out01VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonScheduleService {
    @Value("${SYSTEM_NAME}")
    private String SYSTEM_NAME;

    @Autowired
    CommonDao commonDao;
    @Autowired
    SSZS2000U0Service sszs2000U0Service;
    @Autowired
    MsgSenService msgSenService;
    @Autowired
    AltokService altokService;
    @Autowired
    CodeService codeService;

    /* GA09N503 내역 발송 */
    public void sendScheduledMessage() {
        String today = DateUtil.getDate(); // 오늘 날짜
        List<GA09N503VO> ga09N503VOList; // 발송대상 리스트를 담는 객체

        /* 1. 발송 대상 확인 */
        GA09N503In00VO ga09N503In00VO = new GA09N503In00VO();
        ga09N503In00VO.setSmsSndDt(today);
        ga09N503In00VO.setSndYn("0");
        ga09N503VOList = commonDao.selectListGA09N503(ga09N503In00VO);

        for(GA09N503VO ga09N503VO : ga09N503VOList) {
            /* 2. 발송 매체(MSG_SND_MDA_TCD)에 따른 분류 */
            SSZS2000U0Out01VO sszs2000U0Out01VO = sszs2000U0Service.selectGA09N501(new SSZS2000U0In01VO(ga09N503VO.getIprtMsgCd())); /* IPRT_MSG_CD를 통해 GA09N501 획득 */
            String msgSndMdaTcd = sszs2000U0Out01VO.getMsgSndMdaTcd(); /* 발송매체구분코드 */

            String receiveEpno = ga09N503VO.getEpno(); /* 수신 사원번호 */
            String receiveOrzCd = ga09N503VO.getOrzCd(); /* 수신 조직코드 */
            String msgSndCn = ga09N503VO.getMsgSndCn(); /* 메시지 내용 */
            String rctNo = ga09N503VO.getRctNo(); /* 신청번호 */
            String iprtMsgCd = sszs2000U0Out01VO.getIprtMsgCd(); /* 메시지 코드 */
            String iprtMsgTtlNm = sszs2000U0Out01VO.getIprtMsgTtlNm(); /* 메시지 제목명 */

            String receiveTlno = CommonUtil.getEpTlno(receiveEpno); /* 수신 사원 전화번호(평문) */
            String sendTlno = "15886800";

            /* 로컬, 개발, 테스트 환경에서는 내 번호로 발송 */
            //if(SYSTEM_NAME.equals("local") || SYSTEM_NAME.equals("dev") || SYSTEM_NAME.equals("test")) {
                //receiveTlno = "01076297512"; // 경영시스템팀 이정준 [20240405]삭제 요청
            //	receiveTlno = "01062530011";
            //}

            AltokOut01VO altokOut01VO; /* 알림톡 결과 저장 */

            GaCode01In00VO gaCode01In00VO = new GaCode01In00VO();
            gaCode01In00VO.setCdKndNo("ALTOK_MAP_CD"); // 알림톡 매핑 코드. GA09N501.IPRT_MSG_CD -> CS02C071.LETR_MSG_CD
            gaCode01In00VO.setCmnCdVl(iprtMsgCd);
            List<GaCode01Out00VO> ga09C302VOList = codeService.selectListGaCode01(gaCode01In00VO);
            String letrMsgCd = ga09C302VOList.size() > 0 ? ga09C302VOList.get(0).getCmnCdVlDefCn() : null;

            LoginOutVO loginOutVOForLogging = new LoginOutVO();
            loginOutVOForLogging.setOptrId("BATCH");
            loginOutVOForLogging.setOprtOrzCd("000000");
            loginOutVOForLogging.setOprtChnlCd("000");
            loginOutVOForLogging.setOprtIpAdr("0.0.0.0");

            /* 3. 발송 및 로깅(종모양) */
            switch (msgSndMdaTcd) {
                case "01": /* 메신저-알림 */
                    /* 메신저 발송 로직에 로깅 포함돼있어서 로깅 따로 안함 */
                    //if( SYSTEM_NAME.equals("local") || SYSTEM_NAME.equals("dev") || SYSTEM_NAME.equals("test") ) {
                        //receiveEpno = "3360135"; // [20240405]삭제 요청
                    //    receiveEpno = null;
                    //}
                        msgSenService.sendMessageAsync("", receiveEpno, iprtMsgTtlNm, msgSndCn, "", "Mi-support", iprtMsgCd, receiveOrzCd, receiveEpno, rctNo, "");
                    break;
                case "02": /* 메신저-쪽지 */
                    break;
                case "03": /* 메일 */
                    break;
                case "04": /* 알림톡 */
                    /* 알림톡코드 - 우리쪽 코드 간 매핑 필요함 */
                    altokOut01VO = altokService.sendAltok(letrMsgCd, msgSndCn, sendTlno, receiveTlno);

                    // 개발, 검증 테스트
                    //if( SYSTEM_NAME.equals("local") || SYSTEM_NAME.equals("dev") || SYSTEM_NAME.equals("test") ) { }
                    

                    String sndRsltMsgCn = altokOut01VO != null ? altokOut01VO.getSndRsltMsgCn() : "";
                    CommonUtil.insertGA09N502(iprtMsgCd, msgSndCn, receiveOrzCd, receiveEpno, rctNo, sndRsltMsgCn, loginOutVOForLogging, "");
                    break;
                case "05": /* 메신저+알림톡 */
                    /* 메신저 발송 로직에 로깅 포함돼있어서 로깅 따로 안함 */
                    msgSenService.sendMessageAsync("", receiveEpno, iprtMsgTtlNm, msgSndCn, "", "Mi-support", iprtMsgCd, receiveOrzCd, receiveEpno, rctNo, "");
                    altokService.sendAltok(letrMsgCd, msgSndCn, sendTlno, receiveTlno);

                    // 개발, 검증 테스트
                    //if( SYSTEM_NAME.equals("local") || SYSTEM_NAME.equals("dev") || SYSTEM_NAME.equals("test") ) { }
                    

                    break;
                default:
            }

            /* 4. UPDATE GA09N503.SND_YN */
            ga09N503VO.setSndYn("1");
            commonDao.updateGA09N503(ga09N503VO);
        }
    }
}
