package com.miraeasset.biz.ss.bs.service;

import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.ss.bs.dao.SSBS8000U0Dao;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0In00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0In01VO;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0Out00VO;
import com.miraeasset.biz.ss.bs.vo.SSBS8000U0Out01VO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SSBS8000U0Service {
    private final SSBS8000U0Dao ssbs8000U0Dao;

    public SSBS8000U0Service(SSBS8000U0Dao ssbs8000U0Dao) {
        this.ssbs8000U0Dao = ssbs8000U0Dao;
    }

    public List<SSBS8000U0Out00VO> getCmnKndNo(SSBS8000U0In00VO ssbs8000U0In00VO) {
        return ssbs8000U0Dao.selectList00GA09C301(ssbs8000U0In00VO);
    }

    public int saveCmnKndNo(SSBS8000U0Out00VO ssbs8000U0Out00VO) {
        if(ssbs8000U0Out00VO.getCdKndNo() == null || ssbs8000U0Out00VO.getCdKndNo().isEmpty()) {
            throw new CustomBadRequestException("코드종류를 입력해주세요.", ErrorCode.BAD_REQUEST);
        }
        return ssbs8000U0Dao.merge00GA09C301(ssbs8000U0Out00VO);
    }

    public int deleteCmnKndNo(SSBS8000U0In00VO ssbs8000U0In00VO) {
        if(ssbs8000U0In00VO.getCdKndNo() == null || ssbs8000U0In00VO.getCdKndNo().isEmpty()) {
            throw new CustomBadRequestException("코드종류를 입력해주세요.", ErrorCode.BAD_REQUEST);
        }
        return ssbs8000U0Dao.delete00GA09C301(ssbs8000U0In00VO);
    }

    public List<SSBS8000U0Out01VO> getCmnCdVl(SSBS8000U0In01VO ssbs8000U0In01VO) {
        if(ssbs8000U0In01VO.getCdKndNo() == null || ssbs8000U0In01VO.getCdKndNo().isEmpty()) {
            throw new CustomBadRequestException("코드종류를 입력해주세요.", ErrorCode.BAD_REQUEST);
        }
        return ssbs8000U0Dao.selectList00GA09C302(ssbs8000U0In01VO);
    }

    public int saveCmnCdVl(SSBS8000U0Out01VO ssbs8000U0Out01VO) {
        if(ssbs8000U0Out01VO.getCdKndNo() == null || ssbs8000U0Out01VO.getCdKndNo().isEmpty()) {
            throw new CustomBadRequestException("코드종류를 입력해주세요.", ErrorCode.BAD_REQUEST);
        } else if(ssbs8000U0Out01VO.getCmnCdVl() == null || ssbs8000U0Out01VO.getCmnCdVl().isEmpty()) {
            throw new CustomBadRequestException("공통코드값을 입력해주세요.", ErrorCode.BAD_REQUEST);
        }

        return ssbs8000U0Dao.merge00GA09C302(ssbs8000U0Out01VO);
    }

    public int deleteCmnCdVl(SSBS8000U0In01VO ssbs8000U0In01VO) {
        if(ssbs8000U0In01VO.getCdKndNo() == null || ssbs8000U0In01VO.getCdKndNo().isEmpty()) {
            throw new CustomBadRequestException("코드종류를 입력해주세요.", ErrorCode.BAD_REQUEST);
        } else if(ssbs8000U0In01VO.getCmnCdVl() == null || ssbs8000U0In01VO.getCmnCdVl().isEmpty()) {
            throw new CustomBadRequestException("공통코드값을 입력해주세요.", ErrorCode.BAD_REQUEST);
        }

        return ssbs8000U0Dao.delete00GA09C302(ssbs8000U0In01VO);
    }
}
