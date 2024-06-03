package com.miraeasset.biz.sh.an.service;

import com.miraeasset.biz.bn.gn.dao.BNGN1000U0Dao;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0In00VO;
import com.miraeasset.biz.bn.gn.vo.BNGN1000U0Out00VO;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.rq.sr.service.RQSRSchedule1000U0Service;
import com.miraeasset.biz.sh.an.dao.SHAN2000U0Dao;
import com.miraeasset.biz.sh.an.vo.SHAN2000U0In00VO;
import com.miraeasset.biz.sh.an.vo.SHAN2000U0Out00VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SHANSchedule1000U0Service {

    @Autowired
    BNGN1000U0Dao bngn1000U0Dao;
    @Autowired
    SHAN2000U0Dao shan2000U0Dao;
    
    @Autowired
    RQSRSchedule1000U0Service rqsrSchedule1000U0Service; /* 재사용 위해 선언 */


    /* 대상 공지사항 */
    public List<BNGN1000U0Out00VO> findTargetAnnouncement(String targetDate) {
        BNGN1000U0In00VO bngn1000U0In00VO = new BNGN1000U0In00VO(); /* 안전보건공지 공지사항 조회를 위한 VO */
        List<BNGN1000U0Out00VO> bngn1000U0Out00VOList;              /* 안전보건공지 공지사항 조회 결과 */
        List<BNGN1000U0Out00VO> targetAnnouncementList = new ArrayList<>();     /* 안전보건공지 공지사항 중 필터링된 내용(return 대상) */

        /* 조회조건 : 안전보건공지 & 조회조건 전체 */
        bngn1000U0In00VO.setCmklTcd("03"); // 안전보건공지
        bngn1000U0In00VO.setQryStrtDt("00000101");
        bngn1000U0In00VO.setQryEndDt("99991231");

        /* 조회 결과 */
        bngn1000U0Out00VOList = bngn1000U0Dao.selectListGA09N421(bngn1000U0In00VO);

        /* 대상 필터링 : 게시종료일자가 오늘이고 삭제되지 않은 게시물 */
        for(BNGN1000U0Out00VO bngn1000U0Out00VO : bngn1000U0Out00VOList) {
            if(bngn1000U0Out00VO == null) continue;

            String delYn = bngn1000U0Out00VO.getDelYn();
            String pstupEndDt = bngn1000U0Out00VO.getPstupEndDt();

            if(!delYn.equals("1") && pstupEndDt.equals(targetDate)) {
                targetAnnouncementList.add(bngn1000U0Out00VO);
            }
        }

        System.out.println("######################targetAnnouncementList.size():" + targetAnnouncementList.size());
        return targetAnnouncementList;
    }

    /* 대상 확인내역 */
    public List<SHAN2000U0Out00VO> findTargetConfirmList(List<BNGN1000U0Out00VO> targetAnnouncementList) {

        SHAN2000U0In00VO shan2000U0In00VO = new SHAN2000U0In00VO();
        List<SHAN2000U0Out00VO> shan2000U0Out00VOList;
        List<SHAN2000U0Out00VO> targetConfirmList = new ArrayList<>();

        shan2000U0In00VO.setCmklTcd("03");
        shan2000U0In00VO.setPageSize(BigDecimal.valueOf(100000));
        shan2000U0In00VO.setPageNum(BigDecimal.valueOf(1));
        shan2000U0Out00VOList = shan2000U0Dao.selectShanPsttList(shan2000U0In00VO);

        for(BNGN1000U0Out00VO bngn1000U0Out00VO : targetAnnouncementList) {
            if(bngn1000U0Out00VO == null) continue;

            String targetMadeDt = bngn1000U0Out00VO.getMadeDt();
            BigDecimal targetSrno = bngn1000U0Out00VO.getSrno();

            for(SHAN2000U0Out00VO shan2000U0Out00VO : shan2000U0Out00VOList) {
                if(shan2000U0Out00VO == null) continue;

                String madeDt = shan2000U0Out00VO.getMadeDt();
                BigDecimal srno = shan2000U0Out00VO.getSrno();
                if( !targetMadeDt.equals(madeDt) || !targetSrno.equals(srno) ) continue;

                if( shan2000U0Out00VO.getCfmtYn() == null || !shan2000U0Out00VO.getCfmtYn().equals("Y") ) {
                    targetConfirmList.add(shan2000U0Out00VO);
                }
            }
        }

        System.out.println("######################targetConfirmList.size():" + targetConfirmList.size());
        return targetConfirmList;
    }

    public void mainProc(String targetDate, String sndDate) {
        /* 대상 확인 */
        List<BNGN1000U0Out00VO> targetAnnouncementList = findTargetAnnouncement(targetDate);
        List<SHAN2000U0Out00VO> targetConfirmList = findTargetConfirmList(targetAnnouncementList);

        for(SHAN2000U0Out00VO shan2000U0Out00VO : targetConfirmList) {
            String strIprtMsgCd = "SH0001";
            List<String> replaceStringList = new ArrayList<>();
            replaceStringList.add(shan2000U0Out00VO.getCfmtEpnm());
            String rqsHrOsdtPstNm = CommonUtil.findHrOsdtCdNmOrHrPstCdNmByEpno(shan2000U0Out00VO.getCfmtEpno()); /* 직책직위명 획득 */
            replaceStringList.add(rqsHrOsdtPstNm); /* 직위직책명 */
            String msgSndCn = rqsrSchedule1000U0Service.makeMsgSndCn(strIprtMsgCd, replaceStringList);

            /* 4. 발송대기내역에 저장 */
            String strMsgSndCn = msgSndCn;
            String strSmsSndDt = sndDate;
            String strSmsSndTmd = "100000"; // 시, 분, 초. 10시에 발송. 나중에 알림테이블 참조해서 바꿀 것.
            String strOrzCd = shan2000U0Out00VO.getOrzCd();
            String strEpno = shan2000U0Out00VO.getCfmtEpno();
            rqsrSchedule1000U0Service.insertGA09N503(strIprtMsgCd, strMsgSndCn, strSmsSndDt, strSmsSndTmd, strOrzCd, strEpno, null, null);
        }
    }
}
