package com.miraeasset.biz.common.schedule;

import com.miraeasset.biz.common.service.CommonScheduleService;
import com.miraeasset.biz.common.util.CommonUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.rq.sr.service.*;
import com.miraeasset.biz.sh.an.service.SHANSchedule1000U0Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class Schedule {
    @Value("${SYSTEM_NAME}")
    private String SYSTEM_NAME;

    @Autowired
    RQSRSchedule1000U0Service rqsrSchedule1000U0Service;
    @Autowired
    RQSRSchedule1000U1Service rqsrSchedule1000U1Service;
    @Autowired
    RQSRSchedule1000U2Service rqsrSchedule1000U2Service;
    @Autowired
    RQSRSchedule1000U3Service rqsrSchedule1000U3Service;
    @Autowired
    RQSRSchedule1000U4Service rqsrSchedule1000U4Service;
    @Autowired
    RQSRSchedule1000U5Service rqsrSchedule1000U5Service;
    @Autowired
    CommonScheduleService commonScheduleService;
    @Autowired
    SHANSchedule1000U0Service shanSchedule1000U0Service;

    boolean isTargetHost() throws UnknownHostException {
        /* 호스트명 체크로 이중화 서버에서도 한 군데에서만 돌도록 함 */
        /* 안티패턴이므로 추후 스케줄용 DB 만들어서 실행여부 체크하는 방식으로 변경... */
        String hostname = InetAddress.getLocalHost().getHostName();
        try {
            if(!!! (hostname.equals("pinfows03") || hostname.equals("thtml02") || hostname.equals("dhtml02") || SYSTEM_NAME.equals("local") ) ) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Scheduled(cron = "0 0 20 * * *") /* 매일 20시에 실행 */
    public void RunBizDay20PmSchedule() throws UnknownHostException {

        if(!!!isTargetHost()) return;

        /* 스케줄 서비스 각각에 영업일 체크 로직 있으므로 영업일 체크하지 않음 */
        rqsrSchedule1000U0Service.mainProc();
        rqsrSchedule1000U1Service.mainProc();
        rqsrSchedule1000U2Service.mainProc();
        rqsrSchedule1000U3Service.mainProc();
        rqsrSchedule1000U4Service.mainProc();
        rqsrSchedule1000U5Service.mainProc();
    }

    @Scheduled(cron = "0 0 2 * * *") /* 매일 새벽 2시에 실행 */
    public void RunBizDay02AmSchedule() throws UnknownHostException {
        if(!!!isTargetHost()) return;

        String today = DateUtil.getDate();

        shanSchedule1000U0Service.mainProc(today, today);
    }

    @Scheduled(cron = "0 0 10 * * *") /* 매일 10시에 실행 */
    public void RunBizDay10AmSchedule() throws UnknownHostException {
        if(!!!isTargetHost()) return;

        String today = DateUtil.getDate();
        boolean checkBzD5Yn = CommonUtil.checkBzD5Yn(today);

        /* 당일이 영업일이 아니라면 발송하지 않음 */
        if (!!!checkBzD5Yn) return;

        commonScheduleService.sendScheduledMessage(); /* 발송 대기내역을 발송하는 서비스 */
    }
}
