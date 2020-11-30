package control;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.AutomovelDao;
import model.Automovel;

@ManagedBean (name = "paginaAutomovel")
@ViewScoped
public class AutomovelBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Automovel automovel;
	private List<Automovel> listaDeAutomovels;
	private ListDataModel<Automovel> automovels;
	
	public AutomovelBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ListDataModel<Automovel> getAutomovels() {
		return automovels;
	}

	public void setAutomovels(ListDataModel<Automovel> automovels) {
		this.automovels = automovels;
	}

	public List<Automovel> getListaDeAutomovels() {
		return listaDeAutomovels;
	}

	public void setListaDeAutomovels(List<Automovel> listaDeAutomovels) {
		this.listaDeAutomovels = listaDeAutomovels;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
	
	
	//Metodos para operacao no Front (Camada de Apresentacao)
	
	public void PrepararEditar() {
		this.automovel = automovels.getRowData();
	}
	
	public void Update() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			AutomovelDao daoAutomovel = new AutomovelDao(conn);
			
			daoAutomovel.Update(this.automovel);
			
			this.listaDeAutomovels = daoAutomovel.GetAll();
			
			this.automovels = new ListDataModel<Automovel>(listaDeAutomovels);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste aAAAAAAAAAAAAhhhhhhhhhhhh");
		}
	}
	
	public void Insert() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			AutomovelDao daoAutomovel = new AutomovelDao(conn);
			
			daoAutomovel.Insert(this.automovel);
			
			this.listaDeAutomovels = daoAutomovel.GetAll();
			
			this.automovels = new ListDataModel<Automovel>(listaDeAutomovels);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste create");
		}
	}
	
	
	public void Delete() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			AutomovelDao daoAutomovel = new AutomovelDao(conn);
			
			daoAutomovel.Delete(this.automovel.getIdautomovel());
			
			this.listaDeAutomovels = daoAutomovel.GetAll();
			
			this.automovels = new ListDataModel<Automovel>(listaDeAutomovels);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste");
		}
	}
	
	public void Clear() {
		this.automovel = new Automovel();
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			AutomovelDao daoAutomovel = new AutomovelDao(conn);
			
			this.listaDeAutomovels = daoAutomovel.GetAll();
			
			this.automovels = new ListDataModel<Automovel>(listaDeAutomovels);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste");
		}
	}

}
