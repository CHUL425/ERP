package com.miraeasset.biz.common.util.altok;

import com.miraeasset.biz.common.util.altok.vo.AltokIn00VO;
import com.miraeasset.biz.common.util.altok.vo.AltokIn01VO;
import com.miraeasset.biz.common.util.altok.vo.AltokOut01VO;
import com.miraeasset.biz.common.util.altok.vo.AltokOut02VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class AltokDao {

    @Resource(name="sqlSessionTemplate")
    private final SqlSessionTemplate sqlSessionTemplate;

    public AltokDao(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    /* 발송ID 획득 */
    public String selectOne00FW04N904() {
        return sqlSessionTemplate.selectOne("altok_mapper.selectOne00FW04N904");
    }

    /* 알림톡 발송 */
    public int insert00FW04N904(AltokIn00VO altokIn00VO) {
        return sqlSessionTemplate.insert("altok_mapper.insert00FW04N904", altokIn00VO);
    }

    /* 알림톡 발송 결과 확인 */
    public AltokOut01VO selectOne00FW04N914(AltokIn01VO altokIn01VO) {
        return sqlSessionTemplate.selectOne("altok_mapper.selectOne00FW04N914", altokIn01VO);
    }

    /* 문자메시지 템플릿 상세 */
    public AltokOut02VO selectOne00CS02C071(String letrMsgCd) {
        return sqlSessionTemplate.selectOne("altok_mapper.selectOne00CS02C071", letrMsgCd);
    }

}
