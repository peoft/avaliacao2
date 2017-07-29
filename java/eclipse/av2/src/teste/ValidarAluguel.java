package teste;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import av2.JPAUtil;
import entidade.Aluguel;
import entidade.AluguelId;
import entidade.ApoliceSeguro;
import entidade.Carro;
import entidade.CarroId;
import persitencia.AluguelDAO;
import persitencia.ApoliceSeguroDAO;
import persitencia.CarroDAO;

public class ValidarAluguel {
	public static void main(String[] args) {
		try {
			ApoliceSeguroDAO apoliceSeguroDAO = new ApoliceSeguroDAO();
			ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
			
			boolean protecaoCausasNaturais = true;
			apoliceSeguro.setProtecaoCausasNaturais(protecaoCausasNaturais);
			boolean protecaoRoubo = true;
			apoliceSeguro.setProtecaoRoubo(protecaoRoubo);
			boolean protecaoTerceiro = true;
			apoliceSeguro.setProtecaoTerceiro(protecaoTerceiro);
			BigDecimal valorFranquia = new BigDecimal(1000.00);			
			apoliceSeguro.setValorFranquia(valorFranquia);
			apoliceSeguroDAO.criar(apoliceSeguro);
			
			CarroDAO carroDAO = new CarroDAO();
			Carro carro = null;
			CarroId carroId = new CarroId();
			carroId.setChassi("9G3C3DFDSFDSFSDF323");
			carroId.setPlaca("MKL 3230");
			carro.setCarroId(carroId);			
			if (carroDAO.recuperar(carro) == true) {
				AluguelDAO aluguelDAO = new AluguelDAO();
				Aluguel aluguel = new Aluguel();
				AluguelId aluguelId = new AluguelId();
				
				aluguelId.setApoliceSeguroId(apoliceSeguro.getId());
				aluguelId.setPessoaId(1);
				
				aluguel.setApoliceSeguro(apoliceSeguro);
				aluguel.setCarro(carro);
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date dataDevolucao = dateFormat.parse("12/10/2017");
				aluguel.setDataDevolucao(dataDevolucao);
				Date dataEntrega  = dateFormat.parse("13/11/2017");
				aluguel.setDataEntrega(dataEntrega);
				Calendar dataPedido = Calendar.getInstance();
				
				dataPedido.setTime(dateFormat.parse("10/10/2017"));
				aluguel.setDataPedido(dataPedido);
				BigDecimal valorTotal = new BigDecimal(2000.00);
				aluguel.setValorTotal(valorTotal);

				aluguelDAO.criar(aluguel);
				
			}

			JPAUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
