package com.miraeasset.biz.ga.vm.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.miraeasset.biz.common.util.CryptoUtil;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraeasset.biz.ga.vm.vo.GAVM1000U0In00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0In01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0Out00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1000U0Out01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In01VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In02VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0In03VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0Out00VO;
import com.miraeasset.biz.ga.vm.vo.GAVM1010U0Out01VO;

@Repository
public class GAVM1000U0DaoImpl implements GAVM1000U0Dao {
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

	/* 임대차량정보관리 조회 */
	@Override
	public List<GAVM1000U0Out00VO> selectList00GA01N201(GAVM1000U0In00VO vo) {
        List<GAVM1000U0Out00VO> resultList = sqlSession.selectList("gavm_mapper.selectList00GA01N201", vo);

        /* [20231030] 암호화컬럼 관련 수정 */
        try {
            // 복호화
            for (GAVM1000U0Out00VO result : resultList) {
                result.setTrOtptNm(CryptoUtil.getDecryption(result.getTrOtptNm()));
                result.setUserNm(CryptoUtil.getDecryption(result.getUserNm()));
            }
            log.info("########### origin List Size:" + resultList);



            // 필터링
            List<GAVM1000U0Out00VO> filteredResultList_1 = new ArrayList<>();
            List<GAVM1000U0Out00VO> filteredResultList_2 = new ArrayList<>();
            if (vo.getUserNm() != null && !!!vo.getUserNm().equals("")) {
                for(GAVM1000U0Out00VO result : resultList) {
                    if (result.getUserNm().contains(vo.getUserNm())) {
                        filteredResultList_1.add(result);
                    }
                }
            } else {
                filteredResultList_1 = resultList;
            }

            if (vo.getEntpNm() != null && !!!vo.getEntpNm().equals("")) {
                for(GAVM1000U0Out00VO result : filteredResultList_1) {
                    if (result.getTrOtptNm().contains(vo.getEntpNm())) {
                        filteredResultList_2.add(result);
                    }
                }
            } else {
                filteredResultList_2 = filteredResultList_1;
            }

            resultList = filteredResultList_2;
            log.info("########### filtered List Size:" + resultList);

            // alcnt, rnum setting
            int i = 1;
            for(GAVM1000U0Out00VO result : resultList) {
                result.setRnum(BigDecimal.valueOf(i++));
                result.setAlCnt(BigDecimal.valueOf(resultList.size()));
            }


//            // 페이징
//            List<GAVM1000U0Out00VO> pagedResultList = resultList;
//
//            if(vo.getPageIndex() != null && !!!vo.getPageIndex().equals("") &&
//                    vo.getPageSize() != null && !!!vo.getPageSize().equals("")) {
//                int pageIndex = vo.getPageIndex().intValue();
//                int pageSize = vo.getPageSize().intValue();
//
//                if(pagedResultList.size() > pageIndex + pageSize) {
//                    pagedResultList = pagedResultList.subList(pageIndex, pageIndex + pageSize);
//                } else if(pagedResultList.size() > pageIndex) {
//                    pagedResultList = pagedResultList.subList(pageIndex, pagedResultList.size());
//                }
//            }
//
//            resultList = pagedResultList;
//            log.info("########### paged List Size:" + resultList);


            return resultList;
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        // 결과값 없는 경우 빈 리스트 반환
        return new ArrayList<GAVM1000U0Out00VO>();
	}
	
	/* 임대차량정보관리 합계 */
	@Override
	public List<GAVM1000U0Out01VO> selectList01GA01N201(GAVM1000U0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gavm_mapper.selectList01GA01N201", vo);
	}
	
	/* 임대차량정보관리 = 중도해지위약금 조회 */
	@Override
	public List<GAVM1010U0Out00VO> selectList02GA01N201(GAVM1010U0In00VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gavm_mapper.selectList02GA01N201", vo);
	}
	
	/* 임대차량정보관리 = 차량정보변경 조회 */
	@Override
	public List<GAVM1010U0Out01VO> selectList03GA01N201(GAVM1010U0In01VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gavm_mapper.selectList03GA01N201", vo);
	}
	
	/* 임대차량정보관리 = 차량정보변경 등록 */
	@Override
	public int insert03GA01N201(GAVM1010U0In02VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("gavm_mapper.insert03GA01N201", vo);
	}
	
	/* 임대차량정보관리 = 차량정보변경 삭제 */
	@Override
	public int update03GA01N201(GAVM1010U0In03VO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("gavm_mapper.update03GA01N201", vo);
	}

	

}
