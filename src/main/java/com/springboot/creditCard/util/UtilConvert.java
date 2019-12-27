package com.springboot.creditCard.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.springboot.creditCard.document.CreditCard;
import com.springboot.creditCard.dto.CreditCardEnterDto;
import com.springboot.creditCard.dto.CreditCardPerDto;

@Component
public class UtilConvert {
	
	
	public static Date expiration(Date fecha, int dias){
	      if (dias==0) return fecha;
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); 
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  
	      return calendar.getTime(); 
	}
	
	
	public CreditCard convertCreditCardPer(CreditCardPerDto creditCardPerDto) {

		CreditCard  creditCard = new CreditCard();

		
		creditCard.setNameCard("Tarjeta-credito-Personal");
		creditCard.setNumberDoc(creditCardPerDto.getHeadline().getNumDoc());
		creditCard.setNumberCard("505050"+String.valueOf((int)(Math.random()*99999999+1)));
		creditCard.setCodeSecurity(String.valueOf((int)(Math.random()*999+1)));
		creditCard.setBalance(creditCardPerDto.getBalance());
		creditCard.setTea(creditCardPerDto.getTea());
		creditCard.setDateExpiration(expiration(new Date(),365));
		creditCard.setDateCreate(new Date());
		creditCard.setDateUpdate(new Date());

		
		return creditCard;

	}
	
	public CreditCard convertCreditCardEnter(CreditCardEnterDto creditCardEnterDto) {

		CreditCard  creditCard = new CreditCard();

	
		
		creditCard.setNameCard("Tarjeta-credito-Empresarial");
		creditCard.setNumberDoc(creditCardEnterDto.getEnteprise().getNumDoc());
		creditCard.setNumberCard("606060"+String.valueOf((int)(Math.random()*99999999+1)));
		creditCard.setCodeSecurity(String.valueOf((int)(Math.random()*999+1)));
		creditCard.setBalance(creditCardEnterDto.getBalance());
		creditCard.setTea(creditCardEnterDto.getTea());
		creditCard.setDateExpiration(expiration(new Date(),365));
		creditCard.setDateCreate(new Date());
		creditCard.setDateUpdate(new Date());
		
		return creditCard;

	}

}
