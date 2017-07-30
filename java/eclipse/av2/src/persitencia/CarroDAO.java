package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import av2.EntityManagerFactoryWrapper;
import entidade.Carro;
import entidade.CarroId;

public class CarroDAO implements ICarroDAO{

	@Override
	public boolean criar(Carro carro) {
		EntityManager manager = EntityManagerFactoryWrapper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.persist(carro);
		tx.commit();
		manager.close();
		return false;
	}
	
	@Override
	public Carro recuperar(CarroId carroId) {
		EntityManager manager = EntityManagerFactoryWrapper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Carro result = manager.find((new Carro()).getClass(), carroId);
		
		tx.commit();
		manager.close();
		return result;
	}
	
	@Override
	public boolean atualizar(Carro carro) {
		EntityManager manager = EntityManagerFactoryWrapper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean deletar(Carro carro) {
		EntityManager manager = EntityManagerFactoryWrapper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

}
