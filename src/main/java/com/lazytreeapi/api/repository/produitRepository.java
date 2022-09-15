package com.lazytreeapi.api.repository;

import com.lazytreeapi.api.model.produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface produitRepository extends JpaRepository<produit,Integer> {
    @Query("select p from produit p where p.name like lower(concat('%', ?1,'%'))")
    List<produit> findByname(String name);
    @Query("select p from produit p where p.idproduit=?1")
    List<produit> findByid(Integer id);
    @Query("select p from produit p where p.stock<=?2 and p.stock>=?1")
    List<produit> findStockBetween(Integer higher,Integer lower);
    @Query("select p from produit p where p.stock>=?1")
    List<produit> findByStockHigherThan(Integer higher);
    @Query("select p from produit p where p.stock<=?1")
    List<produit> findByStockLowerThan(Integer lower);
}
