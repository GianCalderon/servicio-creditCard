package com.springboot.creditCard.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springboot.creditCard.document.CreditCard;

public interface CreditCardRepo extends ReactiveMongoRepository<CreditCard, String> {

}
