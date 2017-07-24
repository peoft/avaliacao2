package entidade;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluguel {
	private AluguelId id;
	private int pessoaId;
	private Carro carro;
	private ApoliceSeguro apoliceSeguro;
	private Calendar dataPedido;
	private Date dataEntrega;
	private Date dataDevolucao;
	private BigDecimal valorTotal;
	
	public Aluguel() {
		
	}
	public Aluguel(AluguelId id, Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal) {
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataDevolucao = dataDevolucao;
		this.valorTotal = valorTotal;
		this.id = id;
	}
	public int getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}
	@OneToOne(optional = false)
	@JoinColumn(name = "apoliceSeguroId")
	public ApoliceSeguro getApoliceSeguro() {
		return apoliceSeguro;
	}
	@ManyToOne(optional = false)
	@JoinColumn(name = "carroId")
	public Carro getCarro() {
		return carro;
	}
	
	public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
		this.apoliceSeguro = apoliceSeguro;
	}
	@EmbeddedId
	public AluguelId getId() {
		return id;
	}
	public void setId(AluguelId id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Calendar getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)	
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)	
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	@Column(precision = 10, scale = 2, nullable = false)
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}	

}
