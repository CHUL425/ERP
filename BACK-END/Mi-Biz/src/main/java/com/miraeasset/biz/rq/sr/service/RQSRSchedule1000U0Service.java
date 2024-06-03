package com.miraeasset.biz.rq.sr.service;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.common.login.vo.LoginOutVO;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.rq.sr.dao.RQSRSchdule1000U0Dao;
import com.miraeasset.biz.rq.sr.vo.RQSRSchedule1000U0Out00VO;
import com.miraeasset.biz.ss.zs.service.SSZS2000U0Service;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0In01VO;
import com.miraeasset.biz.ss.zs.vo.SSZS2000U0Out01VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * GA0051
 * 인감날인&증명서 만료일 당일에 신청자에게 보낼 메시지를 전날 생성하는 서비스(발송대기내역 GA09N503에 INSERT)
 */
@Service
public class RQSRSchedule1000U0Service {

    @Autowired
    RQSRSchdule1000U0Dao rqsrSchdule1000U0Dao;

    @Autowired
    SSZS2000U0Service sszs2000U0Service;

    /* 1. 발송 대상 RCT_NO 확인 */
    public List<String> findTargetRctNoList(String targetDate) {
        /* 인감증명서의 출고일자가 targetDate 이면서, 통합신청의 상태가 처리완료(40)인 RCT_NO 획득 */
        return rqsrSchdule1000U0Dao.findTargetRctNoList(targetDate);
    }

    /* 2. RQS_NO를 통해 신청정보 획득 */
    public RQSRSchedule1000U0Out00VO findRqsInfoByRctNo(String rctNo) {
        /* 신청번호 -> 신청번호, 신청사원번호, 신청사원명, 신청명 */
        return rqsrSchdule1000U0Dao.findRqsInfoByRctNo(rctNo);
    }

    /* 3. 발송 메시지 생성 */
    public String makeMsgSndCn(String strIprtMsgCd, List<String> replaceStringList) {
        SSZS2000U0Out01VO sszs2000U0Out01VO = sszs2000U0Service.selectGA09N501(new SSZS2000U0In01VO(strIprtMsgCd));
        if(sszs2000U0Out01VO == null) {
            throw new CustomBadRequestException(String.format("해당하는 메시지 코드가 없어요.[%s]", strIprtMsgCd), ErrorCode.BAD_REQUEST);
        }
        String strMsgSndCn = sszs2000U0Out01VO.getMsgSndCn();

        /* 바꿀 문자 리스트를 통해, %s를 앞에서부터 하나씩 바꿈 */
        for(String replaceString : replaceStringList) {
            strMsgSndCn = strMsgSndCn.replaceFirst("%s", replaceString);
        }

        return strMsgSndCn;
    }

    /* 4. 발송대기내역에 저장 */
    public void insertGA09N503(String strIprtMsgCd, String strMsgSndCn, String strSmsSndDt, String strSmsSndTmd, String strOrzCd, String strEpno, String strRctNo, LoginOutVO loginOutVO) {
        CommonUtil.insertGA09N503(strIprtMsgCd, strMsgSndCn, strSmsSndDt, strSmsSndTmd, strOrzCd, strEpno, strRctNo, loginOutVO);
    }

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
                List<String> rctNoList = findTargetRctNoList(targetDate);

                for(String rctNo : rctNoList) {
                    /* 2. RQS_NO를 통해 신청정보 획득 */
                    RQSRSchedule1000U0Out00VO rqsInfo = findRqsInfoByRctNo(rctNo);

                    /* 3. 발송 메시지 생성 */
                    /*
                    [Mi-support]
                    #{신청자명} #{직위명}님
                    신청명 : #{신청명}
                    증명서가 오늘 만료예정이예요.

                    증명서 사용내역(사용처제출or원본폐기)을 등록해주세요.

                    ※ Mi-support >일반신청 > 인감날인&증명서신청내역
                    - 사용처제출 : 사용처 제출
                    - 원본폐기 : 미사용, 팩스 등 사용으로 원본보관분 폐기
                    */
                    String strIprtMsgCd = "GA0051";
                    List<String> replaceStringList = new ArrayList<>();
                    replaceStringList.add(rqsInfo.getRqsEpNm()); /* 신청자명 */
                    String rqsHrOsdtPstNm = CommonUtil.findHrOsdtCdNmOrHrPstCdNmByEpno(rqsInfo.getRqsEpno()); /* 직책직위명 획득 */
                    replaceStringList.add(rqsHrOsdtPstNm); /* 직위직책명 */
                    replaceStringList.add(rqsInfo.getRqsTtlNm()); /* 신청명 */
                    String strMsgSndCn = makeMsgSndCn(strIprtMsgCd, replaceStringList);

                    /* 4. 발송대기내역에 저장 */
                    String strSmsSndDt = tomorrow;
                    String strSmsSndTmd = "100000"; // 시, 분, 초. 10시에 발송
                    String strOrzCd = rqsInfo.getRqsOrzCd();
                    String strEpno = rqsInfo.getRqsEpno();
                    String strRctNo = rqsInfo.getRctNo();
                    insertGA09N503(strIprtMsgCd, strMsgSndCn, strSmsSndDt, strSmsSndTmd, strOrzCd, strEpno, strRctNo, null);
                }
            }
        } catch (Exception e) {
            throw new CustomBadRequestException(e.getMessage(), ErrorCode.BAD_REQUEST);
        }
    }
}