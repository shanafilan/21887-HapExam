package com.hand.om.dto;

/**Auto Generated By Hap Code Generator**/
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Table;
import com.hand.hap.system.dto.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
@ExtensionAttribute(disable=true)
@Table(name = "hap_om_order_headers")
public class OrderHeaders extends BaseDTO {

     public static final String FIELD_HEADER_ID = "headerId";
     public static final String FIELD_ORDER_NUMBER = "orderNumber";
     public static final String FIELD_COMPANY_ID = "companyId";
     public static final String FIELD_ORDER_DATE = "orderDate";
     public static final String FIELD_ORDER_STATUS = "orderStatus";
     public static final String FIELD_CUSTOMER_ID = "customerId";

    public static final String ORDER_STATUS_NEW = "NEW"; //新建
    public static final String ORDER_STATUS_SUBMITED = "SUBMITED"; //已提交
    public static final String ORDER_STATUS_APPROVED = "APPROVED"; //已审批
    public static final String ORDER_STATUS_REJECTED = "REJECTED"; //已拒绝
    public static final String SALEMANAGER = "SALEMANAGER"; //销售管理员角色编码

     @Id
     @GeneratedValue
     private Long headerId; //订单头ID

     @NotEmpty
     @Length(max = 60)
     private String orderNumber; //订单编号

     @NotNull
     private Long companyId; //公司ID
     @Transient
     private String companyNumber; //公司编码
     @Transient
     private String companyName; //公司名称

     @JsonFormat(pattern = "yyyy-MM-dd")
     private Date orderDate; //订单日期

     @NotEmpty
     @Length(max = 30)
     private String orderStatus; //订单状态

     @NotNull
     private Long customerId; //客户ID

     @Transient
     private String customerNumber; //客户编号
     @Transient
     private String customerName;  //客户姓名
     @Transient
     private Long inventoryItemId;  //物料ID
     @Transient
     private BigDecimal orderTotalAmount; //订单总金额

     public void setHeaderId(Long headerId){
         this.headerId = headerId;
     }

     public Long getHeaderId(){
         return headerId;
     }

     public void setOrderNumber(String orderNumber){
         this.orderNumber = orderNumber;
     }

     public String getOrderNumber(){
         return orderNumber;
     }

     public void setCompanyId(Long companyId){
         this.companyId = companyId;
     }

     public Long getCompanyId(){
         return companyId;
     }

     public void setOrderDate(Date orderDate){
         this.orderDate = orderDate;
     }

     public Date getOrderDate(){
         return orderDate;
     }

     public void setOrderStatus(String orderStatus){
         this.orderStatus = orderStatus;
     }

     public String getOrderStatus(){
         return orderStatus;
     }

     public void setCustomerId(Long customerId){
         this.customerId = customerId;
     }

     public Long getCustomerId(){
         return customerId;
     }

    public String getCompanyNumber() { return companyNumber;}

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public BigDecimal getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    @Override
    public String toString() {
        return "OrderHeaders{" +
                "headerId=" + headerId +
                ", orderNumber='" + orderNumber + '\'' +
                ", companyId=" + companyId +
                ", companyNumber='" + companyNumber + '\'' +
                ", companyName='" + companyName + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", customerId=" + customerId +
                ", customerNumber='" + customerNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", inventoryItemId=" + inventoryItemId +
                ", orderTotalAmount=" + orderTotalAmount +
                '}';
    }
}
