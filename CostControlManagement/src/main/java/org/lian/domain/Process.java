package org.lian.domain;

import org.apache.ibatis.annotations.Param;

import javax.xml.soap.Text;
import java.util.Date;

/**
 * Created by lianjiangchao on 16/5/24.
 */
public class Process {


    private Integer id;
    private String name;
    private Text description;
    private String type;
    private Date createdate;
    private Double plancost;
    private Double cost;
    private Double price;
    private Double amount;
    private String unit;
    private Department department;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Text getDescription() {
        return description;
    }

    public void setDescription(Text description) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
