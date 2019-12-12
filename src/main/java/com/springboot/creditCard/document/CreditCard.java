package com.springboot.creditCard.document;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(collection="creditCard")
public class CreditCard {
	
	@Id
	private String id;
	
	@NotBlank
	private String nameCard;
	
	@NotBlank
	private String numberCard;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateExpiration;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	
	@NotBlank
	private String codeSecurity;

}
