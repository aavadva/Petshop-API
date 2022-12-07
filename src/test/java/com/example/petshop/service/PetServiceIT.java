package com.example.petshop.service;


import com.example.petshop.PetshopApplication;
import com.example.petshop.domain.Address;
import com.example.petshop.domain.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@ActiveProfiles("it")
@SpringBootTest(classes = PetshopApplication.class)
@ExtendWith(SpringExtension.class)
class PetServiceIT {

//    @Autowired
//    private PetService petService;
//
//
//    @Test
//    @Sql("classpath:existingPet.sql")
//    void shouldReturnPet() {
//
//
//        Pet pet = Pet.builder().petId(1).name("Woody").price(167.99f).age(1).animal("Lion").address(Address.builder().addressId(1)
//                .petOwner("Aadil").Street("Hunters Gate").houseNumber(8).postcode("LA15BX").build()).build();
//
//
//        Pet testPet = petService.getPet(1);
//
//        Assertions.assertEquals(pet, testPet);
//
//    }

}


