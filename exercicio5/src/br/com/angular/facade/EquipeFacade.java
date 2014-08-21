package br.com.angular.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.angular.model.Equipe;
import br.com.angular.model.Plano;
import br.com.angular.repository.EquipeRepositoryImpl;
import br.com.angular.repository.PlanoRepositoryImpl;

@Path("equipe")
public class EquipeFacade {
	@Inject
	Plano plano;
	@Inject
	Equipe equipe;
	@EJB(beanName = "planoRepositoryImpl")
	PlanoRepositoryImpl planoRepositpory;
	@EJB(beanName = "equipeRepositoryImpl")
	EquipeRepositoryImpl equipeRepositpory;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addEquipe(DeserializerPlano p) {
		System.out.println("aki" + p.toString());
		Plano parent = planoRepositpory.consultaById(3);
		plano.setNome(p.getNome());
		// plano.setIdPlano(parent);
		plano.setDataInicio(p.getDataInicio());
		plano.setDataFim(p.getDataFim());
		planoRepositpory.salvarOrAtualizar(plano);

	}

	@Path("list")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<Equipe> list() {
		System.out.println("consulta equipe" );
		return equipeRepositpory.consulta();
	}

}
