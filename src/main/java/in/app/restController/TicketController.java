package in.app.restController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.app.model.Ticket;
import in.app.service.ITicketManagementService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

	@Autowired
	private ITicketManagementService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTicket(@RequestBody Ticket ticket){
		String msg=service.registrationForTicket(ticket);
	    return new ResponseEntity<String>(msg,HttpStatus.OK);	
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllTicket(){
		List<Ticket> list=service.fetchAllTicket();
		return new ResponseEntity<List<Ticket>>(list,HttpStatus.OK);	
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getAllTicket(@PathVariable("id") Integer id){
		Ticket ticket=service.fetchTicketById(id);
		return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateTicket(@RequestBody Ticket ticket){
		String msg=service.updateTicketByDetails(ticket);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PatchMapping("/pmodify/{id}/{hike}")
	public ResponseEntity<String> updateById(@PathVariable("id") Integer id,
			@PathVariable("hike") Float hike){
		String msg=service.updateTicketById(id,hike);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		String msg=service.deleteTicketById(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
