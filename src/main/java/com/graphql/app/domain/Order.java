package com.graphql.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="order1")
@SuperBuilder
@Data
public class Order {
	@Id
    private Integer orderId;
	private String orderNumber;
	private Character orderStatus;
	private Double orderTotal;
    private String orderTitle;
    private String orderText;
    private String orderCategory;
    
    Order(){
    	
    }
    
	/*
	 * public Integer getOrderId() { return orderId; } public void
	 * setOrderId(Integer orderId) { this.orderId = orderId; } public String
	 * getOrderNumber() { return orderNumber; } public void setOrderNumber(String
	 * orderNumber) { this.orderNumber = orderNumber; } public String
	 * getOrderStatus() { return orderStatus; } public void setOrderStatus(String
	 * orderStatus) { this.orderStatus = orderStatus; } public Double
	 * getOrderTotal() { return orderTotal; } public void setOrderTotal(Double
	 * orderTotal) { this.orderTotal = orderTotal; } public String getOrderTitle() {
	 * return orderTitle; } public void setOrderTitle(String orderTitle) {
	 * this.orderTitle = orderTitle; } public String getOrderText() { return
	 * orderText; } public void setOrderText(String orderText) { this.orderText =
	 * orderText; } public String getOrderCategory() { return orderCategory; }
	 * public void setOrderCategory(String orderCategory) { this.orderCategory =
	 * orderCategory; }
	 */	    
}