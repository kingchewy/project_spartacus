package nightfight;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

import nightfight.model.Accounts;
import nightfight.service.AccountsService;

@WebService
public class AccountsWebService {
	@Inject
	private AccountsService clientsService;
	
	public List<Accounts> getAllNews() {
		return clientsService.getAllClients();
	}
}