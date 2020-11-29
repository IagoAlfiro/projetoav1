package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Locadora implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idlocadora;
	private String endereco;
	private String cidade;
	private String nome;
	
	private List<Automovel> automoveis;
	
	public Locadora() {
		this.automoveis = new ArrayList<Automovel>();
	}
	
	public Locadora(int id, String endereco, String cidade, String nome, List<Automovel> automoveis) {
		super();
		this.idlocadora = id;
		this.endereco = endereco;
		this.cidade = cidade;
		this.nome = nome;
		this.automoveis = automoveis;
	}
	
	public int getIdlocadora() {
		return idlocadora;
	}

	public void setIdlocadora(int idlocadora) {
		this.idlocadora = idlocadora;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idlocadora;
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
		Locadora other = (Locadora) obj;
		if (idlocadora != other.idlocadora)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Locadora [id=" + idlocadora + ", endereco=" + endereco + ", cidade=" + cidade + ", nome=" + nome + "]";
	}
	
		
}
