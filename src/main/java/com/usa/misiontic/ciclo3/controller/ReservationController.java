package com.usa.misiontic.ciclo3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.usa.misiontic.ciclo3.entities.Reservation;
import com.usa.misiontic.ciclo3.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/report-status")
    public List<Reservation> getReservationReportStatus(){
        return reservationService.getReservactionReportStatus();
    }

    @GetMapping("/report-dates/{dateInit}/{dateLast}")
    public List<Reservation> getReservationsReportDates(
        @PathVariable("dateInit") String dateInit,
        @PathVariable ("dateLast") String dateLast){
        return reservationService.getReservationsPeriod(dateInit,dateLast);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody  Reservation p){
        return reservationService.save(p);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody  Reservation p){
        return reservationService.update(p);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }
    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(){
        List<Reservation> reservations = reservationService.getAll();
        for (Reservation reservation : reservations) {
            reservationService.delete(reservation.getIdReservation());
        }
        return true;
    }
}
