package org.qydata.po;

import java.util.List;

/**
 * Created by jonhn on 2017/5/27.
 */
public class PackageData {

    public String yearMonth;
    public Integer year;
    public Integer month;
    private List<Customer> customerList;
    private List<Customer> customerDetailList;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
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

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Customer> getCustomerDetailList() {
        return customerDetailList;
    }

    public void setCustomerDetailList(List<Customer> customerDetailList) {
        this.customerDetailList = customerDetailList;
    }
}
