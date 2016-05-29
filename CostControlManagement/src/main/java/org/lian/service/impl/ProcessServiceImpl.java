package org.lian.service.impl;

import org.lian.domain.Process;
import org.lian.mapper.ProcessMapper;
import org.lian.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/29.
 */
@Service
@Transactional
public class ProcessServiceImpl implements ProcessService {
    private ProcessMapper processMapper;

    @Autowired public void setProcessMapper(ProcessMapper processMapper) {
        this.processMapper = processMapper;
    }

    @Override
    public Process findOne(Integer id) {
        return processMapper.selectById(id);
    }

    @Override
    public List<Process> findIndirect(String name, Date startdate, Date enddate) {
        return processMapper.selectIndirect(name, startdate, enddate);
    }

    @Override
    public Integer addProcess(Process process) {
         processMapper.insertProcess(process);
         return process.getId();
    }

    @Override
    public Process editProcess(Process process) {
        processMapper.updateProcess(process);
        return  processMapper.selectById(process.getId());
    }
}
