package com.usa.misiontic.ciclo3.repository.crudRepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.usa.misiontic.ciclo3.entities.Reservation;
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date init, Date last);

    @Query(value = "SELECT r.status, COUNT(r.status) FROM reservation AS r GROUP BY r.status ORDER by r.status DESC")
    List<Reservation> getReservactionReportStatus();
}
