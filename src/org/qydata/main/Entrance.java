package org.qydata.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qydata.po.*;
import org.qydata.tools.CalendarAssistTool;
import org.qydata.tools.ExcelUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/3/8.
 */
public class Entrance {


    public static void main(String[] args) {
        String resource = "mybatis.xml";
        InputStream is = Entrance.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        try {

            //增删改操作一定要提交事务
            //删除
            String statementDelete = "org.qydata.mapper.CustomerApiTypeConsumeMapper.deleteCustomerConsumeExcel";
            int flag = session.delete(statementDelete);
            session.commit();

            //查询
            String statementSelect = "org.qydata.mapper.CustomerApiTypeConsumeMapper.queryCustomerLastMonthConsume";
            Map<String, Object> mapParam = new HashMap<>();
            mapParam.put("lastDay",CalendarAssistTool.getCurrentDateLastMonthEndDay());
            List<ConsumeTime> consumeTimeList = session.selectList(statementSelect, mapParam);

            /*String statementDetailSelect = "org.qydata.mapper.CustomerApiTypeConsumeMapper.queryCustomerLastMonthConsumeDetail";
            Map<String, Object> mapDetailParam = new HashMap<>();
            mapDetailParam.put("lastDay",CalendarAssistTool.getCurrentDateLastMonthEndDay()+" "+"23:59:59");
            List<ConsumeTime> consumeTimeDetailList = session.selectList(statementDetailSelect, mapDetailParam);


            if (consumeTimeList != null) {
                for (int i = 0; i < consumeTimeList.size(); i++) {
                    ConsumeTime consumeTime = consumeTimeList.get(i);
                    if (consumeTimeDetailList != null) {
                        for (int r = 0; r < consumeTimeDetailList.size(); r++) {
                            ConsumeTime consumeTimeDetail = consumeTimeDetailList.get(r);
                            if (consumeTime.getYearMonth().equals(consumeTimeDetail.getYearMonth())) {
                                consumeTime.setCustomerDetaiLList(consumeTimeDetail.getCustomerDetaiLList());
                            }
                        }

                        List<Customer> customerList = consumeTime.getCustomerList();
                        List<Customer> customerDetailList = consumeTime.getCustomerDetaiLList();
                        if (customerList != null){
                            for (int j=0;j<customerList.size(); j++){
                                Customer customer = customerList.get(j);
                                if (customerDetailList != null){
                                    for (int k=0;k<customerDetailList.size(); k++){
                                        Customer customerDetail = customerDetailList.get(k);
                                        if (customer.getCustomerId() == customerDetail.getCustomerId()){
                                            customer.setCustomerApiTypeConsumeDetailList(customerDetail.getCustomerApiTypeConsumeDetailList());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }*/

            List<CustomerConsumeExcel> customerConsumeExcelList = new ArrayList<>();
            if (consumeTimeList != null) {
                for (int i = 0; i < consumeTimeList.size(); i++) {
                    ConsumeTime consumeTime = consumeTimeList.get(i);
                    List<Customer> customerList = consumeTime.getCustomerList();
                    if (customerList != null) {
                        for (int j = 0; j < customerList.size(); j++) {
                            Customer customer = customerList.get(j);
                            List<CustomerApiTypeConsume> customerApiTypeConsumeList = customer.getCustomerApiTypeConsumeList();
                            List<CustomerApiTypeConsumeDetail> customerApiTypeConsumeDetailList = customer.getCustomerApiTypeConsumeDetailList();
                            Map<String, Object> mapExcelParam = new HashMap<>();
                            mapExcelParam.put("consuTime", consumeTime.getYearMonth());
                            mapExcelParam.put("year", consumeTime.getYear());
                            mapExcelParam.put("month", consumeTime.getMonth());
                            mapExcelParam.put("customerId", customer.getCustomerId());
                            mapExcelParam.put("customerApiTypeConsumeList", customerApiTypeConsumeList);
                            mapExcelParam.put("customerApiTypeConsumeDetailList", customerApiTypeConsumeDetailList);
                            CustomerConsumeExcel customerConsumeExcel = ExcelUtil.createExcel(mapExcelParam);
                            customerConsumeExcelList.add(customerConsumeExcel);
                        }
                    }
                }
            }

            //添加
            if(customerConsumeExcelList.size() > 0) {
                String statementInsert = "org.qydata.mapper.CustomerApiTypeConsumeMapper.insertCustomerConsumeExcel";
                int result = session.insert(statementInsert, customerConsumeExcelList);
                session.commit();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
}
