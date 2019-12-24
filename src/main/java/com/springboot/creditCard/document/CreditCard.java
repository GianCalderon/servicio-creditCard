package com.springboot.creditCard.document;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document(collection="creditCard")
public class CreditCard {
	
	@Id
	private String id;
	
	@NotNull(message = "User's nameCard must not be null")
	private String numberDoc;
	
	@NotNull(message = "User's nameCard must not be null")
	private String nameCard;
	
	@NotNull(message = "User's numberCard must not be null")
	@Indexed(unique = true)
	private String numberCard;
	
	@NotNull(message = "User's codeSecurity must not be null")
	private String codeSecurity;
	
	@NotNull(message = "User's amount must not be null")
	private int balance;
	
	@NotNull(message = "User's tea must not be null")
	private String tea;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateExpiration;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateCreate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateUpdate;
	

}
