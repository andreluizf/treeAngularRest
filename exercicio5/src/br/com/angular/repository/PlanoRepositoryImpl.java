package br.com.angular.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import br.com.angular.model.Plano;

@Stateless(name = "planoRepositoryImpl", mappedName = "planoRepositoryImpl")
@LocalBean
public class PlanoRepositoryImpl implements Repository<Plano> {
	@PersistenceContext(unitName = "produtoPU")
	EntityManager em;

	@Override
	public void salvarOrAtualizar(Plano modelo) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			if (modelo.getId() != null) {
				em.merge(modelo);
			} else {
				em.persist(modelo);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();

		}

	}

	@Override
	public List<Plano> consulta() {
		return em.createQuery("SELECT p FROM Plano p  where p.idPlano is null ", Plano.class)
				.getResultList();
	}

	@Override
	public void deletar(Plano modelo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Plano consultaById(int id) {
		try {
			return em
					.createQuery("SELECT p FROM Plano p where p.id = :id",
							Plano.class).setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

}
