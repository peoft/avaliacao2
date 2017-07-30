package entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Aluguel {
	@EmbeddedId
	AluguelId id;
	@ManyToOne(optional = false)
	@JoinColumns({
	@JoinColumn(name = "carroChassi"),
	@JoinColumn(name = "carroPlaca")	
	})	
	private Carro carro;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)	
	private Date dataEntrega;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataDevolucao;
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal valorTotal;

	public AluguelId getId() {
		return id;
	}

	public void setId(AluguelId id) {
		this.id = id;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Aluguel() {

	}

	public Carro getCarro() {
		return carro;
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
