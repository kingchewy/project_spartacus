package nightfight.accounts;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountsResource {
	@PersistenceContext
	private EntityManager em;
	@Inject
	private AccountsService accountsService;
	
	@GET
	public List<Accounts> retrieveAll () {
		return accountsService.getAllAccounts();
	}
}
