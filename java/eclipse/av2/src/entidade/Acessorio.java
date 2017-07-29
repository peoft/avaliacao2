package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acessorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@Column(length = 50, nullable = false)
	private String descricao;
/*	@ManyToMany(mappedBy = "acessorios")
	private Set<Carro> carros = new HashSet<>();

	public void setCarros(Set<Carro> carros) {
		this.carros = carros;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((carros == null) ? 0 : carros.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
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
		Acessorio other = (Acessorio) obj;
//		if (carros == null) {
//			if (other.carros != null)
//				return false;
//		} else if (!carros.equals(other.carros))
//			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public Acessorio() {

	}

	public Acessorio(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
//	public Set<Carro> getCarros() {
//		return carros;
//	}

}
