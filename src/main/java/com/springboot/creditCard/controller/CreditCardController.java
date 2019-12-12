package com.springboot.creditCard.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.creditCard.document.CreditCard;
import com.springboot.creditCard.dto.CreditCardEnterDto;
import com.springboot.creditCard.dto.CreditCardPerDto;
import com.springboot.creditCard.service.CreditCardInterface;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/creditCard")
public class CreditCardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreditCardController.class);


	  @Autowired
	 CreditCardInterface service;

	  @GetMapping
	  public Mono<ResponseEntity<Flux<CreditCard>>> toList() {

	    return Mono.just(ResponseEntity.ok()
	          .contentType(MediaType.APPLICATION_JSON).body(service.findAll()));

	  }

	  @GetMapping("/{id}")
	  public Mono<ResponseEntity<CreditCard>> search(@PathVariable String id) {

	    return service.findById(id).map(c -> ResponseEntity.ok()
	      .contentType(MediaType.APPLICATION_JSON).body(c))
	      .defaultIfEmpty(ResponseEntity.notFound().build());

	  }

	  @PostMapping
	  public Mono<ResponseEntity<CreditCard>> save(@RequestBody  CreditCard  creditCard) {


	    return service.save(creditCard).map(e -> ResponseEntity.created(URI.create("/api/creditCard"))
	                  .contentType(MediaType.APPLICATION_JSON).body(e));

	  }

	  @PutMapping("/{id}")
	  public Mono<ResponseEntity<CreditCard>> update(@RequestBody CreditCard creditCard,
	                    @PathVariable String id) {

	    return service.update(creditCard, id)
	             .map(p -> ResponseEntity.created(URI.create("/api/creditCard".concat(p.getId())))
	             .contentType(MediaType.APPLICATION_JSON).body(p))
	             .defaultIfEmpty(ResponseEntity.notFound().build());

	  }

	  @DeleteMapping("/{id}")
	  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {

	    return service.findById(id).flatMap(p -> {
	      return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.ACCEPTED)));
	    }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));

	  }
	  
		@PostMapping("/savePer")
		public Mono<ResponseEntity<CreditCardPerDto>> saveDto(@RequestBody CreditCardPerDto creditCardPerDto) {

			LOGGER.info(creditCardPerDto.toString());

			return service.saveDtoPer(creditCardPerDto).map(s -> ResponseEntity.created(URI.create("/api/creditCard"))
					.contentType(MediaType.APPLICATION_JSON).body(s));

		}
		@PostMapping("/saveEnter")
		public Mono<ResponseEntity<CreditCardEnterDto>> saveDto(@RequestBody CreditCardEnterDto creditCardEnterDto) {

			LOGGER.info(creditCardEnterDto.toString());

			return service.saveDtoEnter(creditCardEnterDto).map(s -> ResponseEntity.created(URI.create("/api/creditCard"))
					.contentType(MediaType.APPLICATION_JSON).body(s));

		}

}
