package com.comerzzia.bookerzzia.backoffice.persistence.lenguajes;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LenguajeMapper {
    long countByExample(LenguajeExample example);

    int deleteByExample(LenguajeExample example);

    int deleteByPrimaryKey(LenguajeKey key);

    int insert(Lenguaje record);

    int insertSelective(Lenguaje record);

    List<Lenguaje> selectByExampleWithRowbounds(LenguajeExample example, RowBounds rowBounds);

    List<Lenguaje> selectByExample(LenguajeExample example);

    Lenguaje selectByPrimaryKey(LenguajeKey key);

    int updateByExampleSelective(@Param("record") Lenguaje record, @Param("example") LenguajeExample example);

    int updateByExample(@Param("record") Lenguaje record, @Param("example") LenguajeExample example);

    int updateByPrimaryKeySelective(Lenguaje record);

    int updateByPrimaryKey(Lenguaje record);
}