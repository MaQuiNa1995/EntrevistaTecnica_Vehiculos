package com.ing.interview.presentation;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.ing.interview.InterviewApplication;

@AutoConfigureMockMvc
@SpringBootTest(classes = InterviewApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void givenCarWhenCreateThenReturnIsOk() throws Exception {
		String color = "BLUE";
		String model = "PEUGEOT";

		// given: Request Car
		JSONObject car = new JSONObject();
		car.put("age", 18);
		car.put("color", color);
		car.put("model", model);

		this.mockMvc.perform(post("/car").contentType(APPLICATION_JSON)
		        .content(car.toString()))
		        .andDo(print())
		        // Response Status
		        .andExpect(status().isCreated())
		        .andExpect(content().contentType(APPLICATION_JSON))
		        // Response Body
		        .andExpect(jsonPath("$.model").value(model))
		        .andExpect(jsonPath("$.color").value(color))
		        .andExpect(jsonPath("$.orderDate").exists());
	}

}