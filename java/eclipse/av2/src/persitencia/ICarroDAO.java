package persitencia;

import entidade.Carro;
import entidade.CarroId;

public interface ICarroDAO {
	boolean criar(Carro carro); 
	Carro recuperar(CarroId carro);
	boolean atualizar(Carro carro);
	boolean deletar(Carro carro);	
}
