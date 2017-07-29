package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import av2.JPAUtil;
import entidade.Carro;
import entidade.CarroId;

public class CarroDAO implements ICarroDAO{

	@Override
	public boolean criar(Carro carro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.persist(carro);
		tx.commit();
		manager.close();
		return false;
	}
	
	public boolean recuperar(Carro carro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.find(carro.getClass(), carro.getId());
		
		tx.commit();
		manager.close();
		return false;
	}
	

	public Carro recuperar(CarroId carroId) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Carro carro = null;

		carro = manager.find((new Carro()).getClass(), carroId);
		
		tx.commit();
		manager.close();
		return carro;
	}

	@Override
	public boolean atualizar(Carro carro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean deletar(Carro carro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

}
