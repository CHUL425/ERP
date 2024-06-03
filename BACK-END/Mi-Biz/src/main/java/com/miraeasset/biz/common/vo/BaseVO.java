package com.miraeasset.biz.common.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.apache.commons.lang3.StringUtils;

import io.swagger.annotations.ApiModelProperty;

import com.miraeasset.biz.common.login.vo.LoginOutVO;

public class BaseVO {
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String optrId;
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String oprtChnlCd;
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String oprtOrzCd;
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String oprtIpAdr;
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String oprtDttm;

    public String getOptrId() {
        HttpSessionValueSet();

        return optrId;
    }
    public String getOprtChnlCd() {
        HttpSessionValueSet();

        return oprtChnlCd;
    }
    public String getOprtOrzCd() {
        HttpSessionValueSet();

        return oprtOrzCd;
    }
    public String getOprtIpAdr() {
        HttpSessionValueSet();

        return oprtIpAdr;
    }

    public void HttpSessionValueSet()
    {
        if(StringUtils.isBlank(optrId)){
            optrId = "0000000";
            oprtChnlCd = "412";
            oprtOrzCd = "000000";
            oprtIpAdr = "0.0.0.0";
            oprtDttm = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss").format(Calendar.getInstance().getTime());

            /**
             * [20240110]
             * Scheduled 등 실제 요청이 아닐 때 RequestContextHolder.currentRequestAttributes 사용시
             * No thread-bound request found 에러가 발생하므로
             * RequestContextHolder.getRequestAttributes()를 통해 requestAttributes 있는지 확인 후 BaseVo Setting
             * */
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

            if(requestAttributes != null) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
                HttpSession session = request.getSession();
                LoginOutVO loginOutVO= (LoginOutVO)session.getAttribute("loginOutVO");

                if(loginOutVO != null) {
                    if(!StringUtils.isBlank(loginOutVO.getEpno())) {
                        optrId = loginOutVO.getEpno();
                    }
                    if(!StringUtils.isBlank(loginOutVO.getConnChnlCd())) {
                        oprtChnlCd = loginOutVO.getConnChnlCd();
                    }
                    if(!StringUtils.isBlank(loginOutVO.getBlngOrzCd())) {
                        oprtOrzCd = loginOutVO.getBlngOrzCd();
                    }
                    if(!StringUtils.isBlank(loginOutVO.getConnIp())) {
                        oprtIpAdr = loginOutVO.getConnIp();
                    }
                }
            }
        }
    }

    public void setOptrId(String optrId) { this.optrId = optrId; }
    public void setOprtChnlCd(String oprtChnlCd) { this.oprtChnlCd = oprtChnlCd; }
    public void setOprtOrzCd(String oprtOrzCd) { this.oprtOrzCd = oprtOrzCd; }
    public void setOprtIpAdr(String oprtIpAdr) { this.oprtIpAdr = oprtIpAdr; }

    public String getOprtDttm() { return oprtDttm; }
    public void setOprtDttm(String oprtDttm) { this.oprtDttm = oprtDttm; }

}
