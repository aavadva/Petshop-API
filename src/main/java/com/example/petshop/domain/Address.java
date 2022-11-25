package com.example.petshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import javax.transaction.Transactional;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Builder
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "add_id")
    private Integer addressId;
    private String petOwner;
    private int houseNumber;
    private String Street;
    private String postcode;

//    @Override
//    public boolean equals(Object other) {
//        if (!(other instanceof Address)){
//            return false;
//        }
//        if (!this.addressId.equals(((Address) other).addressId)) {
//            return false;
//        }
//        if (!this.petOwner.equals(((Address) other).petOwner)) {
//            return false;
//        }
//        if (this.houseNumber != ((Address) other).houseNumber) {
//            return false;
//        }
//        if (!this.Street.equals(((Address) other).Street)) {
//            return false;
//        }
//        if (!this.postcode.equals(((Address) other).postcode)) {
//            return false;
//        }
//
//        return true;
//    }
//
//
//
//    @JsonBackReference
//    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
//    private Pet pet;
}
