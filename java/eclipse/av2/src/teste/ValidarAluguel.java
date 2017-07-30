package teste;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import av2.EntityManagerFactoryWrapper;
import av2.Motorista;
import entidade.Aluguel;
import entidade.AluguelId;
import entidade.ApoliceSeguro;
import entidade.Carro;
import entidade.CarroId;
import persitencia.AluguelDAO;
import persitencia.ApoliceSeguroDAO;
import persitencia.CarroDAO;
import persitencia.MotoristaDAO;

public class ValidarAluguel {
	public static void main(String[] args) {
		try {			
			CarroDAO carroDAO = new CarroDAO();
			Carro carro = null;
			CarroId carroId = new CarroId();
			carroId.setChassi("9G3C3DFDSFDSFSDF323");
			carroId.setPlaca("MKL 3230");
			carro = carroDAO.recuperar(carroId);
			if (carro != null) {
				AluguelDAO aluguelDAO = new AluguelDAO();
				Aluguel aluguel = new Aluguel();
				AluguelId aluguelId = new AluguelId();
				Motorista motorista = new Motorista(1, null, null, null, null, null);
				MotoristaDAO motoristaDAO = new MotoristaDAO();
				if (motoristaDAO.recuperarPeloId(motorista) == true) {
					Calendar dataPedido = Calendar.getInstance();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					aluguelId.setPessoaId(motorista.getId());
					dataPedido.setTime(dateFormat.parse("10/10/2017"));
					aluguelId.setDataPedido(dataPedido);

					aluguel.setCarro(carro);
					
					Date dataDevolucao = dateFormat.parse("12/10/2017");
					aluguel.setDataDevolucao(dataDevolucao);
					Date dataEntrega  = dateFormat.parse("13/11/2017");
					aluguel.setDataEntrega(dataEntrega);
					BigDecimal valorTotal = new BigDecimal(2000.00);
					aluguel.setValorTotal(valorTotal);
					aluguel.setId(aluguelId);

					aluguelDAO.criar(aluguel);
					
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
					apoliceSeguro.setAluguel(aluguel);
					apoliceSeguroDAO.criar(apoliceSeguro);					
				}
			}

			EntityManagerFactoryWrapper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
