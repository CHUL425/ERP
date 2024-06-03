package com.miraeasset.biz.br.er.service;

import java.util.List;

import com.miraeasset.biz.br.er.dao.BRER3000U0Dao;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.br.er.vo.BRER3000U0In00VO;
import com.miraeasset.biz.br.er.vo.BRER3000U0Out00VO;

@Service
@Transactional
public class BRER3000U0Service {
	
	private final BRER3000U0Dao brer3000U0Dao;

	public BRER3000U0Service(BRER3000U0Dao brer3000U0Dao) {
		this.brer3000U0Dao = brer3000U0Dao;
	}

	/* 조회 */
	public List<BRER3000U0Out00VO> selectList00GA02N004(BRER3000U0In00VO brer3000U0In00VO) {
		return brer3000U0Dao.selectList00GA02N004(brer3000U0In00VO);
	}

	/* 관리 */
	public int merge00GA02N004(List<BRER3000U0Out00VO> brer3000U0Out00VOList) {
		/* Validation Start */
		if(brer3000U0Out00VOList == null || brer3000U0Out00VOList.size() == 0) {
			throw new CustomBadRequestException("처리할 내역이 없어요.", ErrorCode.BAD_REQUEST);
		}

		for(BRER3000U0Out00VO brer3000U0Out00VO : brer3000U0Out00VOList) {
			if(brer3000U0Out00VO.getOrzCd() == null || brer3000U0Out00VO.getOrzCd().equals("")) {
				throw new CustomBadRequestException("조직코드를 입력해주세요.", ErrorCode.BAD_REQUEST);
			} else if(brer3000U0Out00VO.getTpNm() == null || brer3000U0Out00VO.getTpNm().equals("")) {
				throw new CustomBadRequestException("구분을 입력해주세요.", ErrorCode.BAD_REQUEST);
			}
		}
		/* Validation End */


		int result = 0;
		for(BRER3000U0Out00VO brer3000U0Out00VO : brer3000U0Out00VOList) {
			result += brer3000U0Dao.merge00GA02N004(brer3000U0Out00VO);
		}
		return result;
	}

	/* 삭제 */
	public int delete00GA02N004(List<BRER3000U0In00VO> brer3000U0In00VOList) {
		/* Validation Start */
		if(brer3000U0In00VOList == null || brer3000U0In00VOList.size() == 0) {
			throw new CustomBadRequestException("처리할 내역이 없어요.", ErrorCode.BAD_REQUEST);
		}

		for(BRER3000U0In00VO brer3000U0In00V0 : brer3000U0In00VOList) {
			if(brer3000U0In00V0.getOrzCd() == null || brer3000U0In00V0.getOrzCd().equals("")) {
				throw new CustomBadRequestException("조직코드를 입력해주세요.", ErrorCode.BAD_REQUEST);
			} else if(brer3000U0In00V0.getTpNm() == null || brer3000U0In00V0.getTpNm().equals("")) {
				throw new CustomBadRequestException("구분을 입력해주세요.", ErrorCode.BAD_REQUEST);
			}
		}
		/* Validation End */

		int result = 0;
		for(BRER3000U0In00VO brer3000U0In00VO : brer3000U0In00VOList) {
			result += brer3000U0Dao.delete00GA02N004(brer3000U0In00VO);
		}
		return result;
	}
}
