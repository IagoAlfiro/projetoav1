package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idcliente;
	private int cpf;
	private int cel;
	private String nome;
	private String endereco;
	private String cidade;
	private String email;
	
	private List<Viagem> viagens;
	
	public Cliente() {
		this.viagens = new ArrayList<Viagem>();
	}

	public Cliente(int idcliente, int cpf, int cel, String nome, String endereco, String cidade, String email,
			List<Viagem> viagens) {
		super();
		this.idcliente = idcliente;
		this.cpf = cpf;
		this.cel = cel;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.email = email;
		this.viagens = viagens;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getCel() {
		return cel;
	}

	public void setCel(int cel) {
		this.cel = cel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		result = prime * result + idcliente;
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
		Cliente other = (Cliente) obj;
		if (idcliente != other.idcliente)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", cpf=" + cpf + ", cel=" + cel + ", nome=" + nome + ", endereco="
				+ endereco + ", cidade=" + cidade + ", email=" + email + "]";
	}
	
}