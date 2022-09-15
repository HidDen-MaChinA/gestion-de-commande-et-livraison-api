package com.lazytreeapi.api.controller;

import com.lazytreeapi.api.model.region;
import com.lazytreeapi.api.repository.regionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class regionEndpoint {
    @Autowired
    public regionRepository regionRepo;

    @GetMapping("/region")
    @ResponseBody
    public List<region> findRegionByIdOrName(@RequestParam(required = false) String name,@RequestParam(required = false) Integer id){
        if(name!=null && id==null){
            return regionRepo.findbyname(name);
        }
        if(name==null && id!=null){
            return regionRepo.findByid(id);
        }
        if(name!=null && id!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"only on of them");
        }
        else{
            return regionRepo.findAll();
        }
    }
}
