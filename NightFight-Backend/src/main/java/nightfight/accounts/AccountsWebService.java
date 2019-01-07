package nightfight.accounts;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService
public class AccountsWebService {
	@Inject
	private AccountsService clientsService;
	
	public List<Accounts> getAllNews() {
		return clientsService.getAllClients();
	}
}