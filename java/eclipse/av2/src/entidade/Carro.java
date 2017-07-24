package entidade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro {
	private CarroId id;
	private int acessorioId;
	private ModeloCarro modeloCarro;
	private String placa;
	private String chassi;
	private String cor;
	private BigDecimal valorDiaria;
	List<Aluguel> alugueis;
	private Set<Acessorio> acessorios = new HashSet<>();

	public Carro() {

	}

	public Carro(CarroId id, int acessorioId, int modeloCarroId, String placa, String chassi, String cor,
			BigDecimal valorDiaria) {
		super();
		this.id = id;
		this.acessorioId = acessorioId;
		this.placa = placa;
		this.chassi = chassi;
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

	@Column(length = 10, nullable = false)
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Column(length = 30, nullable = false)
	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
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
	@JoinColumn(name = "modeloCarroId")
	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	@ManyToMany
	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}
}
