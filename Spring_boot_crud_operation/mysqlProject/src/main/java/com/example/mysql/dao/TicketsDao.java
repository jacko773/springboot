package com.example.mysql.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.mysql.model.Tickets;

public interface TicketsDao extends CrudRepository<Tickets, Integer> {

}