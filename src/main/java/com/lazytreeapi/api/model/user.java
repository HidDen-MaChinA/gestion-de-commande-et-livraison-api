package com.lazytreeapi.api.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "user")
@Table(name = "\"user\"")
public class user implements Serializable {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;
    @Column(length = 100,nullable = false)
    private String name;
    @Column(length = 100,nullable = false)
    private String password;
    @Column(length = 100,nullable = false)
    private Role role;
    public enum Role{
        user,admin,livreur
    }
}
