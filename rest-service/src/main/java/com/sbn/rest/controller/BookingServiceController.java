package com.sbn.rest.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sbn.rest.dto.AmpsRequestForm;
import com.sbn.rest.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RefreshScope
@RequestMapping("/api/amps")
@Api("Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
public class BookingServiceController {
	
	private static Logger log = LoggerFactory.getLogger(BookingServiceController.class);
	
	@Autowired
	BookingService bookingService;
	

	@PostMapping("/autorisation")
    @ApiOperation("Create an Autorisation Request")
	public ResponseEntity<Void> requestAutorisation(@RequestBody AmpsRequestForm request, UriComponentsBuilder builder) {
		log.info("Calling autorisation ["+request+"]");

		bookingService.autorisationRequest(request);

		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/request/{id}").buildAndExpand(request.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/boooking")
	public ResponseEntity<Void> requestBooking(@RequestBody AmpsRequestForm request) {
		log.info("Calling boooking ["+request+"]");
		bookingService.bookingRequest(request);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/request/{id}")
    @ApiOperation("Returns a specific amps request by their identifier. 404 if does not exist.")
	public  ResponseEntity<AmpsRequestForm> getRequest(@PathVariable Long id) {
		
		return new ResponseEntity<AmpsRequestForm>(bookingService.getRequest(id), HttpStatus.OK);
	}


	
	@PostMapping("/requests")
	public String getRequest(@Valid @RequestBody AmpsRequestForm request) {
		
		
		return "abc";
	}
}
