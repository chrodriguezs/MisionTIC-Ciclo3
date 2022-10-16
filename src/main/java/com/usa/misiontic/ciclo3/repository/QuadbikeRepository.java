package com.usa.misiontic.ciclo3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.misiontic.ciclo3.entities.Quadbike;
import com.usa.misiontic.ciclo3.repository.crudRepository.QuadbikeCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuadbikeRepository {
    @Autowired
    private QuadbikeCrudRepository QuadbikeCrudRepository;

    public List<Quadbike> getAll(){
        return (List<Quadbike>) QuadbikeCrudRepository.findAll();
    }

    public Optional<Quadbike> getQuadbike(int id){
        return QuadbikeCrudRepository.findById(id);
    }
    public Quadbike save(Quadbike c){
        return QuadbikeCrudRepository.save(c);
    }
    public void delete(Quadbike c){
        QuadbikeCrudRepository.delete(c);
    }

}
