package at.technikumwien.clients;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClientsService {
	@PersistenceContext
	private EntityManager em;
		
	public List<Clients> getAllClients() {
		return em.createNamedQuery("Clients.selectAll", Clients.class)
			.getResultList();
	}
	public List<Clients> getAllSearched(String searchTerm) {
		return em.createNamedQuery("Clients.selectSearched", Clients.class)
				.setParameter("name", "%" + searchTerm + "%")
				.getResultList();
	}
}