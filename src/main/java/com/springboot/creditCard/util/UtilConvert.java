package com.springboot.creditCard.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.springboot.creditCard.document.CreditCard;
import com.springboot.creditCard.dto.CreditCardEnterDto;
import com.springboot.creditCard.dto.CreditCardPerDto;

@Component
public class UtilConvert {
	
	
	public CreditCard convertCreditCardPer(CreditCardPerDto creditCardPerDto) {

		CreditCard  creditCard = new CreditCard();

		creditCard.setNameCard("Tarjeta-credito-Personal");
		creditCard.setNumberCard(creditCardPerDto.getNumberCard());
		creditCard.setCodeSecurity(creditCardPerDto.getCodeSecurity());
		creditCard.setDateExpiration(creditCardPerDto.getDateExpiration());
		creditCard.setCreateDate(new Date());
		
		return creditCard;

	}
	
	public CreditCard convertCreditCardEnter(CreditCardEnterDto creditCardEnterDto) {

		CreditCard  creditCard = new CreditCard();

		creditCard.setNameCard("Tarjeta-credito-Empresarial");
		creditCard.setNumberCard(creditCardEnterDto.getNumberCard());
		creditCard.setCodeSecurity(creditCardEnterDto.getCodeSecurity());
		creditCard.setDateExpiration(creditCardEnterDto.getDateExpiration());
		
		return creditCard;

	}

}
