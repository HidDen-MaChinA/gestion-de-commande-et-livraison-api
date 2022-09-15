package com.lazytreeapi.api.controller;

import com.lazytreeapi.api.model.produit;
import com.lazytreeapi.api.repository.produitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class produitController {
    @Autowired
    public produitRepository produitRepo;

    @GetMapping("/produit")
    @ResponseBody
    public List<produit> getNameOrId(@RequestParam(required = false) Integer id,@RequestParam(required = false) String name){
        if(name!=null&& id!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"only id or only name");
        }
        if(name==null && id!=null){
            return produitRepo.findByid(id);
        }
        if(name!=null && id == null){
            return produitRepo.findByname(name);
        }
        else{return produitRepo.findAll();}
    }
    @GetMapping("/produit/stock")
    @ResponseBody
    public List<produit> getproduit(@RequestParam(required = false) Integer higherThan,@RequestParam(required = false) Integer lowerThan){
        if(higherThan!=null && lowerThan==null){
            return produitRepo.findByStockHigherThan(higherThan);
        }
        if(higherThan==null && lowerThan!=null){
            return produitRepo.findByStockLowerThan(higherThan);
        }
        else{return produitRepo.findStockBetween(higherThan,lowerThan);}
    }
}
