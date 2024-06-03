package com.miraeasset.biz.rq.sr.service;

import com.miraeasset.biz.common.code.service.CodeService;
import com.miraeasset.biz.common.code.vo.UserCode00In00VO;
import com.miraeasset.biz.common.code.vo.UserCode00Out00VO;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.rq.sr.vo.RQSRSchedule1000U1Out00VO;
import com.miraeasset.biz.ss.bs.service.SSBS5000U0Service;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS5000U0Out01VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RQSRSchedule1000U3Service {

    @Autowired
    RQSRSchedule1000U0Service rqsrSchedule1000U0Service; /* 메서드 재사용을 위함 */

    @Autowired
    RQSRSchedule1000U1Service rqsrSchedule1000U1Service; /* 총무팀장 획득하기 위해 사용 */


    /* 1. 발송 대상 RCT_NO 확인 */
    /* rqsrSchedule1000U0Service.findTargetRctNoList */

    /* 2. 총무팀장 획득 */
    /* rqsrSchedule1000U1Service.findRptvEpInfoByOrzCd */

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
            if (checkBzD5Yn) {
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

                /* 2. 총무팀장 획득 */
                RQSRSchedule1000U1Out00VO rqsrSchedule1000U1Out00VO = rqsrSchedule1000U1Service.findRptvEpInfoByOrzCd("S03001");

                /* 3. 발송 메시지 생성 */
                /*
                [Mi-support]
                총무팀장님
                인장담당자가 증명서 미등록 내역을 확인했는지 점검이 필요해요.

                ▶ #{만료일} 만료예정 건수 : #{만료일 미처리건수} 건
                ▶ #{만료일+1} 만료 건수 : #{만료일+1 미처리건수} 건 */
                String strIprtMsgCd = "GA0081";

                String expireDate_1 = DateUtil.getAddDay(targetDate_1, 7);
                String expireDate_2 = DateUtil.getAddDay(targetDate_2, 7);

                String formatted_targetDate_1 = expireDate_1.substring(0, 4) + "-" + expireDate_1.substring(4, 6) + "-" + expireDate_1.substring(6, 8);
                String formatted_targetDate_2 = expireDate_2.substring(0, 4) + "-" + expireDate_2.substring(4, 6) + "-" + expireDate_2.substring(6, 8);

                List<String> replaceStringList = new ArrayList<>();
                replaceStringList.add(formatted_targetDate_1); /* 만료일 */
                replaceStringList.add(String.valueOf(rctNoList_1.size())); /* 만료일 미처리건수 */
                replaceStringList.add(formatted_targetDate_2); /* 만료일+1 */
                replaceStringList.add(String.valueOf(rctNoList_2.size())); /* 만료일+1 미처리건수 */
                String strMsgSndCn = rqsrSchedule1000U0Service.makeMsgSndCn(strIprtMsgCd, replaceStringList);

                /* 4. 발송대기내역에 저장 */
                String strSmsSndDt = tomorrow;
                String strSmsSndTmd = "100000"; // 시, 분, 초. 10시에 발송
                String strOrzCd = rqsrSchedule1000U1Out00VO.getOrzCd();
                String strEpno = rqsrSchedule1000U1Out00VO.getEpno();
                String strRctNo = null;
                rqsrSchedule1000U0Service.insertGA09N503(strIprtMsgCd, strMsgSndCn, strSmsSndDt, strSmsSndTmd, strOrzCd, strEpno, strRctNo, null);
            }
        } catch (Exception e) {
            throw new CustomBadRequestException(e.getMessage(), ErrorCode.BAD_REQUEST);
        }
    }

}

