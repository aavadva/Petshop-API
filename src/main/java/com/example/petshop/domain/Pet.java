package com.example.petshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
@Builder
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Integer petId;
    private String name;
    private String animal;
    private int age;
    private float price;
//    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_add_id")
    private Address address;

}



