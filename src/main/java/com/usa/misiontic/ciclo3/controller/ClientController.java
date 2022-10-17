package com.usa.misiontic.ciclo3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.usa.misiontic.ciclo3.entities.Client;
import com.usa.misiontic.ciclo3.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody  Client c){
        return clientService.save(c);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Client update(@RequestBody  Client c){
        return clientService.update(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public boolean delete(@PathVariable("id") int id){
        return clientService.delete(id);
    }
}
