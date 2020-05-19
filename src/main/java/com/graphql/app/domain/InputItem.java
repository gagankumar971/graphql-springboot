package com.graphql.app.domain;

import javax.persistence.Entity;

import lombok.experimental.SuperBuilder;
@Entity
@SuperBuilder
public class InputItem extends Item {
	
	InputItem(){
		super();
	}
}