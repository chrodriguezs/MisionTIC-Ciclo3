package com.usa.misiontic.ciclo3.repository.crudRepository;

import org.springframework.data.repository.CrudRepository;

import com.usa.misiontic.ciclo3.entities.Message;
public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
