package av2;

import java.sql.Connection;

public interface IAluguelDAO {
	Connection getConnection();
	boolean criar(Aluguel aluguel); 
	boolean recuperar(Aluguel aluguel);
	boolean atualizar(Aluguel aluguel);
	boolean deletar(Aluguel aluguel);
}
