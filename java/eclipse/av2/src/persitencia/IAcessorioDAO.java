package persitencia;

import entidade.Acessorio;

public interface IAcessorioDAO {
	boolean criar(Acessorio acessorio); 
	boolean recuperar(Acessorio acessorio);
	boolean atualizar(Acessorio acessorio);
	boolean deletar(Acessorio acessorio);	
}
