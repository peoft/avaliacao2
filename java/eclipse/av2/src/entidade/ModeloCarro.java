package entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import av2.Categoria;

@Entity
public class ModeloCarro {
	@EmbeddedId
	ModeloCarroId id;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)	
	private Categoria categoria;
	@OneToMany(mappedBy = "modeloCarro")
	private List<Carro> carros;
	@ManyToOne(optional = false)
	@JoinColumns({
	@JoinColumn(name = "modeloCarroFabricanteId"),
	})	
	private Fabricante fabricante;
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}	

	public ModeloCarroId getId() {
		return id;
	}

	public void setId(ModeloCarroId id) {
		this.id = id;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public ModeloCarro() {

	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	public List<Carro> getCarros() {
		return carros;
	}
}
