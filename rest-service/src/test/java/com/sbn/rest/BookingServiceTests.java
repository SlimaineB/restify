package com.sbn.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbn.rest.dto.AmpsRequestForm;
import com.sbn.rest.service.BookingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean 
	private BookingService bookingService;
	
	private JacksonTester<AmpsRequestForm> jsonAmpsRequestForm;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		
		JacksonTester.initFields(this, new ObjectMapper());
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}


	@Test
	public void contextLoads() {
	}

	@Test
	public void testAutorisationRequest() throws Exception {
		
		String jsonRequest = jsonAmpsRequestForm.write(AmpsRequestForm.builder().id(123L).name("A_REQUEST_NAME").build()).getJson();
		
		
		mockMvc.perform(post("/api/amps/autorisation")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"name\": \"REQUEST_MVC\", \"type\": \"RA\"}")				
				).andDo(print()).andExpect(status().isCreated());
	}
	
	
	@Test
	public void testGetRequestNoParameter() throws Exception {

		/* setup mock */
		AmpsRequestForm requestForm = AmpsRequestForm.builder().id(123L).name("A_REQUEST_NAME").build();
		when(bookingService.getRequest(123L)).thenReturn(requestForm);
		
	   mockMvc.perform(get("/api/amps/request/123")
	       .accept(MediaType.APPLICATION_JSON))
	       .andExpect(status().isOk())
	       .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
	       .andExpect(jsonPath("$.id").value(123))
	       .andExpect(jsonPath("$.name").value("A_REQUEST_NAME"));
	}

	@Test
	public void testBadRequest() throws Exception {
		mockMvc.perform(get("/api/amps/autorisation__")).andExpect(status().is(404));
	}



}
