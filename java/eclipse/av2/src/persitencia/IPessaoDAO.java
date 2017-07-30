package persitencia;

import java.sql.Connection;

import av2.Pessoa;

public interface IPessaoDAO {
	Connection getConnection();
	boolean criar(Pessoa pessoa); 
	boolean recuperar(Pessoa pessoa);
	boolean recuperarPeloCPF(Pessoa pessoa);
	boolean atualizar(Pessoa pessoa);
	boolean deletar(Pessoa pessoa);
}
