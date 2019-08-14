package com.hcl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.matrimony.controller.UserRegistrationController;
import com.hcl.matrimony.dto.RegistrationDto;
import com.hcl.matrimony.service.UserRegistreationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class TestRegistrationController {

	@InjectMocks
	private UserRegistrationController userRegistrationController;

	@Mock
	private UserRegistreationServiceImpl userRegistreationServiceImpl;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userRegistrationController).build();
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testRegistration() throws Exception {
		RegistrationDto registrationDto = new RegistrationDto("Laxman", "laxman123", LocalDate.of(2019, Month.JULY, 10),
				"Bangalore", "Male", 9035468989l, "Working", "Gold");
		
		mockMvc.perform(MockMvcRequestBuilders.post("/profile").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(registrationDto))).andExpect(status().isCreated());


	}
}
