package com.road.mapper;

import java.util.List;

import com.road.model.easyui.PageInfo;
import com.road.model.entity.SysLog;

public interface SysLogMapper {

	int deleteByPrimaryKey(Long id);

	int insert(SysLog record);

	int insertSelective(SysLog record);

	SysLog selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysLog record);

	int updateByPrimaryKey(SysLog record);

	List<SysLog> findDataGrid(PageInfo<SysLog> pageInfo);

	int findDataGridCount(PageInfo<SysLog> pageInfo);
}