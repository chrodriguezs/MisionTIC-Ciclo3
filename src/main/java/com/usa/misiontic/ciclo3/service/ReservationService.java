package com.usa.misiontic.ciclo3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.misiontic.ciclo3.entities.Reservation;
import com.usa.misiontic.ciclo3.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getProduct(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> e =reservationRepository.getReservation(p.getIdReservation());
            if(e.isPresent()){
                return p;
            }else{
                return reservationRepository.save(p);
            }
        }
    }
    public Reservation update(Reservation p){
        if(p.getIdReservation()!=null){
            Optional<Reservation> q =reservationRepository.getReservation(p.getIdReservation());
            if(q.isPresent()){
                if(p.getIdReservation()!=null){
                    q.get().setIdReservation(p.getIdReservation());
                }
//                if(p.getPalco()!=null){
//                    q.get().setPalco(p.getPalco());
//                }
//                if(p.getClient()!=null){
//                    q.get().setClient(p.getClient());
//                }
                if(p.getstartDate()!=null){
                    q.get().setstartDate(p.getstartDate());
                }
                if(p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                reservationRepository.save(q.get());
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
        Optional<Reservation>p=reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
