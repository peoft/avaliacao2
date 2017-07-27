package persitencia;

import entidade.ApoliceSeguro;

public interface IApoliceSeguroDAO {
	boolean criar(ApoliceSeguro apoliceSeguro); 
	boolean recuperar(ApoliceSeguro apoliceSeguro);
	boolean atualizar(ApoliceSeguro apoliceSeguro);
	boolean deletar(ApoliceSeguro apoliceSeguro);	
}
