package entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CarroId implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(length = 10, nullable = false)	
	private String placa;
	@Column(length = 30, nullable = false)
	private String chassi;

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public CarroId() {
	}
	
	public String getPlaca() {
		return placa;
	}

	public String getChassi() {
		return chassi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		CarroId other = (CarroId) obj;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

}
