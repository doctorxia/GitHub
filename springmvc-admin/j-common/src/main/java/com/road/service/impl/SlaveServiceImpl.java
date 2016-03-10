package com.road.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.road.mapper.SlaveMapper;
import com.road.service.SlaveService;
@Service
public class SlaveServiceImpl implements SlaveService {

    @Autowired
    private SlaveMapper slaveMapper;

    @Override
    //@DataSourceChange(slave = true)
    public Integer count() {
        return slaveMapper.count();
    }


}
