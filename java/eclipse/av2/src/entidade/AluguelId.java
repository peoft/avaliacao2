package entidade;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AluguelId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int pessoaId;
	private int carroId;
	private int apoliceSeguroId;
	public AluguelId() {
	}
	
	public int getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}
	public int getCarroId() {
		return carroId;
	}
	public void setCarroId(int carroId) {
		this.carroId = carroId;
	}
	public int getApoliceSeguroId() {
		return apoliceSeguroId;
	}
	public void setApoliceSeguroId(int apoliceSeguroId) {
		this.apoliceSeguroId = apoliceSeguroId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + apoliceSeguroId;
		result = prime * result + carroId;
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
		if (apoliceSeguroId != other.apoliceSeguroId)
			return false;
		if (carroId != other.carroId)
			return false;
		if (pessoaId != other.pessoaId)
			return false;
		return true;
	}

}
