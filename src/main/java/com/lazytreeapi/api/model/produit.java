package com.lazytreeapi.api.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "produit")
public class produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproduit;
    @Column(length = 50,nullable = false)
    private String name;
    @Column(length = 250,nullable = false)
    private String description;
    private int stock;
}
