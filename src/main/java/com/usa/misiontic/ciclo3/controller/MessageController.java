package com.usa.misiontic.ciclo3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.usa.misiontic.ciclo3.entities.Message;
import com.usa.misiontic.ciclo3.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody  Message p){
        return messageService.save(p);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Message update(@RequestBody  Message p){
        return messageService.update(p);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public boolean delete(@PathVariable("id") int id){
        return messageService.delete(id);
    }
}
