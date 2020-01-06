package com.springboot.creditCard.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.creditCard.client.EnterpriseClient;
import com.springboot.creditCard.client.PersonalClient;
import com.springboot.creditCard.controller.CreditCardController;
import com.springboot.creditCard.document.CreditCard;
import com.springboot.creditCard.dto.CreditCardDto;
import com.springboot.creditCard.dto.CreditDto;
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
	PersonalClient clientPer;
	
	@Autowired
	EnterpriseClient clientEnt;
	
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
	public Mono<CreditCard> save(CreditCardDto creditCardDto) {
		// TODO Auto-generated method stub
		return repo.save(convert.creditCardPer(creditCardDto));
	}

	@Override
	public Mono<CreditCard> update(CreditCard creditCard, String id) {
		// TODO Auto-generated method stub
	    return repo.findById(id).flatMap(tarjeta -> {

	     tarjeta.setNumberCard(creditCard.getNumberCard());
	     tarjeta.setCodeSecurity(creditCard.getCodeSecurity());
	     tarjeta.setDateExpiration(creditCard.getDateExpiration());
	     tarjeta.setTea(creditCard.getTea());
	     tarjeta.setBalance(creditCard.getBalance());
	     tarjeta.setAvailableBalance(creditCard.getAvailableBalance());
	     tarjeta.setDateUpdate(new Date ());
	        
	        return repo.save(tarjeta);

	      });
	}

	@Override
	public Mono<Void> delete(CreditCard creditCard) {
		// TODO Auto-generated method stub
		return repo.delete(creditCard);
	}

	@Override
	public Mono<CreditCard> saveDtoPer(CreditDto creditDto) {

		LOGGER.info("service:"+creditDto.toString());
		
		
		return clientPer.findByNumDoc(creditDto.getNumDoc()).flatMap(personal->{
			
			return repo.save(convert.convertCreditCardPer(creditDto));
		});

	}

	@Override
	public Mono<CreditCard> saveDtoEnter(CreditDto creditDto) {
		
		
		LOGGER.info("service:"+creditDto.toString());

        return clientEnt.findByNumDoc(creditDto.getNumDoc()).flatMap(enterprise->{
			
			return repo.save(convert.convertCreditCardEnt(creditDto));
		});
		
		
	}

	@Override
	public Mono<CreditCard> findByNumberCard(String numberCard) {
		
		return repo.findByNumberCard(numberCard);
	}

}
