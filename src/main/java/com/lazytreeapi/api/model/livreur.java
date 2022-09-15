package com.lazytreeapi.api.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "livreur")
public class livreur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idlivreur;
    @Column(length = 100,nullable = false)
    private String name;
    private boolean disponible;
}
