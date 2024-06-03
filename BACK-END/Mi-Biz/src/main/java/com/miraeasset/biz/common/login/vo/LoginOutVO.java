package com.miraeasset.biz.common.login.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miraeasset.biz.common.vo.BaseVO;
import com.miraeasset.biz.ss.bs.vo.SSBS7000VOOut00VO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class LoginOutVO extends BaseVO {
    private String epno;
    private String epNm;
    private String epEngNm;
    private String jncoDt;
    private String rtmtDt;
    private String blngOrzCd;
    private String aptmNowWrkpOrzCd;
    private String nowWrkpOrzCd;
    private String hrOrzCd;
    private String hrHldoCd;
    private String epIdfyTcd;
    private String rpsrEpno;
    private String epBzTcd;
    private String sexTcd;
    private String xempIdfyNoEcpVl;
    private String hrEpTcd;
    private String hrPstCd;
    private String hrPstYrord;
    private String hrOsdtCd;
    private String hrOcgrpCd;
    private String ctno;
    private String rtn;
    private String mtno;
    private String itno;
    private String intaTlno;
    private String hndpBzprTlno;
    private String hndpMtno;
    private String hndpItno;
    private String emalAdr;
    private String zpcd;
    private String adr;
    private String pwdEcpVl;
    private String pwdErrNc;
    private String pwdLstChngDt;
    private String bzPwdEcpVl;
    private String bzPwdErrNc;
    private String bzPwdLstChngDt;
    private String drtBrBzPrcAblYn;
    private String empSortSeq;
    private String csCntrEmpMtCd;
    private String csCntrRpsrYn;
    private String csCntrRpsrEpno;
    private String apvrTcd;
    private String chbfEpno;
    private String empOfcTlno;
    private String hrLstAltrDt;
    private String hrRflcDt;
    //    private String optrId;
//    private String oprtChnlCd;
//    private String oprtOrzCd;
//    private String oprtIpAdr;
//    private String oprtDttm;
    private String connIp;
    private String orzNm;
    private String admnYn;
    private List<String> accsAblOrzCd;
    private List<String> userGrpCdList;
    private List<SSBS7000VOOut00VO> accsAblMenu;
    private List<LoginUserMenuVO> loginUserMenuVOList;
    private String lnkMtOrzCd;
    private String hobrTcd;

    private Date lginDttm;

    private String connChnlCd = "412";

    private String hrOsdtCdNm;

    private String hrPstCdNm;

    private String hrOsdtPstNm;

    private String lginDt;

    private String lginTmd;

    private String orzRptvYn;

    public String getEpno() {
        return epno;
    }

    public void setEpno(String epno) {
        this.epno = epno;
    }

    public String getEpNm() {
        return epNm;
    }

    public void setEpNm(String epNm) {
        this.epNm = epNm;
    }

    public String getEpEngNm() {
        return epEngNm;
    }

    public void setEpEngNm(String epEngNm) {
        this.epEngNm = epEngNm;
    }

    public String getJncoDt() {
        return jncoDt;
    }

    public void setJncoDt(String jncoDt) {
        this.jncoDt = jncoDt;
    }

    public String getRtmtDt() {
        return rtmtDt;
    }

    public void setRtmtDt(String rtmtDt) {
        this.rtmtDt = rtmtDt;
    }

    public String getBlngOrzCd() {
        return blngOrzCd;
    }

    public void setBlngOrzCd(String blngOrzCd) {
        this.blngOrzCd = blngOrzCd;
    }

    public String getAptmNowWrkpOrzCd() {
        return aptmNowWrkpOrzCd;
    }

    public void setAptmNowWrkpOrzCd(String aptmNowWrkpOrzCd) {
        this.aptmNowWrkpOrzCd = aptmNowWrkpOrzCd;
    }

    public String getNowWrkpOrzCd() {
        return nowWrkpOrzCd;
    }

    public void setNowWrkpOrzCd(String nowWrkpOrzCd) {
        this.nowWrkpOrzCd = nowWrkpOrzCd;
    }

    public String getHrOrzCd() {
        return hrOrzCd;
    }

    public void setHrOrzCd(String hrOrzCd) {
        this.hrOrzCd = hrOrzCd;
    }

    public String getHrHldoCd() {
        return hrHldoCd;
    }

    public void setHrHldoCd(String hrHldoCd) {
        this.hrHldoCd = hrHldoCd;
    }

    public String getEpIdfyTcd() {
        return epIdfyTcd;
    }

    public void setEpIdfyTcd(String epIdfyTcd) {
        this.epIdfyTcd = epIdfyTcd;
    }

    public String getRpsrEpno() {
        return rpsrEpno;
    }

    public void setRpsrEpno(String rpsrEpno) {
        this.rpsrEpno = rpsrEpno;
    }

    public String getEpBzTcd() {
        return epBzTcd;
    }

    public void setEpBzTcd(String epBzTcd) {
        this.epBzTcd = epBzTcd;
    }

    public String getSexTcd() {
        return sexTcd;
    }

    public void setSexTcd(String sexTcd) {
        this.sexTcd = sexTcd;
    }

    public String getXempIdfyNoEcpVl() {
        return xempIdfyNoEcpVl;
    }

    public void setXempIdfyNoEcpVl(String xempIdfyNoEcpVl) {
        this.xempIdfyNoEcpVl = xempIdfyNoEcpVl;
    }

    public String getHrEpTcd() {
        return hrEpTcd;
    }

    public void setHrEpTcd(String hrEpTcd) {
        this.hrEpTcd = hrEpTcd;
    }

    public String getHrPstCd() {
        return hrPstCd;
    }

    public void setHrPstCd(String hrPstCd) {
        this.hrPstCd = hrPstCd;
    }

    public String getHrPstYrord() {
        return hrPstYrord;
    }

    public void setHrPstYrord(String hrPstYrord) {
        this.hrPstYrord = hrPstYrord;
    }

    public String getHrOsdtCd() {
        return hrOsdtCd;
    }

    public void setHrOsdtCd(String hrOsdtCd) {
        this.hrOsdtCd = hrOsdtCd;
    }

    public String getHrOcgrpCd() {
        return hrOcgrpCd;
    }

    public void setHrOcgrpCd(String hrOcgrpCd) {
        this.hrOcgrpCd = hrOcgrpCd;
    }

    public String getCtno() {
        return ctno;
    }

    public void setCtno(String ctno) {
        this.ctno = ctno;
    }

    public String getRtn() {
        return rtn;
    }

    public void setRtn(String rtn) {
        this.rtn = rtn;
    }

    public String getMtno() {
        return mtno;
    }

    public void setMtno(String mtno) {
        this.mtno = mtno;
    }

    public String getItno() {
        return itno;
    }

    public void setItno(String itno) {
        this.itno = itno;
    }

    public String getIntaTlno() {
        return intaTlno;
    }

    public void setIntaTlno(String intaTlno) {
        this.intaTlno = intaTlno;
    }

    public String getHndpBzprTlno() {
        return hndpBzprTlno;
    }

    public void setHndpBzprTlno(String hndpBzprTlno) {
        this.hndpBzprTlno = hndpBzprTlno;
    }

    public String getHndpMtno() {
        return hndpMtno;
    }

    public void setHndpMtno(String hndpMtno) {
        this.hndpMtno = hndpMtno;
    }

    public String getHndpItno() {
        return hndpItno;
    }

    public void setHndpItno(String hndpItno) {
        this.hndpItno = hndpItno;
    }

    public String getEmalAdr() {
        return emalAdr;
    }

    public void setEmalAdr(String emalAdr) {
        this.emalAdr = emalAdr;
    }

    public String getZpcd() {
        return zpcd;
    }

    public void setZpcd(String zpcd) {
        this.zpcd = zpcd;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getPwdEcpVl() {
        return pwdEcpVl;
    }

    public void setPwdEcpVl(String pwdEcpVl) {
        this.pwdEcpVl = pwdEcpVl;
    }

    public String getPwdErrNc() {
        return pwdErrNc;
    }

    public void setPwdErrNc(String pwdErrNc) {
        this.pwdErrNc = pwdErrNc;
    }

    public String getPwdLstChngDt() {
        return pwdLstChngDt;
    }

    public void setPwdLstChngDt(String pwdLstChngDt) {
        this.pwdLstChngDt = pwdLstChngDt;
    }

    public String getBzPwdEcpVl() {
        return bzPwdEcpVl;
    }

    public void setBzPwdEcpVl(String bzPwdEcpVl) {
        this.bzPwdEcpVl = bzPwdEcpVl;
    }

    public String getBzPwdErrNc() {
        return bzPwdErrNc;
    }

    public void setBzPwdErrNc(String bzPwdErrNc) {
        this.bzPwdErrNc = bzPwdErrNc;
    }

    public String getBzPwdLstChngDt() {
        return bzPwdLstChngDt;
    }

    public void setBzPwdLstChngDt(String bzPwdLstChngDt) {
        this.bzPwdLstChngDt = bzPwdLstChngDt;
    }

    public String getDrtBrBzPrcAblYn() {
        return drtBrBzPrcAblYn;
    }

    public void setDrtBrBzPrcAblYn(String drtBrBzPrcAblYn) {
        this.drtBrBzPrcAblYn = drtBrBzPrcAblYn;
    }

    public String getEmpSortSeq() {
        return empSortSeq;
    }

    public void setEmpSortSeq(String empSortSeq) {
        this.empSortSeq = empSortSeq;
    }

    public String getCsCntrEmpMtCd() {
        return csCntrEmpMtCd;
    }

    public void setCsCntrEmpMtCd(String csCntrEmpMtCd) {
        this.csCntrEmpMtCd = csCntrEmpMtCd;
    }

    public String getCsCntrRpsrYn() {
        return csCntrRpsrYn;
    }

    public void setCsCntrRpsrYn(String csCntrRpsrYn) {
        this.csCntrRpsrYn = csCntrRpsrYn;
    }

    public String getCsCntrRpsrEpno() {
        return csCntrRpsrEpno;
    }

    public void setCsCntrRpsrEpno(String csCntrRpsrEpno) {
        this.csCntrRpsrEpno = csCntrRpsrEpno;
    }

    public String getApvrTcd() {
        return apvrTcd;
    }

    public void setApvrTcd(String apvrTcd) {
        this.apvrTcd = apvrTcd;
    }

    public String getChbfEpno() {
        return chbfEpno;
    }

    public void setChbfEpno(String chbfEpno) {
        this.chbfEpno = chbfEpno;
    }

    public String getEmpOfcTlno() {
        return empOfcTlno;
    }

    public void setEmpOfcTlno(String empOfcTlno) {
        this.empOfcTlno = empOfcTlno;
    }

    public String getHrLstAltrDt() {
        return hrLstAltrDt;
    }

    public void setHrLstAltrDt(String hrLstAltrDt) {
        this.hrLstAltrDt = hrLstAltrDt;
    }

    public String getHrRflcDt() {
        return hrRflcDt;
    }

    public void setHrRflcDt(String hrRflcDt) {
        this.hrRflcDt = hrRflcDt;
    }

//    public String getOptrId() {
//        return optrId;
//    }
//
//    public void setOptrId(String optrId) {
//        this.optrId = optrId;
//    }
//
//    public String getOprtChnlCd() {
//        return oprtChnlCd;
//    }
//
//    public void setOprtChnlCd(String oprtChnlCd) {
//        this.oprtChnlCd = oprtChnlCd;
//    }
//
//    public String getOprtOrzCd() {
//        return oprtOrzCd;
//    }
//
//    public void setOprtOrzCd(String oprtOrzCd) {
//        this.oprtOrzCd = oprtOrzCd;
//    }
//
//    public String getOprtIpAdr() {
//        return oprtIpAdr;
//    }
//
//    public void setOprtIpAdr(String oprtIpAdr) {
//        this.oprtIpAdr = oprtIpAdr;
//    }
//
//    public String getOprtDttm() {
//        return oprtDttm;
//    }
//
//    public void setOprtDttm(String oprtDttm) {
//        this.oprtDttm = oprtDttm;
//    }

    public String getConnIp() {
        return connIp;
    }

    public void setConnIp(String connIp) {
        this.connIp = connIp;
    }

    public String getOrzNm() {
        return orzNm;
    }

    public void setOrzNm(String orzNm) {
        this.orzNm = orzNm;
    }

    public String getAdmnYn() {
        return admnYn;
    }

    public void setAdmnYn(String admnYn) {
        this.admnYn = admnYn;
    }

    public List<String> getAccsAblOrzCd() {
        return accsAblOrzCd;
    }

    public void setAccsAblOrzCd(List<String> accsAblOrzCd) {
        this.accsAblOrzCd = accsAblOrzCd;
    }

    public List<String> getUserGrpCdList() {
        return userGrpCdList;
    }

    public void setUserGrpCdList(List<String> userGrpCdList) {
        this.userGrpCdList = userGrpCdList;
    }

    public List<SSBS7000VOOut00VO> getAccsAblMenu() {
        return accsAblMenu;
    }

    public void setAccsAblMenu(List<SSBS7000VOOut00VO> accsAblMenu) {
        this.accsAblMenu = accsAblMenu;
    }

    public List<LoginUserMenuVO> getLoginUserMenuVOList() {
        return loginUserMenuVOList;
    }

    public void setLoginUserMenuVOList(List<LoginUserMenuVO> loginUserMenuVOList) {
        this.loginUserMenuVOList = loginUserMenuVOList;
    }

    public String getLnkMtOrzCd() {
        return lnkMtOrzCd;
    }

    public void setLnkMtOrzCd(String lnkMtOrzCd) {
        this.lnkMtOrzCd = lnkMtOrzCd;
    }

    public String getHobrTcd() {
        return hobrTcd;
    }

    public void setHobrTcd(String hobrTcd) {
        this.hobrTcd = hobrTcd;
    }

    public Date getLginDttm() {
        return lginDttm;
    }

    public void setLginDttm(Date lginDttm) {
        this.lginDttm = lginDttm;
    }

    public String getConnChnlCd() {
        return connChnlCd;
    }

    public void setConnChnlCd(String connChnlCd) {
        this.connChnlCd = connChnlCd;
    }

    public String getHrOsdtCdNm() {
        return hrOsdtCdNm;
    }

    public void setHrOsdtCdNm(String hrOsdtCdNm) {
        this.hrOsdtCdNm = hrOsdtCdNm;
    }

    public String getHrPstCdNm() {
        return hrPstCdNm;
    }

    public void setHrPstCdNm(String hrPstCdNm) {
        this.hrPstCdNm = hrPstCdNm;
    }

    public String getHrOsdtPstNm() {
        return hrOsdtPstNm;
    }

    public void setHrOsdtPstNm(String hrOsdtPstNm) {
        this.hrOsdtPstNm = hrOsdtPstNm;
    }

    public String getLginDt() {
        return lginDt;
    }

    public void setLginDt(String lginDt) {
        this.lginDt = lginDt;
    }

    public String getLginTmd() {
        return lginTmd;
    }

    public void setLginTmd(String lginTmd) {
        this.lginTmd = lginTmd;
    }

    public String getOrzRptvYn() {
        return orzRptvYn;
    }

    public void setOrzRptvYn(String orzRptvYn) {
        this.orzRptvYn = orzRptvYn;
    }
}
