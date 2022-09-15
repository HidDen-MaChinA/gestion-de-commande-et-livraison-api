package com.lazytreeapi.api.repository;

import com.lazytreeapi.api.model.commande;
import com.lazytreeapi.api.model.region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface commandeRepository extends JpaRepository<commande,Integer> {
    @Query("select c.regionid from commande c where c.idcommande=?1")
    List<region> findbyid(int id);

}
