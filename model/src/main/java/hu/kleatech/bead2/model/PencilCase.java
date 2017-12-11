//@author Bozzay, Ádám
package hu.kleatech.bead2.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "pencilcase")
public class PencilCase implements Serializable {
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	@OneToMany(mappedBy = "pencilCase", fetch = FetchType.EAGER)
	@Column(name = "pencils")
	private List<Pencil> pencils;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	protected PencilCase() {}
	public PencilCase(User owner) {
		this.owner = owner;
	}
	public User getOwner() { return owner; }
	public List<Pencil> getPencils() { return Collections.unmodifiableList(pencils); }
	public Long getId() { return id; }
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53 * hash + Objects.hashCode(this.id);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final PencilCase other = (PencilCase) obj;
		return Objects.equals(this.id, other.id);
	}
	@Override
	public String toString() {
		return "PencilCase{" + "owner=" + owner + ", pencils=" + pencils + '}';
	}

	public PencilCase addPencil(Pencil pencil) {
		pencils.add(pencil);
		return this;
	}
	public Pencil removePencil(Pencil pencil) {
		return pencils.remove(pencils.indexOf(pencil));
	}
}
