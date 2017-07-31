package persitencia;

import entidade.Fabricante;

public interface IFabricanteDAO {
	boolean criar(Fabricante fabricante); 
	boolean recuperar(Fabricante fabricante);
	boolean atualizar(Fabricante original, Fabricante modified);
	boolean deletar(Fabricante fabricante);	
}
