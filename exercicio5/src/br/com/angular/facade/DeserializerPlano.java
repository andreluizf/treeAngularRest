package br.com.angular.facade;

import java.sql.Date;

public class DeserializerPlano {
	private int equipe;
	private int parent;
	private String nome;
	private Date dataInicio;
	private Date dataFim;
	public DeserializerPlano() {
		super();
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public int getEquipe() {
		return equipe;
	}
	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}
	@Override
	public String toString() {
		return "DeserializerPlano [parent=" + parent + ", nome=" + nome
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}
	
	
	
	
}
