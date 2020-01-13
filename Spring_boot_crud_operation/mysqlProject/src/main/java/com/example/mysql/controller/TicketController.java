package com.example.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.dao.TicketsDao;
import com.example.mysql.model.Tickets;


@RestController
@RequestMapping("/tickets")
@ResponseBody
public class TicketController {
@Autowired
private TicketsDao dao;
@PostMapping("/booktickets")
public String bookTicket(@RequestBody List<Tickets> tickets) {
	dao.saveAll(tickets);
	return "Tickets Booked" + tickets.size();
}
@GetMapping("/getTickets")
public List<Tickets> getTickets(){
	return (List<Tickets>) dao.findAll();
}

@GetMapping("/getTicketsbyid/{id}")
public Optional<Tickets> getTicketsbyid(@PathVariable Integer id){
	return (Optional<Tickets>) dao.findById(id);
}
@DeleteMapping("/deletetickets/{id}")
public String deleteticket(@PathVariable  Integer id) {
	dao.deleteById(id);
	return "Tickets deleted with id "+id ;
}
@PutMapping("/updatetickets/{id}")
public String updateticket(@RequestBody  Tickets tickets,@PathVariable  Integer id) {
	tickets.setId(id);
	dao.save(tickets);
	return "Tickets deleted with id"+tickets.getAmount() ;
}

}
