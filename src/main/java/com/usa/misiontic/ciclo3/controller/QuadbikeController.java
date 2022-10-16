package com.usa.misiontic.ciclo3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.usa.misiontic.ciclo3.entities.Quadbike;
import com.usa.misiontic.ciclo3.service.QuadbikeService;

import java.util.List;

@RestController
@RequestMapping("/api/Quadbike")
public class QuadbikeController {

    @Autowired
    private QuadbikeService quadbikeService;

    @GetMapping("/all")
    public List<Quadbike> getAll(){
        return quadbikeService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody  Quadbike p){
        return quadbikeService.save(p);
    }
}
