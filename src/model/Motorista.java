package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Motorista implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idmotorista;
	private int cpf;
	private int idade;
	private int cel;
	private String email;
	private String cidade;
	private String nome;
	
	private List<Viagem> viagens;
	
	public Motorista() {
		this.viagens = new ArrayList<Viagem>();
	}

	public Motorista(int idmotorista, int cpf, int idade, int cel, String email, String cidade, String nome,
			List<Viagem> viagens) {
		super();
		this.idmotorista = idmotorista;
		this.cpf = cpf;
		this.idade = idade;
		this.cel = cel;
		this.email = email;
		this.cidade = cidade;
		this.nome = nome;
		this.viagens = viagens;
	}

	public int getIdmotorista() {
		return idmotorista;
	}

	public void setIdmotorista(int idmotorista) {
		this.idmotorista = idmotorista;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getCel() {
		return cel;
	}

	public void setCel(int cel) {
		this.cel = cel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		result = prime * result + idmotorista;
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
		Motorista other = (Motorista) obj;
		if (idmotorista != other.idmotorista)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Motorista [idmotorista=" + idmotorista + ", cpf=" + cpf + ", idade=" + idade + ", cel=" + cel
				+ ", email=" + email + ", cidade=" + cidade + ", nome=" + nome + "]";
	}
	
}