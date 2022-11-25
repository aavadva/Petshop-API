package com.example.petshop.repository;

import com.example.petshop.domain.Address;
import com.example.petshop.domain.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

}
