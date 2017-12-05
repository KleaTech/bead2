//@author Bozzay, Ádám
package hu.kleatech.bead2.dao;

import hu.kleatech.bead2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUniqueAlias(String uniqueAlias);
}
