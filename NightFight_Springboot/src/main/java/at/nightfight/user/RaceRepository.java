package at.nightfight.user;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.security.access.prepost.PreAuthorize;

//@PreAuthorize("hasAuthority('NewsUserRole')")
public interface RaceRepository extends CrudRepository<Race, Long> {}