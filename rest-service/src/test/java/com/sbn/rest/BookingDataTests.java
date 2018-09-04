package com.sbn.rest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sbn.rest.domain.entity.AmpsRequest;
import com.sbn.rest.domain.repository.AmpsRequestRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingDataTests {



	@Autowired
	AmpsRequestRepository ampsRequestRepository;

	

	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testCreateRequest() throws Exception {


		AmpsRequest request = AmpsRequest.builder().name("REQUEST_1").type("RA").build();
		ampsRequestRepository.save(request);
		assertNotNull(request.getId());

	}

	


}
