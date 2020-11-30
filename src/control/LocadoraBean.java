package control;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.LocadoraDao;
import model.Locadora;

@ManagedBean (name = "paginaLocadora")
@ViewScoped
public class LocadoraBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Locadora locadora;
	private List<Locadora> listaDeLocadoras;
	private ListDataModel<Locadora> locadoras;
	
	public LocadoraBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ListDataModel<Locadora> getLocadoras() {
		return locadoras;
	}

	public void setLocadoras(ListDataModel<Locadora> locadoras) {
		this.locadoras = locadoras;
	}

	public List<Locadora> getListaDeLocadoras() {
		return listaDeLocadoras;
	}

	public void setListaDeLocadoras(List<Locadora> listaDeLocadoras) {
		this.listaDeLocadoras = listaDeLocadoras;
	}

	public Locadora getLocadora() {
		return locadora;
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}
	
	
	//Metodos para operacao no Front (Camada de Apresentacao)
	
	public void PrepararEditar() {
		this.locadora = locadoras.getRowData();
	}
	
	public void Update() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			LocadoraDao daoLocadora = new LocadoraDao(conn);
			
			daoLocadora.Update(this.locadora);
			
			this.listaDeLocadoras = daoLocadora.GetAll();
			
			this.locadoras = new ListDataModel<Locadora>(listaDeLocadoras);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste aAAAAAAAAAAAAhhhhhhhhhhhh");
		}
	}
	
	public void Insert() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			LocadoraDao daoLocadora = new LocadoraDao(conn);
			
			daoLocadora.Insert(this.locadora);
			
			this.listaDeLocadoras = daoLocadora.GetAll();
			
			this.locadoras = new ListDataModel<Locadora>(listaDeLocadoras);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste create");
		}
	}
	
	
	public void Delete() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			LocadoraDao daoLocadora = new LocadoraDao(conn);
			
			daoLocadora.Delete(this.locadora.getIdlocadora());
			
			this.listaDeLocadoras = daoLocadora.GetAll();
			
			this.locadoras = new ListDataModel<Locadora>(listaDeLocadoras);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste");
		}
	}
	
	public void Clear() {
		this.locadora = new Locadora();
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			LocadoraDao daoLocadora = new LocadoraDao(conn);
			
			this.listaDeLocadoras = daoLocadora.GetAll();
			
			this.locadoras = new ListDataModel<Locadora>(listaDeLocadoras);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste inicio");
		}
	}

}
