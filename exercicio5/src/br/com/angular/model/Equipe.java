package br.com.angular.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "equipe")
@XmlRootElement
public class Equipe implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@JsonIgnore
	@OneToMany(mappedBy = "idEquipe")
	private List<Plano> planoList;

	public Equipe() {
	}

	public Equipe(Integer id) {
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

	public List<Plano> getPlanoList() {
		return planoList;
	}

	public void setPlanoList(List<Plano> planoList) {
		this.planoList = planoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Equipe)) {
			return false;
		}
		Equipe other = (Equipe) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.report.Equipe[ id=" + id + " ]";
	}

	public List<Plano> getItems() {
		return planoList;
	}

}
