package org.qydata.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jonhn on 2017/3/8.
 */
public class CustomerApiTypeConsume implements Serializable {
    private Integer id;
    private String yearMonth;
    private Integer apiTypeId;
    private Integer stid;
    private Integer sumAmount;
    private Integer countTotle;
    private Integer countSuccess;
    private Date consuTime;
    private String apiTypeName;
    private String stidName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Integer getApiTypeId() {
        return apiTypeId;
    }

    public void setApiTypeId(Integer apiTypeId) {
        this.apiTypeId = apiTypeId;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public Integer getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Integer sumAmount) {
        this.sumAmount = sumAmount;
    }

    public Integer getCountTotle() {
        return countTotle;
    }

    public void setCountTotle(Integer countTotle) {
        this.countTotle = countTotle;
    }

    public Integer getCountSuccess() {
        return countSuccess;
    }

    public void setCountSuccess(Integer countSuccess) {
        this.countSuccess = countSuccess;
    }

    public Date getConsuTime() {
        return consuTime;
    }

    public void setConsuTime(Date consuTime) {
        this.consuTime = consuTime;
    }

    public String getApiTypeName() {
        return apiTypeName;
    }

    public void setApiTypeName(String apiTypeName) {
        this.apiTypeName = apiTypeName;
    }

    public String getStidName() {
        return stidName;
    }

    public void setStidName(String stidName) {
        this.stidName = stidName;
    }


}
