package com.springboot.creditCard.service;

import com.springboot.creditCard.document.CreditCard;
import com.springboot.creditCard.dto.CreditCardEnterDto;
import com.springboot.creditCard.dto.CreditCardPerDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardInterface {

	  public Flux<CreditCard> findAll();
	  
	  public Mono<CreditCard> findById(String id);
	  
	  public Mono<CreditCard> save(CreditCard creditCard);
	  
	  public Mono<CreditCard> update(CreditCard creditCard,String id);
	  
	  public Mono<Void> delete(CreditCard creditCard);
	  
	  public Mono<CreditCardPerDto> saveDtoPer(CreditCardPerDto creditCardPerDto);
	  
	  public Mono<CreditCardEnterDto> saveDtoEnter(CreditCardEnterDto creditCardEnterDto);
  

	
}
