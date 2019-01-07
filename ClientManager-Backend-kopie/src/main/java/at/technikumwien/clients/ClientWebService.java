package at.technikumwien.clients;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService
public class ClientWebService {
	@Inject
	private ClientsService clientsService;
	
	public List<Clients> getAllNews() {
		return clientsService.getAllClients();
	}
}