package persitencia;

import java.sql.Connection;

import av2.Funcionario;

public interface IFuncionarioDAO {
	Connection getConnection();
	boolean criar(Funcionario funcionario); 
	boolean recuperar(Funcionario funcionario);
	boolean atualizar(Funcionario funcionario);
	boolean deletar(Funcionario funcionario);	
}
