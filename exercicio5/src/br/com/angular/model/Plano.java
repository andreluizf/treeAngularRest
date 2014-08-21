package br.com.angular.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.angular.helper.DataHelper;

@Entity
@Table(name = "plano")
@XmlRootElement
public class Plano implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "data_inicio")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	@Column(name = "data_fim")
	@Temporal(TemporalType.DATE)
	private Date dataFim;

	@OneToMany(mappedBy = "idPlano", fetch = FetchType.EAGER)
	private List<Plano> planoList;
	@JsonIgnore
	@JoinColumn(name = "id_plano", referencedColumnName = "id")
	@ManyToOne
	private Plano idPlano;
	@JsonIgnore
	@JoinColumn(name = "id_equipe", referencedColumnName = "id")
	@ManyToOne
	private Equipe idEquipe;

	public Plano() {
	}

	public Plano(String nome, Date dataInicio, Date dataFim) {
		super();
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Plano(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataInicio() {
		return DataHelper.formataData("dd/MM/yyyy", dataInicio);
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return DataHelper.formataData("dd/MM/yyyy", dataFim);
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@XmlTransient
	public List<Plano> getPlanoList() {
		return planoList;
	}

	public void setPlanoList(List<Plano> planoList) {
		this.planoList = planoList;
	}

	public Plano getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(Plano idPlano) {
		this.idPlano = idPlano;

	}

	public Equipe getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(Equipe idEquipe) {
		this.idEquipe = idEquipe;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Plano)) {
			return false;
		}
		Plano other = (Plano) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.report.Plano[ id=" + id + " ]";
	}
	
	public List<Plano> getItems(){
		return planoList;
	}

}
