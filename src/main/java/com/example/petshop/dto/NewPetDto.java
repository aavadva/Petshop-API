package com.example.petshop.dto;

import com.example.petshop.domain.Address;
import com.example.petshop.domain.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NewPetDto {

    private int petId;
    private String name;
    private String petOwner;

}



