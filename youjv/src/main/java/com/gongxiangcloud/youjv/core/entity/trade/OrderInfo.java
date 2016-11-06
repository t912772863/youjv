package com.gongxiangcloud.youjv.core.entity.trade;

import javax.persistence.*;
import java.util.Date;

/**
 * 订单信息表(用户参加付费活动的支付表)
 * Created by tianxiong on 16/10/9.
 */
@Entity
@Table(name = "order_info", schema = "sns", catalog = "")
public class OrderInfo {
    /** 订单在我方平台的ID(唯一标识)*/
    private long id;
    /** 第三方平台的订单ID*/
    private String thirdOrderId;
    /** 第三方平台类型: 1,微信;   2支付宝*/
    private int thirdType;
    /** 订单总金额(单位:分)*/
    private int totalAmount;
    /** 订单优惠金额(单位:分)*/
    private int favorableAmount;
    /** 实际支付金额(单位:分)*/
    private int payAmount;
    /** 优惠描述:(如:微信随机立减)*/
    private String favorableDescription;
    /** 创建时间*/
    private Date createTime;
    /** 更新时间*/
    private Date updateTime;
    /** 订单描述(如:参与红树林骑行,个人AA30元)*/
    private String remark;
    /** 订单状态:1未支付; 2支付成功; 3已退款;*/
    private int orderStatus;
    /** 数据状态:-1删除; 1正常*/
    private int status;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "THIRD_ORDER_ID", nullable = false, length = 30)
    public String getThirdOrderId() {
        return thirdOrderId;
    }

    public void setThirdOrderId(String thirdOrderId) {
        this.thirdOrderId = thirdOrderId;
    }

    @Basic
    @Column(name = "THIRD_TYPE", nullable = false)
    public int getThirdType() {
        return thirdType;
    }

    public void setThirdType(int thirdType) {
        this.thirdType = thirdType;
    }

    @Basic
    @Column(name = "TOTAL_AMOUNT", nullable = false)
    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Basic
    @Column(name = "FAVORABLE_AMOUNT", nullable = false)
    public int getFavorableAmount() {
        return favorableAmount;
    }

    public void setFavorableAmount(int favorableAmount) {
        this.favorableAmount = favorableAmount;
    }

    @Basic
    @Column(name = "PAY_AMOUNT", nullable = false)
    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    @Basic
    @Column(name = "FAVORABLE_DESCRIPTION", nullable = false, length = 100)
    public String getFavorableDescription() {
        return favorableDescription;
    }

    public void setFavorableDescription(String favorableDescription) {
        this.favorableDescription = favorableDescription;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "UPDATE_TIME", nullable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "REMARK", nullable = false, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "ORDER_STATUS", nullable = false)
    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "STATUS", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfo orderInfo = (OrderInfo) o;

        if (id != orderInfo.id) return false;
        if (thirdType != orderInfo.thirdType) return false;
        if (totalAmount != orderInfo.totalAmount) return false;
        if (favorableAmount != orderInfo.favorableAmount) return false;
        if (payAmount != orderInfo.payAmount) return false;
        if (orderStatus != orderInfo.orderStatus) return false;
        if (status != orderInfo.status) return false;
        if (thirdOrderId != null ? !thirdOrderId.equals(orderInfo.thirdOrderId) : orderInfo.thirdOrderId != null)
            return false;
        if (favorableDescription != null ? !favorableDescription.equals(orderInfo.favorableDescription) : orderInfo.favorableDescription != null)
            return false;
        if (createTime != null ? !createTime.equals(orderInfo.createTime) : orderInfo.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(orderInfo.updateTime) : orderInfo.updateTime != null) return false;
        if (remark != null ? !remark.equals(orderInfo.remark) : orderInfo.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (thirdOrderId != null ? thirdOrderId.hashCode() : 0);
        result = 31 * result + thirdType;
        result = 31 * result + totalAmount;
        result = 31 * result + favorableAmount;
        result = 31 * result + payAmount;
        result = 31 * result + (favorableDescription != null ? favorableDescription.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + orderStatus;
        result = 31 * result + status;
        return result;
    }
}
