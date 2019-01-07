package nightfight.accounts;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AccountsService {
	@PersistenceContext
	private EntityManager em;
	
	public List<Accounts> getAllAccounts() {
		return em.createNamedQuery("Accounts.selectAll", Accounts.class)
				.getResultList();
	}
}
