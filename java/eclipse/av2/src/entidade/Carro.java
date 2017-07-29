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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro {
	@EmbeddedId
	private CarroId carroId;
	private int acessorioId;
	@ManyToOne(optional = false)
	@JoinColumns({ @JoinColumn(name = "ModeloCarroDescricao"), @JoinColumn(name = "ModeloCarroId"),  @JoinColumn(name = "ModeloCarroFabricanteId") })	
	private ModeloCarro modeloCarro;
	@Column(length = 50, nullable = false)
	private String cor;
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal valorDiaria;
	@OneToMany(mappedBy = "carro")
	List<Aluguel> alugueis;
	@ManyToMany
	@JoinTable(joinColumns = {@JoinColumn(name = "carroChassi"), @JoinColumn(name = "carroPlaca")}, inverseJoinColumns = @JoinColumn(name = "acessorioId"))
	private Set<Acessorio> acessorios = new HashSet<>();

	public CarroId getCarroId() {
		return carroId;
	}

	public void setCarroId(CarroId carroId) {
		this.carroId = carroId;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}


	public Carro() {

	}

	public Carro(CarroId carroId, int acessorioId, ModeloCarro modeloCarro, String placa, String chassi, String cor,
			BigDecimal valorDiaria, List<Aluguel> alugueis, Set<Acessorio> acessorios) {
		super();
		this.carroId = carroId;
		this.acessorioId = acessorioId;
		this.modeloCarro = modeloCarro;
		this.cor = cor;
		this.valorDiaria = valorDiaria;
		this.alugueis = alugueis;
		this.acessorios = acessorios;
	}	
		
	public int getAcessorioId() {
		return acessorioId;
	}

	public void setAcessorioId(int acessorioId) {
		this.acessorioId = acessorioId;
	}
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Set<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
}
