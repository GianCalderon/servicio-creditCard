package com.springboot.creditCard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.creditCard.document.CreditCard;
import com.springboot.creditCard.repo.CreditCardRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardImpl implements CreditCardInterface {

	@Autowired
	CreditCardRepo repo;
	
	
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

}
