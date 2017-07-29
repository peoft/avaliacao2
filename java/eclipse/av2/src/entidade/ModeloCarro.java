package entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import av2.Categoria;

@Entity
@IdClass(ModeloCarroId.class)
public class ModeloCarro {
	@Id
	private int fabricanteId;
	@Id	
	private String descricao;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
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
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFabricanteId() {
		return fabricanteId;
	}

	public void setFabricanteId(int fabricanteId) {
		this.fabricanteId = fabricanteId;
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
