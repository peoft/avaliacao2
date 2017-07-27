package entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import av2.Categoria;

@Entity
public class ModeloCarro {

	private ModeloCarroId id;
	private int fabricanteId;
	private Categoria categoria;
	private List<Carro> carros;

	public int getFabricanteId() {
		return fabricanteId;
	}

	public void setFabricanteId(int fabricanteId) {
		this.fabricanteId = fabricanteId;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloCarro other = (ModeloCarro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public ModeloCarro() {

	}

	public ModeloCarro(ModeloCarroId id, int fabricanteId, String descricao, Categoria categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}

	@EmbeddedId
	public ModeloCarroId getId() {
		return id;
	}

	public void setId(ModeloCarroId id) {
		this.id = id;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@OneToMany(mappedBy = "modeloCarro")
	public List<Carro> getCarros() {
		return carros;
	}
}
