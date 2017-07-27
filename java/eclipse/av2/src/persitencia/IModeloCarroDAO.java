package persitencia;

import entidade.ModeloCarro;

public interface IModeloCarroDAO {
	boolean criar(ModeloCarro modeloCarro); 
	boolean recuperar(ModeloCarro modeloCarro);
	boolean atualizar(ModeloCarro modeloCarro);
	boolean deletar(ModeloCarro modeloCarro);
	
}
