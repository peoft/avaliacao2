package entidade;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class AluguelId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int pessoaId;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)	
	private Calendar dataPedido;
	
	public AluguelId() {
	}
	
	public int getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPedido == null) ? 0 : dataPedido.hashCode());
		result = prime * result + pessoaId;
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
		AluguelId other = (AluguelId) obj;
		if (dataPedido == null) {
			if (other.dataPedido != null)
				return false;
		} else if (!dataPedido.equals(other.dataPedido))
			return false;
		if (pessoaId != other.pessoaId)
			return false;
		return true;
	}
}
