package com.springboot.creditCard.dto;

import java.util.Date;

import lombok.Data;
@Data
public class CreditCardEnterDto {
	
	private String id;
	private String numberCard;
	private Date dateExpiration;
	private String codeSecurity;
	private EnterpriseDto holder;
	
}
