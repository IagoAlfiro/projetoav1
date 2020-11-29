package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Automovel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idautomovel;
	private int locadora_idlocadora;
	private String modelo;
	private String tipo;
	private int ano;
	private String marca;
	
	private List<Viagem> viagens;
	
	public Automovel() {
		this.viagens = new ArrayList<Viagem>();
	}
		
	public Automovel(int idautomovel, int locadora_idlocadora, String modelo, String tipo, int ano, String marca,
			List<Viagem> viagens) {
		super();
		this.idautomovel = idautomovel;
		this.locadora_idlocadora = locadora_idlocadora;
		this.modelo = modelo;
		this.tipo = tipo;
		this.ano = ano;
		this.marca = marca;
		this.viagens = viagens;
	}

	public int getIdautomovel() {
		return idautomovel;
	}

	public void setIdautomovel(int idautomovel) {
		this.idautomovel = idautomovel;
	}

	public int getLocadora_idlocadora() {
		return locadora_idlocadora;
	}

	public void setLocadora_idlocadora(int locadora_idlocadora) {
		this.locadora_idlocadora = locadora_idlocadora;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idautomovel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovel other = (Automovel) obj;
		if (idautomovel != other.idautomovel)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Automovel [id=" + idautomovel + ", locadora_idlocadora=" + locadora_idlocadora + ", modelo=" + modelo + ", tipo="
				+ tipo + ", ano=" + ano + ", marca=" + marca + "]";
	}

	
	
	
	
	
	
}
