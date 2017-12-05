//@author Bozzay, Ádám
package hu.kleatech.bead2.service;

import hu.kleatech.bead2.dao.PencilRepository;
import hu.kleatech.bead2.model.Color;
import hu.kleatech.bead2.model.Pencil;
import hu.kleatech.bead2.model.PencilCase;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PencilService {

	@Resource
	private PencilRepository pencilRepository;

	public Pencil addPencil(Pencil pencil) {
		return pencilRepository.save(pencil);
	}
	public Pencil addPencil(Color color, String brand, int length, int sharpness, PencilCase pc) {
		return pencilRepository.save(new Pencil(color, brand, length, sharpness, pc));
	}
	public void removePencil(Pencil pencil) {
		pencilRepository.delete(pencil);
	}
	public void removePencil(Long id) {
		pencilRepository.delete(id);
	}
	public void sharpenPencil(Pencil pencil, int percentage) {
		pencil.setLength(pencil.getLength()-percentage/10);
		pencil.setSharpness((pencil.getSharpness()+percentage)>100?100:pencil.getSharpness()+percentage);
		pencilRepository.save(pencil);
	}
	public void sharpenPencil(Long id, int percentage) {
		sharpenPencil(pencilRepository.findOne(id), percentage);
	}
	public void usePencil(Pencil pencil, int percentage) {
		if(pencil.getSharpness() - percentage < 0) pencil.setSharpness(0);
		else pencil.setSharpness(pencil.getSharpness()-percentage);
		pencilRepository.save(pencil);
	}
	public void usePencil(Long id, int percentage) {
		usePencil(pencilRepository.findOne(id), percentage);
	}
	public void breakPencil(Pencil pencil) {
		pencil.setSharpness(0);
		pencilRepository.save(pencil);
	}
	public void breakPencil(Long id) {
		breakPencil(pencilRepository.findOne(id));
	}
	public List<Pencil> getPencils(Color color, String brand) {
		return pencilRepository.findByColorAndBrand(color, brand);
	}
}
