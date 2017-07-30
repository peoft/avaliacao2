package entidade;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

@Entity
public class ApoliceSeguro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@OneToOne(optional = false)
	@JoinColumns({@JoinColumn(name = "dataPedido"),	@JoinColumn(name = "pessoaId")})
	private Aluguel aluguel;
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal valorFranquia;
	private boolean protecaoTerceiro;
	private boolean protecaoCausasNaturais;
	private boolean protecaoRoubo;
	
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
	public ApoliceSeguro() {
		
	}
	public BigDecimal getValorFranquia() {
		return valorFranquia;
	}
	public void setValorFranquia(BigDecimal valorFranquia) {
		this.valorFranquia = valorFranquia;
	}
	public boolean isProtecaoTerceiro() {
		return protecaoTerceiro;
	}
	public void setProtecaoTerceiro(boolean protecaoTerceiro) {
		this.protecaoTerceiro = protecaoTerceiro;
	}
	public boolean isProtecaoCausasNaturais() {
		return protecaoCausasNaturais;
	}
	public void setProtecaoCausasNaturais(boolean protecaoCausasNaturais) {
		this.protecaoCausasNaturais = protecaoCausasNaturais;
	}
	public boolean isProtecaoRoubo() {
		return protecaoRoubo;
	}
	public void setProtecaoRoubo(boolean protecaoRoubo) {
		this.protecaoRoubo = protecaoRoubo;
	}	
	public Aluguel getAluguel() {
		return aluguel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluguel == null) ? 0 : aluguel.hashCode());
		result = prime * result + (protecaoCausasNaturais ? 1231 : 1237);
		result = prime * result + (protecaoRoubo ? 1231 : 1237);
		result = prime * result + (protecaoTerceiro ? 1231 : 1237);
		result = prime * result + ((valorFranquia == null) ? 0 : valorFranquia.hashCode());
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
		ApoliceSeguro other = (ApoliceSeguro) obj;
		if (aluguel == null) {
			if (other.aluguel != null)
				return false;
		} else if (!aluguel.equals(other.aluguel))
			return false;
		if (protecaoCausasNaturais != other.protecaoCausasNaturais)
			return false;
		if (protecaoRoubo != other.protecaoRoubo)
			return false;
		if (protecaoTerceiro != other.protecaoTerceiro)
			return false;
		if (valorFranquia == null) {
			if (other.valorFranquia != null)
				return false;
		} else if (!valorFranquia.equals(other.valorFranquia))
			return false;
		return true;
	}
}
