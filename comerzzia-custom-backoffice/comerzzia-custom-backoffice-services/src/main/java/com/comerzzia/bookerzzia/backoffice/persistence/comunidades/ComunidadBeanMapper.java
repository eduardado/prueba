package com.comerzzia.bookerzzia.backoffice.persistence.comunidades;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ComunidadBeanMapper {

	long countByExample(ComunidadBeanExample example);

	int deleteByExample(ComunidadBeanExample example);

	int deleteByPrimaryKey(ComunidadBeanKey key);

	int insert(ComunidadBean record);

	int insertSelective(ComunidadBean record);

	List<ComunidadBean> selectByExampleWithRowbounds(ComunidadBeanExample example, RowBounds rowBounds);

	List<ComunidadBean> selectByExample(ComunidadBeanExample example);

	ComunidadBean selectByPrimaryKey(ComunidadBeanKey key);

	int updateByExampleSelective(@Param("record") ComunidadBean record, @Param("example") ComunidadBeanExample example);

	int updateByExample(@Param("record") ComunidadBean record, @Param("example") ComunidadBeanExample example);

	int updateByPrimaryKeySelective(ComunidadBean record);

	int updateByPrimaryKey(ComunidadBean record);
}