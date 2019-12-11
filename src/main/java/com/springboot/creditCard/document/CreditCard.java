package com.springboot.creditCard.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="creditCard")
public class CreditCard {
	
	@Id
	private String id;
	private String numberCard;
	private String dateExpiration;
	private String codeSecurity;

}
