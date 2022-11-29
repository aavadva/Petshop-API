package com.example.petshop.service;

import com.example.petshop.domain.Pet;
import com.example.petshop.domain.Purchase;
import com.example.petshop.repository.PetRepository;
import com.example.petshop.repository.PurchaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PetService {

    private final PetRepository petRepository;

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PetService(PetRepository petRepository, PurchaseRepository purchaseRepository) {
        this.petRepository = petRepository;
        this.purchaseRepository = purchaseRepository;
    }


    public Pet getPet(Integer petId) {

        Optional<Pet> pet = petRepository.findById(petId);

        return pet.orElseThrow(() -> {throw new RuntimeException();});

    }

    public Purchase getPurchase(Integer customerId) {

        Optional<Purchase> purchase = purchaseRepository.findById(customerId);

        return purchase.orElseThrow(() -> {throw new RuntimeException();});
    }

    public void postMultiplePets(List<Pet> pet) {
        petRepository.saveAll(pet);
    }

    public void postPet(Pet pet) {petRepository.save(pet);}

    public void postPurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public List<Pet> getAllPets() {

        return (List<Pet>) petRepository.findAll();
    }

    public List<Purchase> getAllPurchases() {

        return (List<Purchase>) purchaseRepository.findAll();
    }

    public void deletePet(Integer petId) {
        petRepository.deleteById(petId);
    }

}
