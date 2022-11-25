package com.example.petshop.service;

import com.example.petshop.domain.Address;
import com.example.petshop.domain.Pet;
import com.example.petshop.dto.NewPetDto;
import com.example.petshop.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetService service;

    @Test
    void shouldReturnPet_GivenId() {
        Pet pet = new Pet();
        pet.setPetId(2);
        pet.setName("Fluffy");
        pet.setAge(6);
        Address address = new Address();
        address.setAddressId(1);
        address.setPetOwner("Ads");
        address.setHouseNumber(8);
        address.setStreet("Hunters Gate");
        address.setPostcode("LA1 5BX");
        pet.setAddress(address);


        Mockito.when(petRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(pet));


        Pet testPet = service.getPet(2);
        Assertions.assertEquals(pet, testPet);

    }



    @Test
    void shouldThrowRunTimeException_GivenNoPetIdIsFound() {

        Assertions.assertThrows(RuntimeException.class, () -> service.getPet(4));
    }

    @Test
    void shouldPostPet_GivenBody() {

        Pet pet = new Pet();
        Address address = new Address();
        pet.setPetId(3);
        pet.setName("John");
        pet.setAge(12);
        pet.setAnimal("Cat");
        address.setAddressId(1);
        address.setPetOwner("Ahu");
        address.setHouseNumber(8);
        address.setStreet("Hunters Gate");
        address.setPostcode("LA15BX");
        pet.setAddress(address);
        Mockito.when(petRepository.save(pet)).thenReturn(pet);

        service.postPet(pet);

        Assertions.assertEquals(3, pet.getPetId());
        Assertions.assertEquals(12, pet.getAge());
        Assertions.assertEquals("John", pet.getName());

        assertThat(pet.getAnimal()).isEqualTo("Cat");
    }



}