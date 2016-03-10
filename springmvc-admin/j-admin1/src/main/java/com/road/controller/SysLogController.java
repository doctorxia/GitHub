package com.road.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.road.model.easyui.PageInfo;
import com.road.model.entity.SysLog;
import com.road.service.LogService;

/**
 * @description：日志管理
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private LogService logService;


    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String manager() {
        return "/admin/syslog";
    }

    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<SysLog> dataGrid(SysLog sysLog, Integer page, Integer rows) {
        PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(page, rows);
        Map<String, Object> condition = Maps.newHashMap();
        pageInfo.setCondition(condition);
        logService.findDataGrid(pageInfo);
        return pageInfo;
    }
}
