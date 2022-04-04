package br.com.JavaWeb.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.JavaWeb.domain.Estado;
import br.comJavaWeb.DAO.EstadoDAO;

@ViewScoped
@ManagedBean(name="estadoBean")
public class EstadoBean implements Serializable {
  private Estado estado;
 
  private ArrayList<Estado> estados;

  public Estado getEstado() {
	return estado;
  }

  public void setEstado(Estado estado) {
	this.estado = estado;
  }

  public ArrayList<Estado> getEstados() {
	return estados;
  }

  public void setEstados(ArrayList<Estado> estados) {
	this.estados = estados;
  }
 
  @PostConstruct
   public void listar() {
	  try { 
		 EstadoDAO estadoDAO = new EstadoDAO();
		 estados = estadoDAO.listar();
		
	  } catch (RuntimeException ex) {
	       ex.printStackTrace();
    }
 
  }
  
  public void novo() {
	  estado = new Estado();
  }
  
public void excluir( ActionEvent evento) {
	   try {
		   estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		   EstadoDAO estadoDAO = new EstadoDAO();
		   estadoDAO.excluir(estado);
		   estados = estadoDAO.listar();
	} catch (RuntimeException ex) {
		ex.printStackTrace();
	}
  }

public void salvar() {
	try {
		   EstadoDAO estadoDAO = new EstadoDAO();
		   estadoDAO.salvar(estado);
		   estados = estadoDAO.listar();
	} catch (RuntimeException ex) {
		ex.printStackTrace();
	}
}

public void editar(ActionEvent evento) {
	try {
		   estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
	} catch (RuntimeException ex) {
		   ex.printStackTrace();
	}	
  }
    
}
