package nightfight.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nightfight.model.User;

@Stateless
public class UserService {
	@PersistenceContext
	private EntityManager em;
		
	public List<User> getAllUsers() {
		return em.createNamedQuery("User.selectAll", User.class)
			.getResultList();
	}
//	public List<User> getAllSearched(String searchTerm) {
//		return em.createNamedQuery("User.selectSearched", User.class)
//				.setParameter("name", "%" + searchTerm + "%")
//				.getResultList();
//	}
}