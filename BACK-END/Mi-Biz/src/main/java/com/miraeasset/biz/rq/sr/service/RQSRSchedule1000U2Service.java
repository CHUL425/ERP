package com.miraeasset.biz.rq.sr.service;

import com.miraeasset.biz.common.code.service.CodeService;
import com.miraeasset.biz.common.code.vo.UserCode00In00VO;
import com.miraeasset.biz.common.code.vo.UserCode00Out00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.rq.sr.vo.RQSRSchedule1000U0Out00VO;
import com.miraeasset.biz.rq.sr.vo.RQSRSchedule1000U1Out00VO;
import com.miraeasset.biz.ss.bs.service.SSBS5000U0Service;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out01VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RQSRSchedule1000U2Service {
    @Autowired
    RQSRSchedule1000U0Service rqsrSchedule1000U0Service; /* 메서드 재사용을 위함 */
    @Autowired
    SSBS5000U0Service ssbs5000U0Service; /* 화면관리 서비스 */

    @Autowired
    CodeService codeService; /* 인감날인 담당자 조직코드 확인하기 위해 사용 */

    /* 1. 발송 대상 RCT_NO 확인 */
    /* rqsrSchedule1000U0Service.findTargetRctNoList */

    /* 2. 인장날인담당자명 획득 */
    /* SSBS5000U0Service.selectGA09N204 */

    /* 3. 발송 메시지 생성 */
    /* rqsrSchedule1000U0Service.makeMsgSndCn */

    /* 4. 발송대기내역에 저장 */
    /* rqsrSchedule1000U0Service.insertGA09N503 */

    /* 메인 프로세스 */
    public void mainProc() {
        try {
            /* 발송일(대기내역 생성 다음날)이 영업일이 아니면 발송대기내역 생성하지 않음 */
            String tomorrow = DateUtil.getTomorrow();
            boolean checkBzD5Yn = CommonUtil.checkBzD5Yn(tomorrow);
            if(checkBzD5Yn) {
                /* 1. 발송 대상 RCT_NO 확인 */
                /* 발급일 포함 7일 전(예: 오늘 날짜가 2023-01-07 -> 2023-01-01) */
                String today = DateUtil.getDate();
                String targetDate_1 = DateUtil.getAddDay(today, -6);
                String targetDate_2 = DateUtil.getAddDay(today, -5);
                List<String> rctNoList_1 = rqsrSchedule1000U0Service.findTargetRctNoList(targetDate_1);
                List<String> rctNoList_2 = rqsrSchedule1000U0Service.findTargetRctNoList(targetDate_2);

                /* 만료 예정건수 없으므로 return */
                if(rctNoList_1.size() + rctNoList_2.size() <= 0) {
                    return;
                }

                /* 2. 인장날인담당자명 획득 */
                SSBS5000U0In01VO ssbs5000U0In01VO = new SSBS5000U0In01VO("RQAM3000m0"); // 인감날인&증명서 승인관리 화면ID
                SSBS5000U0Out01VO ssbs5000U0Out01VO = ssbs5000U0Service.selectGA09N204(ssbs5000U0In01VO);

                /* 3. 발송 메시지 생성 */
                /*
                [Mi-support]
                #{총무팀인장날인담당자명} #{직위명}님
                ▶ #{만료일} 만료예정 건수 : #{만료일 미처리건수} 건
                ▶ #{만료일+1} 만료 건수 : #{만료일+1 미처리건수} 건

                증명서 미등록 내역의 확인이 필요해요.*/
                String strIprtMsgCd = "GA0071";

                String expireDate_1 = DateUtil.getAddDay(targetDate_1, 7);
                String expireDate_2 = DateUtil.getAddDay(targetDate_2, 7);

                String formatted_targetDate_1 = expireDate_1.substring(0,4) + "-" + expireDate_1.substring(4,6) + "-" + expireDate_1.substring(6,8);
                String formatted_targetDate_2 = expireDate_2.substring(0,4) + "-" + expireDate_2.substring(4,6) + "-" + expireDate_2.substring(6,8);

                List<String> replaceStringList = new ArrayList<>();
                replaceStringList.add(ssbs5000U0Out01VO.getEpNm1()); /* 총무팀인장날인담당자명 */
                String rqsHrOsdtPstNm = CommonUtil.findHrOsdtCdNmOrHrPstCdNmByEpno(ssbs5000U0Out01VO.getEpno1()); /* 직책직위명 획득 */
                replaceStringList.add(rqsHrOsdtPstNm); /* 직위명 */
                replaceStringList.add(formatted_targetDate_1); /* 만료일 */
                replaceStringList.add(String.valueOf(rctNoList_1.size())); /* 만료일 미처리건수 */
                replaceStringList.add(formatted_targetDate_2); /* 만료일+1 */
                replaceStringList.add(String.valueOf(rctNoList_2.size())); /* 만료일+1 미처리건수 */
                String strMsgSndCn = rqsrSchedule1000U0Service.makeMsgSndCn(strIprtMsgCd, replaceStringList);

                /* 4. 발송대기내역에 저장 */
                UserCode00In00VO userCode00In00VO = new UserCode00In00VO();
                userCode00In00VO.setEpNm(ssbs5000U0Out01VO.getEpno1());
                UserCode00Out00VO userCode00Out00VO = codeService.selectListUserCode00(userCode00In00VO).get(0);

                String strSmsSndDt = tomorrow;
                String strSmsSndTmd = "100000"; // 시, 분, 초. 10시에 발송
                String strOrzCd = userCode00Out00VO.getOrzCd();
                String strEpno = ssbs5000U0Out01VO.getEpno1();
                String strRctNo = null;
                rqsrSchedule1000U0Service.insertGA09N503(strIprtMsgCd, strMsgSndCn, strSmsSndDt, strSmsSndTmd, strOrzCd, strEpno, strRctNo, null);
            }
        } catch (Exception e) {
            throw new CustomBadRequestException(e.getMessage(), ErrorCode.BAD_REQUEST);
        }
    }

}
