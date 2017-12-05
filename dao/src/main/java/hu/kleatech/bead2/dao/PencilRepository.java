//@author Bozzay, Ádám
package hu.kleatech.bead2.dao;

import hu.kleatech.bead2.model.Color;
import hu.kleatech.bead2.model.Pencil;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PencilRepository extends JpaRepository<Pencil, Long> {
	List<Pencil> findByColorAndBrand(Color color, String brand);
}
