package kz.rusty.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import kz.rusty.model.Vehicle;
import kz.rusty.service.VehicleService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=VehicleController.class)
public class VehicleControllerTest {

	@MockBean
	VehicleService vehicleService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void lookupExistingVehicle_shouldReturnJSONObject() throws Exception {
		when(vehicleService.findById(anyLong())).thenReturn(new Vehicle());
		mockMvc.perform(get("/vehicles/111")).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$").isNotEmpty());
	}
	
	@Test
	public void lookupAllVehicles_shouldReturnJSONArray() throws Exception {
		when(vehicleService.findAll()).thenReturn(Arrays.asList(new Vehicle()));
		mockMvc.perform(get("/vehicles")).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$",hasSize(1)));
	}

}
