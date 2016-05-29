package org.lian.service;

import org.lian.domain.Process;

import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/29.
 */
public interface ProcessService {
    Process findOne(Integer id);
    List<Process> findIndirect(String name , Date startdate , Date enddate);
    Integer addProcess(Process process);
    Process editProcess(Process process);
}
