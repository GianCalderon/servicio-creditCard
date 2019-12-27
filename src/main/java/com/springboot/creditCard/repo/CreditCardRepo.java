package com.springboot.creditCard.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.creditCard.document.CreditCard;

import reactor.core.publisher.Mono;

public interface CreditCardRepo extends ReactiveMongoRepository<CreditCard, String> {
	
	Mono<CreditCard>findByNumberCard (String numberCard);

}
