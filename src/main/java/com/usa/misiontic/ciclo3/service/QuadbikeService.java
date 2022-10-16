package com.usa.misiontic.ciclo3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.misiontic.ciclo3.entities.Quadbike;
import com.usa.misiontic.ciclo3.repository.QuadbikeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuadbikeService {

    @Autowired
    private QuadbikeRepository QuadbikeRepository;

    public List<Quadbike> getAll(){
        return QuadbikeRepository.getAll();
    }
    public Optional<Quadbike> getQuadbike(int id){
        return QuadbikeRepository.getQuadbike(id);
    }
    public Quadbike save(Quadbike p){
        if(p.getId()==null){
            return QuadbikeRepository.save(p);
        }else{
            Optional<Quadbike> e = QuadbikeRepository.getQuadbike(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return QuadbikeRepository.save(p);
            }
        }
    }
    public Quadbike update(Quadbike p){
        if(p.getId()!=null){
            Optional<Quadbike> q = QuadbikeRepository.getQuadbike(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if(p.getBrand()!=null){
                    q.get().setBrand(p.getBrand());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }

                QuadbikeRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Quadbike>p= QuadbikeRepository.getQuadbike(id);
        if(p.isPresent()){
            QuadbikeRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
