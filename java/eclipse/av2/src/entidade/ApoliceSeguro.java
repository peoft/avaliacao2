package entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ApoliceSeguro {
	private int id;
	private BigDecimal valorFranquia;
	private boolean protecaoTerceiro;
	private boolean protecaoCausasNaturais;
	private boolean protecaoRoubo;
	private Aluguel aluguel;
	
	
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
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
	public ApoliceSeguro() {
		
	}
	public ApoliceSeguro(int id, BigDecimal valorFranquia, boolean protecaoTerceiro, boolean protecaoCausasNaturais,
			boolean protecaoRoubo) {
		super();
		this.id = id;
		this.valorFranquia = valorFranquia;
		this.protecaoTerceiro = protecaoTerceiro;
		this.protecaoCausasNaturais = protecaoCausasNaturais;
		this.protecaoRoubo = protecaoRoubo;
	}
	@Id
	@GeneratedValue	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(precision = 10, scale = 2, nullable = false)
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
	// Associação Bidrecional.
	@OneToOne(mappedBy = "apoliceSeguro")
	public Aluguel getAluguel() {
		return aluguel;
	}
	
	
	

}
