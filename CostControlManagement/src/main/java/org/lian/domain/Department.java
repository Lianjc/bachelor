package org.lian.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by lianjiangchao on 16/5/24.
 */
public class Department {

    private Integer id;
    private User user;
    private String description;
    private Date createdate;
    private Double plancost;
    private Double cost;

    private List<Process> processes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Double getPlancost() {
        return plancost;
    }

    public void setPlancost(Double plancost) {
        this.plancost = plancost;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }
}
