package com.miraeasset.biz.rq.sr.service;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.rq.sr.dao.RQSRSchedule1000U1Dao;
import com.miraeasset.biz.rq.sr.vo.RQSRSchedule1000U0Out00VO;
import com.miraeasset.biz.rq.sr.vo.RQSRSchedule1000U1Out00VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * GA0061
 * 인감날인&증명서 만료일 당일에 신청자의 팀장에게 보낼 메시지를 전날 생성하는 서비스(발송대기내역 GA09N503에 INSERT)
 */
@Service
public class RQSRSchedule1000U1Service {

    @Autowired
    RQSRSchedule1000U0Service rqsrSchedule1000U0Service; /* 메서드 재사용을 위함 */

    @Autowired
    RQSRSchedule1000U1Dao rqsrSchedule1000U1Dao;

    /* 1. 발송 대상 RCT_NO 확인 */
    /* rqsrSchedule1000U0Service.findTargetRctNoList */

    /* 2. RQS_NO를 통해 신청정보 획득 */
    /* rqsrSchedule1000U0Service.findRqsInfoByRctNo */

    /* 3. 조직의 팀점장 정보 확인 */
    public RQSRSchedule1000U1Out00VO findRptvEpInfoByOrzCd(String orzCd) {
        return rqsrSchedule1000U1Dao.findRptvEpInfoByOrzCd(orzCd);
    }

    /* 4. 발송 메시지 생성 */
    /* rqsrSchedule1000U0Service.makeMsgSndCn */

    /* 5. 발송대기내역에 저장 */
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
                String targetDate = DateUtil.getAddDay(today, -6);
                List<String> rctNoList = rqsrSchedule1000U0Service.findTargetRctNoList(targetDate);


                List<String> savedEpnoList = new ArrayList<>();
                for (String rctNo : rctNoList) {
                    /* 2. RQS_NO를 통해 신청정보 획득 */
                    RQSRSchedule1000U0Out00VO rqsInfo = rqsrSchedule1000U0Service.findRqsInfoByRctNo(rctNo);

                    // 동일 직원에 대한 내용을 여러번 발송하지 않도록 저장
                    String rqsEpno = rqsInfo.getRqsEpno();
                    if(savedEpnoList.contains(rqsEpno)) {
                        continue;
                    } else {
                        savedEpnoList.add(rqsEpno);
                    }

                    /* 3. 조직의 팀점장 정보 확인 */
                    RQSRSchedule1000U1Out00VO rptvEpInfo = findRptvEpInfoByOrzCd(rqsInfo.getRqsOrzCd());

                    /* 4. 발송 메시지 생성 */
                    /*
                    [Mi-support]
                    #{신청자의팀점장명} #{직책명}님
                    #{지점명} #{신청직원명} 직원이 발급한 증명서가 오늘 만료예정이예요.

                    사용기간이 지난 증명서는 반드시 원본을 폐기하거나 사용처에 제출한 후 사용내역을 등록했는지 점검이 필요해요.*/
                    String strIprtMsgCd = "GA0061";
                    List<String> replaceStringList = new ArrayList<>();
                    replaceStringList.add(rptvEpInfo.getEpNm()); /* 신청자의팀점장명 */
                    String rqsHrOsdtPstNm = CommonUtil.findHrOsdtCdNmOrHrPstCdNmByEpno(rptvEpInfo.getEpno()); /* 직책직위명 획득 */
                    replaceStringList.add(rqsHrOsdtPstNm); /* 직책명 */
                    replaceStringList.add(rptvEpInfo.getOrzNm()); /* 지점명 */
                    replaceStringList.add(rqsInfo.getRqsEpNm()); /* 신청직원명 */
                    String strMsgSndCn = rqsrSchedule1000U0Service.makeMsgSndCn(strIprtMsgCd, replaceStringList);

                    /* 5. 발송대기내역에 저장 */
                    String strSmsSndDt = tomorrow;
                    String strSmsSndTmd = "100000"; // 시, 분, 초. 10시에 발송
                    String strOrzCd = rptvEpInfo.getOrzCd();
                    String strEpno = rptvEpInfo.getEpno();
                    String strRctNo = rqsInfo.getRctNo();
                    rqsrSchedule1000U0Service.insertGA09N503(strIprtMsgCd, strMsgSndCn, strSmsSndDt, strSmsSndTmd, strOrzCd, strEpno, strRctNo, null);
                }
            }
        } catch (Exception e) {
            throw new CustomBadRequestException(e.getMessage(), ErrorCode.BAD_REQUEST);
        }


    }
}
