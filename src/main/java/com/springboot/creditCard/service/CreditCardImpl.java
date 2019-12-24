package com.springboot.creditCard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.creditCard.client.EnterpriseClient;
import com.springboot.creditCard.client.PersonalClient;
import com.springboot.creditCard.controller.CreditCardController;
import com.springboot.creditCard.document.CreditCard;
import com.springboot.creditCard.dto.CreditCardEnterDto;
import com.springboot.creditCard.dto.CreditCardPerDto;
import com.springboot.creditCard.repo.CreditCardRepo;
import com.springboot.creditCard.util.UtilConvert;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardImpl implements CreditCardInterface {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreditCardController.class);
	
	
	@Autowired
	CreditCardRepo repo;
	
	@Autowired
	UtilConvert convert;
	
	@Autowired
	PersonalClient webClientPer;
	
	@Autowired
	EnterpriseClient webClientEnter;
	
	@Override
	public Flux<CreditCard> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Mono<CreditCard> findById(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Mono<CreditCard> save(CreditCard creditCard) {
		// TODO Auto-generated method stub
		return repo.save(creditCard);
	}

	@Override
	public Mono<CreditCard> update(CreditCard creditCard, String id) {
		// TODO Auto-generated method stub
	    return repo.findById(id).flatMap(c -> {

	     c.setNumberCard(creditCard.getNumberCard());
	     c.setCodeSecurity(creditCard.getCodeSecurity());
	     c.setDateExpiration(creditCard.getDateExpiration());
	        
	        return repo.save(c);

	      });
	}

	@Override
	public Mono<Void> delete(CreditCard creditCard) {
		// TODO Auto-generated method stub
		return repo.delete(creditCard);
	}

	@Override
	public Mono<CreditCardPerDto> saveDtoPer(CreditCardPerDto creditCardPerDto) {
	
		
		LOGGER.info("service:"+creditCardPerDto.toString());

		return repo.save(convert.convertCreditCardPer(creditCardPerDto)).flatMap(sa -> {
			webClientPer.save(creditCardPerDto.getHeadline()).block();
			creditCardPerDto.setId(sa.getId());
			
			return Mono.just(creditCardPerDto);
		});
	}

	@Override
	public Mono<CreditCardEnterDto> saveDtoEnter(CreditCardEnterDto creditCardEnterDto) {
		
		
		LOGGER.info("service:"+creditCardEnterDto.toString());

		return repo.save(convert.convertCreditCardEnter(creditCardEnterDto)).flatMap(sa -> {

			webClientEnter.save(creditCardEnterDto.getHeadline()).block();

			return Mono.just(creditCardEnterDto);
		});
		
		
	}

}
