package com.lazytreeapi.api.repository;

import com.lazytreeapi.api.model.livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface livreurRepository extends JpaRepository<livreur,Integer> {
    @Query("select l from livreur l where l.disponible=true")
    List<livreur> findAllDisponibile();
    @Query("select l from livreur l where l.disponible=false")
    List<livreur> findAllIndisponibile();
    @Query("select l from livreur l where l.name like lower(concat('%', ?1,'%'))")
    List<livreur> findByNameAndId(String name);
    @Query("select l from livreur l where l.idlivreur=?1")
    List<livreur> findByNameAndId(int id);
    @Query("select l from livreur l where l.disponible=true and l.name like lower(concat('%', ?1,'%'))")
    List<livreur> findByNameDisponibleLivreur(String name);
    @Query("select l from livreur l where l.disponible=false and l.name like lower(concat('%', ?1,'%'))")
    List<livreur> findByNameInDisponibleLivreur(String name);
}
