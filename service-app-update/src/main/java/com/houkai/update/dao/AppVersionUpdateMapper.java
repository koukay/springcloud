package com.houkai.update.dao;

import com.houkai.common.entity.AppVersionUpdate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppVersionUpdateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppVersionUpdate record);

    int insertSelective(AppVersionUpdate record);

    AppVersionUpdate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppVersionUpdate record);

    int updateByPrimaryKey(AppVersionUpdate record);

    List<AppVersionUpdate> selectByBean(AppVersionUpdate record);
}
