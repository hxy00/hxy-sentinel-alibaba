package com.hxy.sentinel.service.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderInfo implements Serializable {

    private String orderNo;

    private BigDecimal orderAmt;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(BigDecimal orderAmt) {
        this.orderAmt = orderAmt;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderNo='" + orderNo + '\'' +
                ", orderAmt=" + orderAmt +
                '}';
    }
}
