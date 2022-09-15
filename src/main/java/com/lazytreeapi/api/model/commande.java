package com.lazytreeapi.api.model;

import lombok.*;
import org.hibernate.annotations.Any;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;

@Data
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
    @JoinColumn(name = "iduser",nullable = false)
    private int userid;
    @OneToOne(targetEntity = region.class)
    @JoinColumn(name = "idregion",nullable = false)
    private int regionid;
    @ManyToOne(targetEntity = livreur.class)
    @JoinColumn(name = "idlivreur" , nullable = false)
    private int livreurid;
    @ManyToOne(targetEntity = produit.class)
    @JoinColumn(name = "idproduit",nullable = false)
    private int produitid;
    @Column(nullable = false)
    private boolean livrer;
}
