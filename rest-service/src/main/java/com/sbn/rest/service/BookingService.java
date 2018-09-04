package com.sbn.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbn.rest.domain.entity.AmpsRequest;
import com.sbn.rest.domain.repository.AmpsRequestRepository;
import com.sbn.rest.dto.AmpsRequestForm;
import com.sbn.rest.exception.AmpsRequestNotFoundException;

@Service
public class BookingService {

	@Autowired
	AmpsRequestRepository  ampsRequestRepository;
	
	@Transactional
	public void autorisationRequest(AmpsRequestForm ampsRequestForm) {
		
		AmpsRequest request = AmpsRequest.builder().name(ampsRequestForm.getName()).type(ampsRequestForm.getType()).build();
		ampsRequestRepository.save(request);
		
		ampsRequestForm.setId(request.getId());
		
		
		
	}
	
	
	public void bookingRequest(AmpsRequestForm ampsRequestForm) {
			
		AmpsRequest request = AmpsRequest.builder().name(ampsRequestForm.getName()).type(ampsRequestForm.getType()).build();
		ampsRequestRepository.save(request);
		
		request.setId(request.getId());
	}
	
	public AmpsRequestForm getRequest(Long id) throws AmpsRequestNotFoundException{
		
		 return ampsRequestRepository.findById(id).map(elem ->   AmpsRequestForm.builder().id(elem.getId()).name(elem.getName()).type(elem.getType()).build()).orElseThrow(() -> new AmpsRequestNotFoundException("No AMPS request found with id " + id));

	}
}
