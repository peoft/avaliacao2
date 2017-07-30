package cadastros;

import entidade.Acessorio;

public interface CadastroOpcoes {
	public void criar();
	public void recuperar();
	public void atualizar(boolean novoValor, Acessorio original);
	public void deletar();
}
