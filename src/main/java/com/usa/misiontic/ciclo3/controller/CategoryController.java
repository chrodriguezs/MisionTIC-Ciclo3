package com.usa.misiontic.ciclo3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.usa.misiontic.ciclo3.entities.Category;
import com.usa.misiontic.ciclo3.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody  Category p){
        return categoryService.save(p);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Category update(@RequestBody  Category p){
        return categoryService.update(p);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public boolean delete(@PathVariable("id") int id){
        return categoryService.delete(id);
    }
}
