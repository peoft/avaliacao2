package av2;

import java.sql.Connection;

public interface IFuncionarioDAO {
	Connection getConnection();
	boolean criar(Funcionario funcionario); 
	boolean recuperar(Funcionario funcionario);
	boolean atualizar(Funcionario funcionario);
	boolean deletar(Funcionario funcionario);	
}
