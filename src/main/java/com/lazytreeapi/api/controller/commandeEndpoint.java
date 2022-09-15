package com.lazytreeapi.api.controller;

import com.lazytreeapi.api.model.commande;
import com.lazytreeapi.api.repository.commandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class commandeEndpoint {
    @Autowired
    private commandeRepository commandeRepo;

    @GetMapping("/commande")
    @ResponseBody
    public List<commande> getByRegion(){
        return commandeRepo.findAll();
    }
}
