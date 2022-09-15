package com.lazytreeapi.api.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "region")
public class region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idregion;
    @Column(length = 50,nullable = false)
    private String name;
}
