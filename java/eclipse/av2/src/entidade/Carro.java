package entidade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro {
	private CarroId id;
	private int acessorioId;
	private ModeloCarro modeloCarro;
	private String cor;
	private BigDecimal valorDiaria;
	List<Aluguel> alugueis;
	private Set<Acessorio> acessorios = new HashSet<>();

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
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
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Carro() {

	}

	public Carro(CarroId id, int acessorioId, int modeloCarroId, String placa, String chassi, String cor,
			BigDecimal valorDiaria) {
		super();
		this.id = id;
		this.acessorioId = acessorioId;
		this.cor = cor;
		this.valorDiaria = valorDiaria;
	}

	@EmbeddedId
	public CarroId getId() {
		return id;
	}

	public void setId(CarroId id) {
		this.id = id;
	}

	public int getAcessorioId() {
		return acessorioId;
	}

	public void setAcessorioId(int acessorioId) {
		this.acessorioId = acessorioId;
	}

	@Column(length = 50, nullable = false)
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Column(precision = 10, scale = 2, nullable = false)
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@OneToMany(mappedBy = "carro")
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	@ManyToOne(optional = false)
	@JoinColumns({ @JoinColumn(name = "modeloCarro_Id"), @JoinColumn(name = "fabricante_Id") })
	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	@ManyToMany
	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Set<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
}
