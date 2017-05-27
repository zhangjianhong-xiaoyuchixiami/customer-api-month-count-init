package org.qydata.po;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jonhn on 2017/5/27.
 */
public class ConsumeTime implements Serializable {

    private String yearMonth;
    private Integer year;
    private Integer month;
    private List<Customer> customerList;
    private List<Customer> customerDetaiLList;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public List<Customer> getCustomerDetaiLList() {
        return customerDetaiLList;
    }

    public void setCustomerDetaiLList(List<Customer> customerDetaiLList) {
        this.customerDetaiLList = customerDetaiLList;
    }
}
