package com.example.control.entity;

import java.io.Serializable;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Carga  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String local;
	private double distancia;
	private String dataSolicitacao;
	private String dataEntrega;
	private String nomeEmpresa;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
	@OneToOne(mappedBy="carga",cascade=CascadeType.ALL)
	private Despesa despesa;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="veiculo_carga_id")
	private Veiculo cargaVeiculo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="entrega_carga_id")
	private Entrega entregaCarga;
	
	public Carga() {
		
	}

	public Carga(long id, String nome, String local, double distancia, String dataSolicitacao, String dataEntrega) {
		super();
		this.id = id;
		this.nome = nome;
		this.local = local;
		this.distancia = distancia;
		this.dataSolicitacao = dataSolicitacao;
		this.dataEntrega = dataEntrega;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public String getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
	
	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
	
	

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	
	

	public Veiculo getCargaVeiculo() {
		return cargaVeiculo;
	}

	public void setCargaVeiculo(Veiculo cargaVeiculo) {
		this.cargaVeiculo = cargaVeiculo;
	}
	
	

	public Entrega getEntregaCarga() {
		return entregaCarga;
	}

	public void setEntregaCarga(Entrega entregaCarga) {
		this.entregaCarga = entregaCarga;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carga other = (Carga) obj;
		return id == other.id;
	}
	
	

}
