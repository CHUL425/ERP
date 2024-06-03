package com.miraeasset.biz.common.cm.ds.service;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraeasset.biz.common.cm.ds.dao.CMDS1000V0Dao;
import com.miraeasset.biz.common.cm.ds.vo.CMDS1000V0In00VO;
import com.miraeasset.biz.common.cm.ds.vo.CMDS1000V0Out00VO;
import com.miraeasset.biz.common.exception.CustomNotFoundException;
import com.miraeasset.biz.common.exception.vo.ErrorCode;

@Service
@Transactional
public class CMDS1000V0ServiceImpl implements CMDS1000V0Service {
	
	@Autowired
	CMDS1000V0Dao CMDS1000V0Dao;
	
	/* 기안문서조회 팝업 */
	@Override
	public List<CMDS1000V0Out00VO> select00AT09N401List(CMDS1000V0In00VO vo) {
		// TODO Auto-generated method stub
		List<CMDS1000V0Out00VO> cmds1000V0Out00VOList = CMDS1000V0Dao.select00AT09N401List(vo);

		String baseUrl = "https://mi-square.miraeasset.com/WebSite/Approval/Forms/Form.aspx?piid=";
		String regDrftDocPiidFormat = "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})";
		for(CMDS1000V0Out00VO cmds1000V0Out00VO : cmds1000V0Out00VOList) {
			String drftDocNo = cmds1000V0Out00VO.getDrftDocNo();
			String formattedDrftDocNo = drftDocNo.replaceAll(regDrftDocPiidFormat, "$1-$2-$3-$4-$5");
			cmds1000V0Out00VO.setDrftDocUrl(baseUrl + formattedDrftDocNo);
		}

		return cmds1000V0Out00VOList;
	}	

}
