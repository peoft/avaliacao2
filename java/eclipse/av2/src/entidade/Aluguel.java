package entidade;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(AluguelId.class)
public class Aluguel {
	@Id
	private int pessoaId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Id
	private int apoliceSeguroId;
	@ManyToOne(optional = false)
	@JoinColumns({
	@JoinColumn(name = "carroChassi"),
	@JoinColumn(name = "carroPlaca")	
	})	
	private Carro carro;

	@OneToOne(optional = false)
	@JoinColumn(name = "FKapoliceSeguroId")	
	private ApoliceSeguro apoliceSeguro;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)	
	private Calendar dataPedido;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)	
	private Date dataEntrega;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataDevolucao;
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal valorTotal;

	public int getPessoaId() {
		return pessoaId;
	}


	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getApoliceSeguroId() {
		return apoliceSeguroId;
	}


	public void setApoliceSeguroId(int apoliceSeguroId) {
		this.apoliceSeguroId = apoliceSeguroId;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}


	public Aluguel() {

	}

	public Aluguel(int id, int pessoaId, int apoliceSeguroId, Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal) {
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataDevolucao = dataDevolucao;
		this.valorTotal = valorTotal;
		this.id = id;
		this.pessoaId = pessoaId;
		this.apoliceSeguroId = apoliceSeguroId;
	}

	public ApoliceSeguro getApoliceSeguro() {
		return apoliceSeguro;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
		this.apoliceSeguro = apoliceSeguro;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}
