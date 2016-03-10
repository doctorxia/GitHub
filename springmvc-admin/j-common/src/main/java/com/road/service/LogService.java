package com.road.service;

import com.road.model.easyui.PageInfo;
import com.road.model.entity.SysLog;

public interface LogService {

    void insertLog(SysLog sysLog);

    void findDataGrid(PageInfo<SysLog> pageInfo);
}
