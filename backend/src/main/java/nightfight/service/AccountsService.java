package nightfight.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nightfight.model.Accounts;

@Stateless
public class AccountsService {
	@PersistenceContext
	private EntityManager em;
		
	public List<Accounts> getAllClients() {
		return em.createNamedQuery("Accounts.selectAll", Accounts.class)
			.getResultList();
	}
	public List<Accounts> getAllSearched(String searchTerm) {
		return em.createNamedQuery("Accounts.selectSearched", Accounts.class)
				.setParameter("name", "%" + searchTerm + "%")
				.getResultList();
	}
}