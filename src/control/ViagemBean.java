package control;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.ViagemDao;
import model.Viagem;

@ManagedBean (name = "paginaViagem")
@ViewScoped
public class ViagemBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Viagem viagem;
	private List<Viagem> listaDeViagems;
	private ListDataModel<Viagem> viagems;
	
	public ViagemBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ListDataModel<Viagem> getViagems() {
		return viagems;
	}

	public void setViagems(ListDataModel<Viagem> viagems) {
		this.viagems = viagems;
	}

	public List<Viagem> getListaDeViagems() {
		return listaDeViagems;
	}

	public void setListaDeViagems(List<Viagem> listaDeViagems) {
		this.listaDeViagems = listaDeViagems;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}
	
	
	//Metodos para operacao no Front (Camada de Apresentacao)
	
	public void PrepararEditar() {
		this.viagem = viagems.getRowData();
	}
	
	public void Update() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			ViagemDao daoViagem = new ViagemDao(conn);
			
			daoViagem.Update(this.viagem);
			
			this.listaDeViagems = daoViagem.GetAll();
			
			this.viagems = new ListDataModel<Viagem>(listaDeViagems);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste aAAAAAAAAAAAAhhhhhhhhhhhh");
		}
	}
	
	public void Insert() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			ViagemDao daoViagem = new ViagemDao(conn);
			
			daoViagem.Insert(this.viagem);
			
			this.listaDeViagems = daoViagem.GetAll();
			
			this.viagems = new ListDataModel<Viagem>(listaDeViagems);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste create");
		}
	}
	
	
	public void Delete() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			ViagemDao daoViagem = new ViagemDao(conn);
			
			daoViagem.Delete(this.viagem.getIdviagem());
			
			this.listaDeViagems = daoViagem.GetAll();
			
			this.viagems = new ListDataModel<Viagem>(listaDeViagems);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste");
		}
	}
	
	public void Clear() {
		this.viagem = new Viagem();
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection conn = fab.fazerConexao();
			
			ViagemDao daoViagem = new ViagemDao(conn);
			
			this.listaDeViagems = daoViagem.GetAll();
			
			this.viagems = new ListDataModel<Viagem>(listaDeViagems);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("teste");
		}
	}

}
