package entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CarroId implements Serializable {
	private static final long serialVersionUID = 1L;
	private String placa;
	private String chassi;

	public CarroId() {
	}

	public CarroId(String placa, String chassi) {
		super();
		this.placa = placa;
		this.chassi = chassi;
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
}
