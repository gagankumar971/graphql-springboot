package com.graphql.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
@Entity
@Table
@Data
@SuperBuilder
@AllArgsConstructor
public class Item {
	@Id
    private Integer itemId;
	private Integer orderId;
	private String itemNumber;
	private Long companyId;
	private String companyName;
    private String itemName;
    private Double itemPrice;
    private Character itemStatus;
    private String thumbnail;
    Item(){
    	
    }
}