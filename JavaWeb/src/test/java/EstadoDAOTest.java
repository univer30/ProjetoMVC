import java.util.ArrayList;

import br.com.JavaWeb.domain.Estado;
import br.comJavaWeb.DAO.EstadoDAO;

public class EstadoDAOTest {

	public void salvar() {
        EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = new Estado();
		
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		estadoDAO.salvar(estado);
	}
	
	
	public void buscar() {
		Long codigo = 1L;
        EstadoDAO estadoDAO = new EstadoDAO();
		
		Estado estado = new Estado();
		estado = estadoDAO.buscar(codigo);
		//System.out.println(estado.getNome());
	}
	
	public void excluir() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null) {
			System.out.println("Nenhum registro encontrado!");
		}else {
			estadoDAO.excluir(estado);
			System.out.println("Registro removido!");
			
		}
	}
	
	public void editar() {
		 Long codigo = 2L;
		 EstadoDAO estadoDAO = new EstadoDAO();
			Estado estado = estadoDAO.buscar(codigo);
			
			if(estado == null) {
				System.out.println("Nenhum registro encontrado!");
			}else {
				System.out.println("Registro editado - Antes: ");
				System.out.println(estado.getCondigo() + "-" + estado.getSigla() + "-" + estado.getNome());
				
				estado.setNome("Santa Catarina");
				estado.setSigla("SC");
				estadoDAO.editar(estado);
				
				System.out.println("Registro editado - Depois: ");
				System.out.println(estado.getCondigo() + "-" + estado.getSigla() + "-" + estado.getNome());
				
			}		
	}
	
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		ArrayList<Estado> resultado = estadoDAO.listar();
		System.out.println("Total de registros encontrados:" +resultado.size());
		
		for(Estado estado : resultado) {
			 System.out.println(estado.getNome());
		}
	}
	
	

}
