package com.springboot.creditCard.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.springboot.creditCard.document.CreditCard;
import com.springboot.creditCard.dto.CreditCardDto;
import com.springboot.creditCard.dto.CreditDto;

@Component
public class UtilConvert {
	
	
	public static Date expiration(Date fecha, int dias){
	      if (dias==0) return fecha;
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); 
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  
	      return calendar.getTime(); 
	}
	
	
	public CreditCard convertCreditCardPer(CreditDto creditDto) {

		CreditCard  creditCard = new CreditCard();

		
		creditCard.setNameCard("Tarjeta-credito-Personal");
		creditCard.setNumDoc(creditDto.getNumDoc());
		creditCard.setNumberCard("505050"+String.valueOf((int)(Math.random()*99999999+1)));
		creditCard.setCodeSecurity(String.valueOf((int)(Math.random()*999+1)));
		creditCard.setBalance(creditDto.getBalance());
		creditCard.setAvailableBalance(creditDto.getBalance());
		creditCard.setTea(10.0);
		creditCard.setDateExpiration(expiration(new Date(),365));
		creditCard.setDateCreate(new Date());
		creditCard.setDateUpdate(new Date());

		
		return creditCard;

	}
	
	public CreditCard convertCreditCardEnt(CreditDto creditDto) {

		CreditCard  creditCard = new CreditCard();

	
		
		creditCard.setNameCard("Tarjeta-credito-Empresarial");
		creditCard.setNumDoc(creditDto.getNumDoc());
		creditCard.setNumberCard("606060"+String.valueOf((int)(Math.random()*99999999+1)));
		creditCard.setCodeSecurity(String.valueOf((int)(Math.random()*999+1)));
		creditCard.setBalance(creditDto.getBalance());
		creditCard.setAvailableBalance(creditDto.getBalance());
		creditCard.setTea(20.0);
		creditCard.setDateExpiration(expiration(new Date(),365));
		creditCard.setDateCreate(new Date());
		creditCard.setDateUpdate(new Date());
		
		return creditCard;

	}
	
	public CreditCard creditCardPer(CreditCardDto creditCardDto ) {
		CreditCard  creditCard = new CreditCard();

		
		creditCard.setNameCard("Tarjeta-credito-Personal");
		creditCard.setNumDoc(creditCardDto.getDni());
		creditCard.setNumberCard("505050"+String.valueOf((int)(Math.random()*99999999+1)));
		creditCard.setCodeSecurity(String.valueOf((int)(Math.random()*999+1)));
		creditCard.setBalance(creditCardDto.getBalance());
		creditCard.setAvailableBalance(creditCardDto.getBalance());
		creditCard.setTea(18.0);
		creditCard.setDateExpiration(expiration(new Date(),365));
		creditCard.setDateCreate(new Date());
		creditCard.setDateUpdate(new Date());

		
		return creditCard;

	}

}
