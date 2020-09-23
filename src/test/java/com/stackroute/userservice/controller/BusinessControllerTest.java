package com.stackroute.userservice.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.application.Crud.controller.BusinessController;
import com.example.application.Crud.model.Business;
import com.example.application.Crud.services.BusinessService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(BusinessControllerTest.class)
public class BusinessControllerTest {

	private Business business;
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BusinessService businessService;

	@InjectMocks
	private BusinessController userController;

	@org.junit.Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		business = new Business(1, "Cognizant", "4785961235", "78542133", "23-09-2020","23-09-2020");
	}

	@Test
	public void testAddBusiness() throws Exception {
		when(businessService.saveBusiness(business)).thenReturn(true);

		mockMvc.perform(post("/business/add").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(jsonToString(business))).andExpect(status().isCreated());

		verify(businessService, times(1)).saveBusiness(Mockito.any(Business.class));
		Mockito.verifyNoMoreInteractions(businessService);

	}
	
	@Test
	public void testUpdateBusiness() throws Exception {
		when(businessService.updateBusiness(business,1)).thenReturn(true);

		mockMvc.perform(post("/business/update/{id}").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(jsonToString(business))).andExpect(status().isCreated());

		verify(businessService, times(1)).updateBusiness(Mockito.any(Business.class),1);
		Mockito.verifyNoMoreInteractions(businessService);

	}



	private static String jsonToString(final Object obj) throws JsonProcessingException {
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			result = jsonContent;
		} catch (JsonProcessingException e) {
			result = "json processing error";
		}
		return result;
	}

}