package in.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import in.app.model.Ticket;

public interface ITicketRepo extends JpaRepository<Ticket,Integer> {

}
