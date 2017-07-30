package av2;

import java.util.Date;

import enums.Sexo;

public class Motorista extends Pessoa {
	public Motorista(int id, String nome, Date dataNascimento, String cpf, Sexo sexo, String numeroCNH) {
		super(id, nome, dataNascimento, cpf, sexo);
		this.numeroCNH = numeroCNH;
		// TODO Auto-generated constructor stub
	}

	private String numeroCNH;

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroCNH == null) ? 0 : numeroCNH.hashCode());
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
		Motorista other = (Motorista) obj;
		if (numeroCNH == null) {
			if (other.numeroCNH != null)
				return false;
		} else if (!numeroCNH.equals(other.numeroCNH))
			return false;
		return true;
	}
}
