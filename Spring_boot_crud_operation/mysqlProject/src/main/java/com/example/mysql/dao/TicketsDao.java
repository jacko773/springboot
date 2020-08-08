package com.example.mysql.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mysql.model.Tickets;



public interface TicketsDao extends JpaRepository<Tickets, Integer> {

	 @Query("SELECT T FROM Tickets T where id like '%2%'")
	  public List<Tickets> findTickets();



}