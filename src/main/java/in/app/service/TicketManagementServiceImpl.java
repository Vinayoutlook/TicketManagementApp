package in.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.app.dao.ITicketRepo;
import in.app.exception.TicketNotFoundException;
import in.app.model.Ticket;

@Service
public class TicketManagementServiceImpl implements ITicketManagementService {

	@Autowired
	private ITicketRepo repo;
	
	@Override
	public String registrationForTicket(Ticket ticket) {
		Integer id=repo.save(ticket).getTid();
		return "Ticket added with id : "+id;
	}

	@Override
	public List<Ticket> fetchAllTicket() {
		List<Ticket> list=repo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Ticket fetchTicketById(Integer id) {
		return repo.findById(id).orElseThrow(()-> new TicketNotFoundException
				("Ticket with id "+id+" not found"));
	}

	@Override
	public String updateTicketByDetails(Ticket ticket) {
		Optional<Ticket> optional=repo.findById(ticket.getTid());
		if(optional.isPresent()) {
			repo.save(ticket);
			return "Ticket with id "+ticket.getTid()+" get updated";
		}else {
			throw new TicketNotFoundException("Ticket with id "+
		      ticket.getTid()+" is not found for updation");
		}
	}

	@Override
	public String updateTicketById(Integer id, Float hikePercent) {
		Optional<Ticket> optional=repo.findById(id);
		if(optional.isPresent()) {
			Ticket ticket=optional.get();
			double amount=ticket.getTicketAmount()+(ticket.getTicketAmount())*(hikePercent/100);
		    ticket.setTicketAmount(amount);
		    repo.save(ticket);
		    return "Ticket is updated with hike amount with id "+id;
		}else {
			throw new TicketNotFoundException("Ticket with id "+
				      id+" is not found for updation");
		}
	}

	@Override
	public String deleteTicketById(Integer id) {
		Optional<Ticket> optional=repo.findById(id);
		if(optional.isPresent()) {
			repo.deleteById(id);
			return "Ticket deleted with id "+id;
		}
		else {
			throw new TicketNotFoundException("Ticket with id "+
				      id+" is not found for deletion");
		}
	}

}
