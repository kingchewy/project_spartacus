package at.nightfight.repository;

import at.nightfight.model.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;

//@PreAuthorize("hasAuthority('NewsUserRole')")
@PreAuthorize("hasRole('USER')")
public interface RaceRepository extends CrudRepository<Race, Long> {}