package com.lazytreeapi.api.controller;

import com.lazytreeapi.api.model.livreur;
import com.lazytreeapi.api.repository.livreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class livreurEndpoint {
    @Autowired
    private livreurRepository livreurRepo;

    @GetMapping("/livreur")
    @ResponseBody
    public List<livreur> findByIdAndName(@RequestParam(required = false) String name,@RequestParam(required = false) Integer id){
        if(id!=null && name!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"should only be id or name");
        }
        if(name==null && id!=null){
            return livreurRepo.findByNameAndId(id);
        }
        if(id==null&&(name!=null)){
            return livreurRepo.findByNameAndId(name);
        }
        else{
            return livreurRepo.findAll();
        }
    }
    @GetMapping("/livreur/disponible")
    @ResponseBody
    public List<livreur> findAllDispo(@RequestParam(required = false) String name){
        if(name==null) {
            return livreurRepo.findAllDisponibile();
        }
        else {return livreurRepo.findByNameDisponibleLivreur(name);}
    }
    @GetMapping("/livreur/indisponible")
    @ResponseBody
    public List<livreur> findAllInDispo(@RequestParam(required = false) String name){
        if(name==null) {
            return livreurRepo.findAllIndisponibile();
        }
        else{return livreurRepo.findByNameInDisponibleLivreur(name);}
    }
}
