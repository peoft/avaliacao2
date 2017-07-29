package entidade;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class AluguelId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int pessoaId;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int apoliceSeguroId;
	public void setId(int id) {
		this.id = id;
	}

	public AluguelId() {
	}
	
	public int getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}
	public int getId() {
		return id;
	}
	public void setCarroId(int id) {
		this.id = id;
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
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		if (pessoaId != other.pessoaId)
			return false;
		return true;
	}

}
