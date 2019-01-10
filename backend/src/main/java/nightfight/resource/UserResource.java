package nightfight.resource;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import nightfight.model.User;
import nightfight.service.UserService;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	private static final Logger LOGGER = Logger.getLogger(UserResource.class.getName());

	@PersistenceContext
	private EntityManager em;
	@Inject
	private UserService userService;
	@Context
	private UriInfo uriInfo;

	@POST
	@Transactional
	public Response create(User user) {
		LOGGER.info("create >> client=" + user);

		em.persist(user);
		URI uri = uriInfo.getAbsolutePathBuilder().path(user.getId().toString()).build();
		return Response.created(uri).build();
	}

	@GET
	@Path("/{id}")
	public User retrieve(@PathParam("id") long id) {
		LOGGER.info("retrieve >> id=" + id);

		return em.find(User.class, id);
	}

	@GET
	public List<User> getAllUsers(){
		LOGGER.info("retrieveAll Users");
		return userService.getAllUsers();
	}
	
//	@PUT
//	@Path("/{id}")
//	@Transactional
//	public void update(@PathParam("id") long id, Clients clientNew) {
//		LOGGER.info("update >> id=" + id + ", client=" + clientNew);
//
//		Clients clientOld = em.find(Clients.class, id);
//		if (clientOld != null) {
//			clientOld.setName(clientNew.getName());
//			clientOld.setText(clientNew.getText());
//		} else {
//			throw new WebApplicationException(Status.NOT_FOUND);
//		}
//	}
//
//	@DELETE
//	@Path("/{id}")
//	@Transactional
//	public void delete(@PathParam("id") long id) {
//		LOGGER.info("delete >> id=" + id);
//
//		Clients client = em.find(Clients.class, id);
//		if (client != null) {
//			em.remove(client);
//		} else {
//			throw new WebApplicationException(Status.NOT_FOUND);
//		}
//	}

//	@GET
//	public List<User> retrieveAll ( @QueryParam("searchterm") String searchTerm ) {
//		LOGGER.info("retrieveAll");
//		
//		if (searchTerm == null) {
//			return userService.getAllClients();
//		} else {
//			return userService.getAllSearched(searchTerm);
//		}
//	}
}