package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import av2.EntityManagerFactoryWrapper;
import entidade.Acessorio;

public class AcessorioDAO implements IAcessorioDAO {

	@Override
	public boolean criar(Acessorio acessorio) {
		boolean ret = true;
		EntityManager manager = null;
		EntityTransaction tx = null;
		try {
			manager = EntityManagerFactoryWrapper.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(acessorio);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (manager != null)
				manager.close();
		}
		return ret;
	}

	@Override
	public boolean recuperar(Acessorio acessorio) {
		boolean ret = true;
		EntityManager manager = null;
		EntityTransaction tx = null;
		try {
			manager = EntityManagerFactoryWrapper.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			
			Query query = manager.createQuery("select a from Acessorio a where lower(a.descricao) = lower(:descricao))");
			query.setParameter("descricao", acessorio.getDescricao());
			Acessorio result = (Acessorio) query.getSingleResult();
			if (result == null)
				ret = false;
			else {
				acessorio.setId(result.getId());
			}

			tx.commit();
		} catch (NoResultException noResult) {
			ret = false;
		} catch (NonUniqueResultException NonUnique) {
			ret = false;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (manager != null)
				manager.close();
		}
		return ret;
	}

	@Override
	public boolean atualizar(Acessorio original, Acessorio modified) {
		boolean ret = true;
		EntityManager manager = null;
		EntityTransaction tx = null;
		try {
			manager = EntityManagerFactoryWrapper.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			Acessorio valor = manager.find(original.getClass(), original.getId());
			valor.setDescricao(modified.getDescricao());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (manager != null)
				manager.close();
		}

		return ret;
	}

	@Override
	public boolean deletar(Acessorio acessorio) {
		boolean ret = true;
		EntityManager manager = null;
		EntityTransaction tx = null;
		try {
			manager = EntityManagerFactoryWrapper.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			Acessorio result = manager.find(acessorio.getClass(), acessorio.getId());
			manager.remove(result);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (manager != null)
				manager.close();
		}
		return ret;
	}

}
