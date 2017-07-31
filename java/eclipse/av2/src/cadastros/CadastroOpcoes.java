package cadastros;

public interface CadastroOpcoes {
	public void criar();
	public void recuperar();
	public void atualizar(boolean novoValor, Object original);
	public void deletar();
}
