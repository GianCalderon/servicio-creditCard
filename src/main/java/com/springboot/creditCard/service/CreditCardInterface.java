package com.springboot.creditCard.service;

import com.springboot.creditCard.document.CreditCard;
import com.springboot.creditCard.dto.CreditCardDto;
import com.springboot.creditCard.dto.CreditCardEnterDto;
import com.springboot.creditCard.dto.CreditCardPerDto;
import com.springboot.creditCard.dto.CreditDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardInterface {

	  public Flux<CreditCard> findAll();
	  
	  public Mono<CreditCard> findById(String id);
	  
	  public Mono<CreditCard> save(CreditCardDto creditCardDto);
	  
	  public Mono<CreditCard> update(CreditCard creditCard,String id);
	  
	  public Mono<Void> delete(CreditCard creditCard);
	  
	  public Mono<CreditCard> saveDtoPer(CreditDto creditDto);
	  
	  public Mono<CreditCard> saveDtoEnter(CreditDto creditDto);
	 	  
	  public Mono<CreditCard> findByNumberCard(String id);

  

	
}
