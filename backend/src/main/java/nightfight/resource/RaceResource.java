package nightfight.resource;


import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import nightfight.model.Character;


@Path("/races")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RaceResource {

	private static final Logger LOGGER = Logger.getLogger(CharacterResource.class.getName()); 
	
	@PersistenceContext
	private EntityManager em;	
	@Context
	private UriInfo uriInfo;	
	

	@GET
	@Path("/{race}")
	public Character retrieve(@PathParam("race") String race) {
		LOGGER.info("retrieve -> charachterId = " + race);
		
		return em.find(Character.class, race);
	}
}
