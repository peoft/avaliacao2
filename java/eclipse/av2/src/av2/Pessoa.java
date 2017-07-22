
package av2;

import java.util.Date;

enum SEXO { Masculino, Feminino };

public abstract class Pessoa {
	private int id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private SEXO sexo;
	public Pessoa(int id, String nome, Date dataNascimento, String cpf, SEXO sexo) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
	}
	public SEXO getSexo() {
		return sexo;
	}
	public void setSexo(SEXO sexo) {
		this.sexo = sexo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
}
