package com.miraeasset.biz.common.util.altok;

import java.io.FileNotFoundException;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.miraeasset.biz.common.code.dao.CodeDao;
import com.miraeasset.biz.common.util.CryptoUtil;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.altok.vo.AltokIn00VO;
import com.miraeasset.biz.common.util.altok.vo.AltokIn01VO;
import com.miraeasset.biz.common.util.altok.vo.AltokOut01VO;
import com.miraeasset.biz.common.util.altok.vo.AltokOut02VO;


@Service
public class AltokService {

    private final AltokDao altokDao;

    public AltokService(AltokDao altokDao) {
        this.altokDao = altokDao;
    }

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CodeDao codeDao;

    @Value("${SYSTEM_NAME}")
    private String SYSTEM_NAME;


    /* 알림톡 발송ID(SQ) 획득 */
    public String getSndId() {
        return altokDao.selectOne00FW04N904();
    }

    /* 알림톡 메시지 정보 */
    public AltokOut02VO getMsgDetail(String letrMsgCd) {
        return altokDao.selectOne00CS02C071(letrMsgCd);
    }


    /* 알림톡 전송 */
    public AltokOut01VO sendAltok(String letrMsgCd, String altokFwdCn, String dpmsgObjTlno, String rvObjTlno) {
    	
        String sndDt = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String sndId = this.getSndId();

        AltokOut02VO msgDetail = this.getMsgDetail(letrMsgCd);

        AltokIn00VO altokIn00VO = new AltokIn00VO();
        altokIn00VO.setSndDt(sndDt);
        altokIn00VO.setSndId(sndId);
        altokIn00VO.setLetrMsgCd(msgDetail.getLetrMsgCd());
        //altokIn00VO.setLetrMsgSrno(msgDetail.getLetrMsgSrno());
        altokIn00VO.setLetrMsgSrno(msgDetail.getLetrMsgDlSrno());
        altokIn00VO.setAltokFwdCn(altokFwdCn);
        altokIn00VO.setDpmsgObjTlno(CryptoUtil.getEncryption(dpmsgObjTlno));
        altokIn00VO.setRvObjTlno(CryptoUtil.getEncryption(rvObjTlno));

        if ( SYSTEM_NAME.equals("local") ) {
            altokIn00VO.setDpmsgObjTlno("7I+hXqqW7w754aM20XqHhQ==");
            altokIn00VO.setRvObjTlno("24+hyt30tLRDNKChwdhq6A==");
        }
        
        if( altokIn00VO.getDpmsgObjTlno().equals(dpmsgObjTlno) || altokIn00VO.getRvObjTlno().equals(rvObjTlno) ) {
            log.error(" === 전화번호(DPMSG_OBJ_TLNO or RV_OBJ_TLNO) 암호화 에러 === ");
        }
        else
        {
            altokDao.insert00FW04N904(altokIn00VO);
        }

        AltokIn01VO altokIn01VO = new AltokIn01VO();
        altokIn01VO.setSndDt(sndDt);
        altokIn01VO.setSndId(sndId);

        AltokOut01VO result = altokDao.selectOne00FW04N914(altokIn01VO);
        if(result != null) {
            return result;
        } else {
            return null;
        }
    }



    public AltokOut01VO sendAltokByRctNo(String sReceiveUserId, String strRctNo, String strCmnCdVl, String strUserDefVl1, String strUserDefVl2) throws Exception {
        String strMsg = "";
        String strMsgSend;
        String strHndpTlno = "";

        Map<String,Object> map = new HashMap<>();
        map.put("rctNo", strRctNo);
        map.put("msgTyp", strCmnCdVl);

        if(strCmnCdVl.equals("APV_CMPN")){
            map.put("iprtMsgCd", "AT0001");
        }

        // [20240405]삭제 요청
        //if(sReceiveUserId.contains(",")){
            // 테스트 데이터
        //    map.put("epNo", "3360135");
        //}
        //else {
            map.put("epNo", sReceiveUserId);
        //}

        try {
            map = codeDao.selectMsgEnrollNotiTxt(map);

            if (map.get("msgIprt") != null) {
                try {
                    strMsg = DateUtil.getCLOBnBR((Clob)map.get("msgIprt"));
                } catch(FileNotFoundException ignored) {
                    strMsg = map.get("msgIprt").toString();
                }
            }

            strHndpTlno = map.get("hndpTlno").toString();
            strHndpTlno = strHndpTlno.replace("-","");
        } catch(FileNotFoundException ex) {
            log.error(ex.getMessage());
            log.error(" === 알림톡 전송 메시지 로딩 실패, rctNo : " + strRctNo);
        }

        if ( !StringUtils.isBlank(strMsg) ) {
            strMsgSend = String.format(strMsg
                    , map.get("epNmSt").toString()
                    , map.get("menuNm").toString() + "-" + map.get("enrollCategory").toString()
            );

            // log.info("알림톡 입력 값 : " + strMsgSend);

//            if ( SYSTEM_NAME.equals("local") || SYSTEM_NAME.equals("dev") || SYSTEM_NAME.equals("test") ) {
//                if(map.get("epNo").toString().contains("3337613")) {
//                    strHndpTlno = "01047119152"; // 총무팀 정민영
//                } else {
//                    //strHndpTlno = "01076297512"; // 경영시스템팀 이정준 [20240405]삭제 요청
//                	strHndpTlno = "01062530011";
//                }
//            }

            sendAltok("GA001", strMsgSend, "15886800", strHndpTlno);

            // 개발, 검증 테스트
            //if( SYSTEM_NAME.equals("local") || SYSTEM_NAME.equals("dev") || SYSTEM_NAME.equals("test") ) { }
            
        }

        return null;
    }




}
