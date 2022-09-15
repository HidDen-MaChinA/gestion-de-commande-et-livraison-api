package com.lazytreeapi.api.repository;

import com.lazytreeapi.api.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user,Integer> {

}
