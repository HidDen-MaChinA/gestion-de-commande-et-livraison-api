package com.lazytreeapi.api.repository;

import com.lazytreeapi.api.model.region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface regionRepository extends JpaRepository<region,Integer> {
    @Query("select r from region r where r.idregion=?1")
    List<region> findByid(Integer id);

    @Query("select r from region r where r.name like lower(concat('%', ?1,'%'))")
    List<region> findbyname(String name);
}