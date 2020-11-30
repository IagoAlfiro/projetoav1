package control;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.MotoristaDao;
import model.Motorista;

@ManagedBean (name = "paginaMotorista")
@ViewScoped
public class MotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Motorista motorista;
	private List<Motorista> listaDeMotoristas;
	private ListDataModel<Motorista> motoristas;
	
	public MotoristaBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ListDataModel<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(ListDataModel<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

	public List<Motorista> getListaDeMotoristas() {
		return listaDeMotoristas;
	}

	public void setListaDeMotoristas(List<Motorista> listaDeMotoristas) {
		this.listaDeMotoristas = listaDeMotoristas;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	
	//Metodos para operacao no Front (Camada de Apresentacao)
	
	public void PrepararEditar() {
		this.motorista = motoristas.getRowData();
	}
	
	public void Update() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			MotoristaDao daoMotorista = new MotoristaDao(conn);
			
			daoMotorista.Update(this.motorista);
			
			this.listaDeMotoristas = daoMotorista.GetAll();
			
			this.motoristas = new ListDataModel<Motorista>(listaDeMotoristas);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("teste aAAAAAAAAAAAAhhhhhhhhhhhh");
		}
	}
	
	public void Insert() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			MotoristaDao daoMotorista = new MotoristaDao(conn);
			
			daoMotorista.Insert(this.motorista);
			
			this.listaDeMotoristas = daoMotorista.GetAll();
			
			this.motoristas = new ListDataModel<Motorista>(listaDeMotoristas);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("teste create");
		}
	}
	
	
	public void Delete() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			MotoristaDao daoMotorista = new MotoristaDao(conn);
			
			daoMotorista.Delete(this.motorista.getIdmotorista());
			
			this.listaDeMotoristas = daoMotorista.GetAll();
			
			this.motoristas = new ListDataModel<Motorista>(listaDeMotoristas);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("teste");
		}
	}
	
	public void Clear() {
		this.motorista = new Motorista();
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			MotoristaDao daoMotorista = new MotoristaDao(conn);
			
			this.listaDeMotoristas = daoMotorista.GetAll();
			
			this.motoristas = new ListDataModel<Motorista>(listaDeMotoristas);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste");
		}
	}

}
