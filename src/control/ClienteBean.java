package control;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.ClienteDao;
import model.Cliente;

@ManagedBean (name = "paginaCliente")
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private List<Cliente> listaDeClientes;
	private ListDataModel<Cliente> clientes;
	
	public ClienteBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ListDataModel<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ListDataModel<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	//Metodos para operacao no Front (Camada de Apresentacao)
	
	public void PrepararEditar() {
		this.cliente = clientes.getRowData();
	}
	
	public void Update() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			ClienteDao daoCliente = new ClienteDao(conn);
			
			daoCliente.Update(this.cliente);
			
			this.listaDeClientes = daoCliente.GetAll();
			
			this.clientes = new ListDataModel<Cliente>(listaDeClientes);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("teste aAAAAAAAAAAAAhhhhhhhhhhhh");
		}
	}
	
	public void Clear() {
		this.cliente = new Cliente();
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			ClienteDao daoCliente = new ClienteDao(conn);
			
			this.listaDeClientes = daoCliente.GetAll();
			
			this.clientes = new ListDataModel<Cliente>(listaDeClientes);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste");
		}
	}

}
