package br.com.angular.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.angular.model.Equipe;
import br.com.angular.model.Plano;

@Stateless(name = "equipeRepositoryImpl", mappedName = "equipeRepositoryImpl")
@LocalBean
public class EquipeRepositoryImpl implements Repository<Equipe> {
	@PersistenceContext(unitName = "produtoPU")
	EntityManager em;

	@Override
	public void salvarOrAtualizar(Equipe modelo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Equipe> consulta() {
		return em.createQuery("SELECT e FROM Equipe e ", Equipe.class)
				.getResultList();
	}

	@Override
	public void deletar(Equipe modelo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Equipe consultaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
