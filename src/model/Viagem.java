package model;

import java.io.Serializable;

public class Viagem implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idviagem;
	private int cliente_idcliente;
	private int motorista_idmotorista;
	private int automovel_idautomovel;
	private String data;
	private String duracao;
	private String inicio;
	
	public Viagem() {
		
	}

	public Viagem(int idviagem, int cliente_idcliente, int motorista_idmotorista, int automovel_idautomovel,
			String data, String duracao, String inicio) {
		super();
		this.idviagem = idviagem;
		this.cliente_idcliente = cliente_idcliente;
		this.motorista_idmotorista = motorista_idmotorista;
		this.automovel_idautomovel = automovel_idautomovel;
		this.data = data;
		this.duracao = duracao;
		this.inicio = inicio;
	}

	public int getIdviagem() {
		return idviagem;
	}

	public void setIdviagem(int idviagem) {
		this.idviagem = idviagem;
	}

	public int getCliente_idcliente() {
		return cliente_idcliente;
	}

	public void setCliente_idcliente(int cliente_idcliente) {
		this.cliente_idcliente = cliente_idcliente;
	}

	public int getMotorista_idmotorista() {
		return motorista_idmotorista;
	}

	public void setMotorista_idmotorista(int motorista_idmotorista) {
		this.motorista_idmotorista = motorista_idmotorista;
	}

	public int getAutomovel_idautomovel() {
		return automovel_idautomovel;
	}

	public void setAutomovel_idautomovel(int automovel_idautomovel) {
		this.automovel_idautomovel = automovel_idautomovel;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idviagem;
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
		Viagem other = (Viagem) obj;
		if (idviagem != other.idviagem)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Viagem [idviagem=" + idviagem + ", cliente_idcliente=" + cliente_idcliente + ", motorista_idmotorista="
				+ motorista_idmotorista + ", automovel_idautomovel=" + automovel_idautomovel + ", data=" + data
				+ ", duracao=" + duracao + ", inicio=" + inicio + "]";
	}
	
	
}