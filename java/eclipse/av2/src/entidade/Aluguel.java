package entidade;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluguel {
	private AluguelId id;
//	private int pessoaId;
	private Carro carro;
	private ApoliceSeguro apoliceSeguro;
	private Calendar dataPedido;
	private Date dataEntrega;
	private Date dataDevolucao;
	private BigDecimal valorTotal;

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apoliceSeguro == null) ? 0 : apoliceSeguro.hashCode());
		result = prime * result + ((carro == null) ? 0 : carro.hashCode());
		result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
		result = prime * result + ((dataEntrega == null) ? 0 : dataEntrega.hashCode());
		result = prime * result + ((dataPedido == null) ? 0 : dataPedido.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + pessoaId;
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
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
		Aluguel other = (Aluguel) obj;
		if (apoliceSeguro == null) {
			if (other.apoliceSeguro != null)
				return false;
		} else if (!apoliceSeguro.equals(other.apoliceSeguro))
			return false;
		if (carro == null) {
			if (other.carro != null)
				return false;
		} else if (!carro.equals(other.carro))
			return false;
		if (dataDevolucao == null) {
			if (other.dataDevolucao != null)
				return false;
		} else if (!dataDevolucao.equals(other.dataDevolucao))
			return false;
		if (dataEntrega == null) {
			if (other.dataEntrega != null)
				return false;
		} else if (!dataEntrega.equals(other.dataEntrega))
			return false;
		if (dataPedido == null) {
			if (other.dataPedido != null)
				return false;
		} else if (!dataPedido.equals(other.dataPedido))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
//		if (pessoaId != other.pessoaId)
//			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

	public Aluguel() {

	}

	public Aluguel(AluguelId id, Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal) {
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataDevolucao = dataDevolucao;
		this.valorTotal = valorTotal;
		this.id = id;
	}

//	public int getPessoaId() {
//		return pessoaId;
//	}
//
//	public void setPessoaId(int pessoaId) {
//		this.pessoaId = pessoaId;
//	}

	@OneToOne(optional = false)
	@JoinColumn(name = "apoliceSeguro_id")
	public ApoliceSeguro getApoliceSeguro() {
		return apoliceSeguro;
	}

	@ManyToOne(optional = false)
	@JoinColumns({
	@JoinColumn(name = "acessorio_id"),
	@JoinColumn(name = "modeloCarro_id")
	})
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
