package nightfight.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CharacterService {
	@PersistenceContext
	private EntityManager em;
		
	public List<Character> getAllClients() {
		return em.createNamedQuery("Character.selectAll", Character.class)
			.getResultList();
	}
}
