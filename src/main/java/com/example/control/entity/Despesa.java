package com.example.control.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
@Entity
public class Despesa  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private double refeicao;
	private double ajudante;
	private double pedagio;
	private double combustivel;
	private double litro;
	//private String contador;
	//private double preco_Contador;
	//private Double MEI_valor;
	private double gastoTotal;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Carga carga;
	
	public Despesa() {
		
	}

	public Despesa(long id, double refeicao, double ajudante, double pedagio) {
		super();
		this.id = id;
		this.refeicao = refeicao;
		this.ajudante = ajudante;
		this.pedagio = pedagio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(double refeicao) {
		this.refeicao = refeicao;
	}

	public double getAjudante() {
		return ajudante;
	}

	public void setAjudante(double ajudante) {
		this.ajudante = ajudante;
	}
	
	

	public double getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(double combustivel) {
		this.combustivel = combustivel;
	}

	public double getLitro() {
		return litro;
	}

	public void setLitro(double litro) {
		this.litro = litro;
	}

	public double getPedagio() {
		return pedagio;
	}

	public void setPedagio(double pedagio) {
		this.pedagio = pedagio;
	}
		

	public double getGastoTotal() {
		return gastoTotal;
	}

	public void setGastoTotal(double gastoTotal) {
		this.gastoTotal = gastoTotal;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
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
		Despesa other = (Despesa) obj;
		return id == other.id;
	}
	
	

}
