package av2;

import java.sql.Connection;

public interface IMotoristaDAO {
	Connection getConnection();
	boolean criar(Motorista motorista); 
	boolean recuperar(Motorista motorista);
	boolean atualizar(Motorista motorista);
	boolean deletar(Motorista motorista);

}
