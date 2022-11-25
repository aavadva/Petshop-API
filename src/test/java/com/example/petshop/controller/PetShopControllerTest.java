package com.example.petshop.controller;

import com.example.petshop.domain.Pet;
import com.example.petshop.dto.NewPetDto;
import com.example.petshop.service.PetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(PetShopController.class)
public class PetShopControllerTest {


    private MockMvc mockMvc;

    @MockBean
    private PetService petService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void shouldReturnAllPets_whenGetAllPetsRequestCalled() throws Exception {

        List<Pet> pets = List.of(new Pet());

        List<NewPetDto> expectedResponse = List.of(new NewPetDto());


        Mockito.when(petService.getAllPets()).thenReturn(pets);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/get")
                        .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertEquals(objectMapper.writeValueAsString(expectedResponse), mvcResult.getResponse().getContentAsString());

    }



}
