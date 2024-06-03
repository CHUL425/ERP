package com.miraeasset.biz.br.er.service;

import java.util.List;

import com.miraeasset.biz.br.er.dao.BRER1000U0Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.miraeasset.biz.common.exception.CustomBadRequestException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;
import com.miraeasset.biz.br.er.vo.BRER1000U0In00VO;
import com.miraeasset.biz.br.er.vo.BRER1000U0Out00VO;

@Service
@Transactional
public class BRER1000U0Service {
	
	private final BRER1000U0Dao brer1000U0Dao;

	public BRER1000U0Service(BRER1000U0Dao brer1000U0Dao) {
		this.brer1000U0Dao = brer1000U0Dao;
	}

	/* 조회 */
	public List<BRER1000U0Out00VO> selectList00GA02N002(BRER1000U0In00VO brer1000U0In00VO) {
		List<BRER1000U0Out00VO> brer1000U0Out00VOList = brer1000U0Dao.selectList00GA02N002(brer1000U0In00VO);
		for(BRER1000U0Out00VO brer1000U0Out00VO : brer1000U0Out00VOList) {
			brer1000U0Out00VO.setIstQAll(brer1000U0Out00VO.getIstQAll());
		}
		return brer1000U0Out00VOList;
	}
	
	/* 관리 */
	public int merge00GA02N002(List<BRER1000U0Out00VO> brer1000U0Out00VOList) {
		/* Validation Start */
		if (brer1000U0Out00VOList == null || brer1000U0Out00VOList.size() == 0) {
			throw new CustomBadRequestException("처리할 내역이 없어요.", ErrorCode.BAD_REQUEST);

		}

		for(BRER1000U0Out00VO brer1000U0Out00VO : brer1000U0Out00VOList) {
			if(brer1000U0Out00VO.getOrzCd() == null || brer1000U0Out00VO.getOrzCd().equals("")) {
				throw new CustomBadRequestException("조직코드를 입력해주세요.", ErrorCode.BAD_REQUEST);
			} else if(brer1000U0Out00VO.getTpNm() == null || brer1000U0Out00VO.getTpNm().equals("")) {
				throw new CustomBadRequestException("구분을 입력해주세요.", ErrorCode.BAD_REQUEST);
			}
		}
		/* Validation End */

		int result = 0;
		for(BRER1000U0Out00VO brer1000U0Out00VO : brer1000U0Out00VOList) {
			result += brer1000U0Dao.merge00GA02N002(brer1000U0Out00VO);
		}

		return result;
	}

	/* 삭제 */
	public int delete00GA02N002(List<BRER1000U0In00VO> brer1000U0VOList) {
		/* Validation Start */
		if (brer1000U0VOList == null || brer1000U0VOList.size() == 0) {
			throw new CustomBadRequestException("처리할 내역이 없어요.", ErrorCode.BAD_REQUEST);
		}

		for(BRER1000U0In00VO brer1000U0In00VO : brer1000U0VOList) {
			if(brer1000U0In00VO.getOrzCd() == null || brer1000U0In00VO.getOrzCd().equals("")) {
				throw new CustomBadRequestException("조직코드를 입력해주세요.", ErrorCode.BAD_REQUEST);
			} else if (brer1000U0In00VO.getTpNm() == null || brer1000U0In00VO.getTpNm().equals("")) {
				throw new CustomBadRequestException("구분을 입력해주세요.", ErrorCode.BAD_REQUEST);
			}
		}
		/* Validation End */


		int result = 0;
		for(BRER1000U0In00VO brer1000U0In00VO : brer1000U0VOList) {
			result += brer1000U0Dao.delete00GA02N002(brer1000U0In00VO);
		}
		
		return result;
	}
}
