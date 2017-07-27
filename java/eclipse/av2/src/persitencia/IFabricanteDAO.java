package persitencia;

import entidade.Fabricante;

public interface IFabricanteDAO {
	boolean criar(Fabricante fabricante); 
	boolean recuperar(Fabricante fabricante);
	boolean atualizar(Fabricante fabricante);
	boolean deletar(Fabricante fabricante);	
}
