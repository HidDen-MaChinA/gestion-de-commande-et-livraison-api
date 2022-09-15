package com.lazytreeapi.api.model;

import lombok.*;
import org.hibernate.annotations.Any;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "commande")
@Table(name = "commande")
public class commande implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcommande;
    @ManyToOne(targetEntity = user.class)
    @JoinColumn(name = "id_user",nullable = false)
    private int iduser;
    @OneToOne(targetEntity = region.class)
    @JoinColumn(name = "id_region",nullable = false)
    private int idregion;
    @ManyToOne(targetEntity = livreur.class)
    @JoinColumn(name = "id_livreur" , nullable = false)
    private int idlivreur;
    @ManyToOne(targetEntity = produit.class)
    @JoinColumn(name = "id_produit",nullable = false)
    private int idproduit;
    @Column(nullable = false)
    private boolean livrer;
}
