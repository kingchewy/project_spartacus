package nightfight.resource;

import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import nightfight.model.Character;
import nightfight.service.CharacterService;
import nightfight.util.authentication.Secured;

@Secured
@Path("/characters")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CharacterResource {
	
	private static final Logger LOGGER = Logger.getLogger(CharacterResource.class.getName()); 
		
		@PersistenceContext
		private EntityManager em;	
		@Context
		private UriInfo uriInfo;	
		@Inject
		private CharacterService characterService;
		
		
		@POST
		@Transactional
		public Response create(Character character) {
			LOGGER.info("create -> character = " + character);
	
			em.persist(character);
			URI uri = uriInfo.getAbsolutePathBuilder().path(character.getId().toString()).build();
			return Response.created(uri).build();
		}
		
		@GET
		@Path("/{id}")
		public Character retrieve(@PathParam("id") long id) {
			LOGGER.info("retrieve -> charachterId = " + id);
			
			return em.find(Character.class, id);
		}
		
}
