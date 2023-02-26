package bsuir.labs.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bsuir.labs.controllers.DivideController;
import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.core.dtos.ResultDTO;
import bsuir.labs.services.api.IDivide;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DivideController.class)
public class DivideControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDivide service;

    @Test
    public void testGetEndpoint_withValidInput_shouldReturnResultDTO() throws Exception {
        InputDTO inputDTO = new InputDTO();
        inputDTO.setDivisible(10.0);
        inputDTO.setDivisor(2.0);

        ResultDTO expectedResult = new ResultDTO(5L, 0L);

        when(service.get(Mockito.any(InputDTO.class))).thenReturn(expectedResult);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/divide")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(inputDTO));

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.remains").value(0));
    }

    @Test
    public void testGetEndpoint_withDivisorZero_shouldReturnBadRequest() throws Exception {
        InputDTO inputDTO = new InputDTO();
        inputDTO.setDivisible(10.0);
        inputDTO.setDivisor(0.0);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/divide")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(inputDTO));

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("divisor - Value must not be zero"));
    }
}