package com.example.petshop.controller;

import com.example.petshop.domain.Address;
import com.example.petshop.domain.Pet;
import com.example.petshop.domain.Purchase;
import com.example.petshop.dto.NewPetDto;
import com.example.petshop.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class PetShopController {

    @Value("${petshop.logger}")
    private String message;

    private PetService service;

    private Logger logger;

    private ModelMapper modelMapper = new ModelMapper();



    public PetShopController(PetService petService) {
        this.logger = Logger.getGlobal();
        this.service = petService;
        TypeMap<Pet,NewPetDto> propertyMapper = this.modelMapper.createTypeMap(Pet.class,NewPetDto.class);
        propertyMapper.addMappings(mapping -> mapping.map(source -> source.getAddress().getPetOwner(), NewPetDto::setPetOwner));
    }

    @PostConstruct
    void print() {
        log.info("active petshop profile: {}", message);
    }

    private NewPetDto convertEntityToDto(Pet pet, Address address){

        NewPetDto newPetDto = new NewPetDto();
        return modelMapper.map(pet, NewPetDto.class);

    }

    @GetMapping(path = "/get")
    public List<NewPetDto> getAllPets() {
        return service.getAllPets()
                .stream()
                .map(p -> this.convertEntityToDto(p, p.getAddress()))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/purchase")
    public List<Purchase> getAllPurchases() {
        return service.getAllPurchases();
    }

    @GetMapping(path = "/get/{petId}")
    public Pet getPet(@PathVariable Integer petId) {
        logger.log(Level.INFO, "Pet message received");
        return service.getPet(petId);

    }

    @GetMapping(path = "/get/purchase/{customerId}")
    public Purchase getPurchase(@PathVariable Integer customerId) throws InterruptedException {
        logger.log(Level.INFO, "Pet message received");
        return service.getPurchase(customerId);

    }

    @PostMapping(path = "/addpet")
    public void addPet(@RequestBody Pet pet) {service.postPet(pet);}

    @PostMapping(path = "/purchase")
    public ResponseEntity<String> purchaseConfirmed(@RequestBody Purchase purchase) {

        service.postPurchase(purchase);
        return ResponseEntity.ok("Data Saved");

    }

    @PostMapping(path = "/addpets")
    public ResponseEntity<String> addMultiplePets(@RequestBody List<Pet> pet) {

        service.postMultiplePets(pet);
        return ResponseEntity.ok("Data saved");
    }

    @DeleteMapping(path = "/delete/{petId}")
    public void deletePet(@PathVariable Integer petId){
        service.deletePet(petId);
    }


}
