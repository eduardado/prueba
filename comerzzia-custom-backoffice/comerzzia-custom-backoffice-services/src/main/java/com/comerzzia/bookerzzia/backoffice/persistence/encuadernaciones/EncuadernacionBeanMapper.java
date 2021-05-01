package com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones;

import com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones.EncuadernacionBean;
import com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones.EncuadernacionBeanExample;
import com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones.EncuadernacionBeanKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EncuadernacionBeanMapper {
    long countByExample(EncuadernacionBeanExample example);

    int deleteByExample(EncuadernacionBeanExample example);

    int deleteByPrimaryKey(EncuadernacionBeanKey key);

    int insert(EncuadernacionBean record);

    int insertSelective(EncuadernacionBean record);

    List<EncuadernacionBean> selectByExampleWithRowbounds(EncuadernacionBeanExample example, RowBounds rowBounds);

    List<EncuadernacionBean> selectByExample(EncuadernacionBeanExample example);

    EncuadernacionBean selectByPrimaryKey(EncuadernacionBeanKey key);

    int updateByExampleSelective(@Param("record") EncuadernacionBean record, @Param("example") EncuadernacionBeanExample example);

    int updateByExample(@Param("record") EncuadernacionBean record, @Param("example") EncuadernacionBeanExample example);

    int updateByPrimaryKeySelective(EncuadernacionBean record);

    int updateByPrimaryKey(EncuadernacionBean record);
}