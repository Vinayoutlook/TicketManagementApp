package in.app.service;

import java.util.List;
import in.app.model.Ticket;

public interface ITicketManagementService {

	public String registrationForTicket(Ticket ticket);
	public List<Ticket> fetchAllTicket();
	public Ticket fetchTicketById(Integer id);
	public String updateTicketByDetails(Ticket ticket);
	public String updateTicketById(Integer id,Float hikePercent);
	public String deleteTicketById(Integer id);
	
}
