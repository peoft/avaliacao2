package entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

enum CATEGORIA {
	HATCH_COMPACTO, HATCH_MEDIO, SEDAN_COMPACTO, SEDAN_MEDIO, SEDAN_GRANDE, MINIVAN, ESPORTIVO, UTILITARIO_COMERCIAL
};

@Entity
public class ModeloCarro {
	private ModeloCarroId id;
	private int fabricanteId;
	private String descricao;
	private CATEGORIA categoria;
	private List<Carro> carros;

	public ModeloCarro() {

	}

	public ModeloCarro(ModeloCarroId id, int fabricanteId, String descricao, CATEGORIA categoria) {
		super();
		this.id = id;
		this.fabricanteId = fabricanteId;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	@EmbeddedId
	public ModeloCarroId getId() {
		return id;
	}

	public void setId(ModeloCarroId id) {
		this.id = id;
	}

	public int getFabricanteId() {
		return fabricanteId;
	}

	public void setFabricanteId(int fabricanteId) {
		this.fabricanteId = fabricanteId;
	}

	@Column(precision = 50, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public CATEGORIA getCategoria() {
		return categoria;
	}

	public void setCategoria(CATEGORIA categoria) {
		this.categoria = categoria;
	}

	@OneToMany(mappedBy = "modeloCarro")
	public List<Carro> getCarros() {
		return carros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + fabricanteId;
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
		if (categoria != other.categoria)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fabricanteId != other.fabricanteId)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
