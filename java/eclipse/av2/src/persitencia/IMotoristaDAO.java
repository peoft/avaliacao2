package persitencia;

import java.sql.Connection;

import av2.Motorista;

public interface IMotoristaDAO {
	Connection getConnection();
	boolean criar(Motorista motorista); 
	boolean recuperar(Motorista motorista);
	boolean atualizar(Motorista motorista);
	boolean deletar(Motorista motorista);

}
