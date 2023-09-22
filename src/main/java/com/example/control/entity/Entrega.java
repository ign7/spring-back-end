package com.example.control.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Entrega  implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private String codigoEntrega;
	private double total;
	private double lucroTotal;
	
	@OneToMany(mappedBy="entregaCarga")
	private List<Carga> cargas = new ArrayList<>();
	
	@JsonIgnore
	@JoinColumn(name="entrega_veiculo_id")
	@ManyToOne
	private Veiculo entregaVeiculos;
	
//	@JsonIgnore
//	@JoinColumn(name="entrega_empresa_id")
//	@ManyToOne
//	private Empresa entregaEmpresa;
  
	  public Entrega() {
		  
	  }	 

	public Entrega(Long id, String codigoEntrega) {
		super();
		this.id = id;
		this.codigoEntrega = codigoEntrega;
		//this.total=total;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
		

	public String getCodigoEntrega() {
		return codigoEntrega;
	}



	public void setCodigoEntrega(String codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}


	//public double getTotal() {
		//return total;
	//}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	public Veiculo getEntregaVeiculos() {
		return entregaVeiculos;
	}

	public void setEntregaVeiculos(Veiculo entregaVeiculos) {
		this.entregaVeiculos = entregaVeiculos;
	}
	
	

//	public Empresa getEntregaEmpresa() {
//		return entregaEmpresa;
//	}
//
//	public void setEntregaEmpresa(Empresa entregaEmpresa) {
//		this.entregaEmpresa = entregaEmpresa;
//	}
	
	public double getLucroTotal() {
	for(Carga carge : cargas) {
		lucroTotal+=carge.getLucro();			    			   
	   }		   
	   return lucroTotal;		  
	}
	
	public double getTotal() {		   
		   for(Carga carge : cargas) {
			   total+=carge.getLucro();			    			   
		   }		   
		   return total;		  
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
		Entrega other = (Entrega) obj;
		return Objects.equals(id, other.id);
	}
	  
	  
	  
  
  
	
	
	

}
