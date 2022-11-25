package com.example.petshop.service;

import com.example.petshop.domain.Pet;
import com.example.petshop.dto.NewPetDto;
import com.example.petshop.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    public Pet getPet(Integer petId) {

        Optional<Pet> pet = petRepository.findById(petId);

        return pet.orElseThrow(() -> {throw new RuntimeException();});

    }

    public void postMultiplePets(List<Pet> pet) {
        petRepository.saveAll(pet);
    }

    public void postPet(Pet pet) {petRepository.save(pet);}

    public List<Pet> getAllPets() {

        return (List<Pet>) petRepository.findAll();
    }

    public void deletePet(Integer petId) {
        petRepository.deleteById(petId);
    }

}
