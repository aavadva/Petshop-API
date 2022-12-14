package com.example.petshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Integer customerId;
    private String customerName;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pet_id")
    private Pet pet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_add_id")
    private Address address;





}
