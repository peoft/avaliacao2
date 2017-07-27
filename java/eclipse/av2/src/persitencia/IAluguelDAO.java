package persitencia;

import entidade.Aluguel;

public interface IAluguelDAO {
	boolean criar(Aluguel aluguel); 
	boolean recuperar(Aluguel aluguel);
	boolean atualizar(Aluguel aluguel);
	boolean deletar(Aluguel aluguel);
}
