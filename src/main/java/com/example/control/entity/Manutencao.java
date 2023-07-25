package com.example.control.entity;

import java.io.Serializable;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Manutencao  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private double km;
	private double valor;
	private String dataManutencao;
	
	private String observacao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="veiculo_manutencao_id")
	private Veiculo manutencao;
	
	public Manutencao() {
		
	}

	public Manutencao(long id, String nome, double km, double valor, String dataManutencao, String observacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.km = km;
		this.valor = valor;
		this.dataManutencao = dataManutencao;
		this.observacao = observacao;
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

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(String dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	

	public Veiculo getManutencao() {
		return manutencao;
	}

	public void setManutencao(Veiculo manutencao) {
		this.manutencao = manutencao;
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
		Manutencao other = (Manutencao) obj;
		return id == other.id;
	}
	
	

}
