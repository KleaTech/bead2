//@author Bozzay, Ádám
package hu.kleatech.bead2.service;

import hu.kleatech.bead2.dao.PencilCaseRepository;
import hu.kleatech.bead2.model.*;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PencilCaseService {

	@Resource
	private PencilCaseRepository pencilCaseRepository;
	@Autowired
	private PencilService pencilService;

	public PencilCase addPencilCase(User owner) {
		return pencilCaseRepository.save(new PencilCase(owner));
	}

	public void removePencilCaseWithPencils(PencilCase pc) {
		pencilService.removePencils(pc.getPencils());
		pencilCaseRepository.delete(pc);
	}

	public void removePencilCaseWithPencils(Long id) {
		removePencilCaseWithPencils(pencilCaseRepository.findOne(id));
	}

	public boolean transferPencil(Pencil pencil, PencilCase from, PencilCase to) {
		if (!from.getPencils().contains(pencil)) return false;
		from.removePencil(pencil);
		to.addPencil(pencil);
		return true;
	}

	public List<PencilCase> getPencilCases(User owner) {
		return pencilCaseRepository.findByOwner(owner);
	}
}
