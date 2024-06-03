package com.miraeasset.biz.rq.sr.service;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.rq.sr.dao.RQSRSchedule1000U4Dao;
import com.miraeasset.biz.rq.sr.vo.RQSRSchedule1000U0Out00VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RQSRSchedule1000U4Service {

    @Autowired
    RQSRSchedule1000U4Dao rqsrSchedule1000U4Dao;

    @Autowired
    RQSRSchedule1000U0Service rqsrSchedule1000U0Service; /* 메서드 재사용을 위해 사용 */

    /* 1. 발송 대상 RCT_NO 확인 */
    public List<String> findTargetRctNoListOver(String targetDate) {
        return rqsrSchedule1000U4Dao.findTargetRctNoListOver(targetDate);
    }

    /* 2. RQS_NO를 통해 신청정보 획득 */
    /* rqsrSchedule1000U0Service.findRqsInfoByRctNo */

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
                /* 발급일 포함 8일(예: 오늘 날짜가 2023-01-08 -> 2023-01-01) */
                String today = DateUtil.getDate();
                String targetDate = DateUtil.getAddDay(today, -7);
                List<String> rctNoList = findTargetRctNoListOver(targetDate);

                for(String rctNo : rctNoList) {
                    /* 2. RQS_NO를 통해 신청정보 획득 */
                    RQSRSchedule1000U0Out00VO rqsInfo = rqsrSchedule1000U0Service.findRqsInfoByRctNo(rctNo);

                    /* 3. 발송 메시지 생성 */
                    /*
                    [Mi-support]
                    #{신청자명} #{직위명}님
                    신청명 : {#신청명}
                    증명서 사용기간이 지났어요.

                    증명서 사용내역(사용처제출or원본폐기)을 등록해주세요.

                    ※ Mi-support > 일반신청 > 인감날인&증명서신청내역
                    - 사용처제출 : 사용처 제출
                    - 원본폐기 : 미사용, 팩스 등 사용으로 원본보관분 폐기
                    */
                    String strIprtMsgCd = "GA0091";
                    List<String> replaceStringList = new ArrayList<>();
                    replaceStringList.add(rqsInfo.getRqsEpNm()); /* 신청자명 */
                    String rqsHrOsdtPstNm = CommonUtil.findHrOsdtCdNmOrHrPstCdNmByEpno(rqsInfo.getRqsEpno()); /* 직책직위명 획득 */
                    replaceStringList.add(rqsHrOsdtPstNm); /* 직위직책명 */
                    replaceStringList.add(rqsInfo.getRqsTtlNm()); /* 신청명 */
                    String strMsgSndCn = rqsrSchedule1000U0Service.makeMsgSndCn(strIprtMsgCd, replaceStringList);

                    /* 4. 발송대기내역에 저장 */
                    String strSmsSndDt = tomorrow;
                    String strSmsSndTmd = "100000"; // 시, 분, 초. 10시에 발송
                    String strOrzCd = rqsInfo.getRqsOrzCd();
                    String strEpno = rqsInfo.getRqsEpno();
                    String strRctNo = rqsInfo.getRctNo();
                    rqsrSchedule1000U0Service.insertGA09N503(strIprtMsgCd, strMsgSndCn, strSmsSndDt, strSmsSndTmd, strOrzCd, strEpno, strRctNo, null);
                }
            }
        } catch (Exception e) {
            throw new CustomBadRequestException(e.getMessage(), ErrorCode.BAD_REQUEST);
        }
    }
}
