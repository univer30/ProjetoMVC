
import java.util.ArrayList;

import br.com.JavaWeb.domain.Cidade;
import br.com.JavaWeb.domain.Estado;
import br.comJavaWeb.DAO.CidadeDAO;
import br.comJavaWeb.DAO.EstadoDAO;

public class CidadeDAOTeste {

	 public void salvar() {
		 CidadeDAO cidadeDAO = new CidadeDAO();
		 EstadoDAO estadoDAO = new EstadoDAO();
		 Estado estado = estadoDAO.buscar(2L);
		 
		 Cidade cidade = new Cidade();
		 cidade.setNome("Marília");
		 cidade.setEstado(estado);
		 
		 cidadeDAO.salvar(cidade);
	 }
	 
	public void buscar() {
		Long codigo = 4L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		System.out.println("Codigo da cidade: " + cidade.getCondigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("Codigo da estado: " + cidade.getEstado().getCondigo());
		System.out.println("Sigla da estado: " + cidade.getEstado().getSigla().getClass());
		System.out.println("Nome da estado: " + cidade.getEstado().getNome());
		
		
		
	}
	
	
	public void excluir() {
		Long codigo = 4L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		cidadeDAO.excluir(cidade);	
		
	}
	
	public void editar(){
		Long codigoCidade = 4L;
		Long codigoEstado = 2L;
		
		EstadoDAO estadoDAO = new  EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		System.out.println("Cidade a ser editada:");
		System.out.println("Codigo da cidade: " + cidade.getCondigo());
		
		cidade.setNome("Florianopolis");
		cidade.setEstado(estado);
		cidadeDAO.editar(cidade);
		
		System.out.println("Cidade editada:");
		System.out.println("Codigo da cidade: " + cidade.getCondigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("Codigo da estado: " + cidade.getEstado().getCondigo());
		System.out.println("Sigla da estado: " + cidade.getEstado().getSigla().getClass());
		System.out.println("Nome da estado: " + cidade.getEstado().getNome());
			
	}
	
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		ArrayList<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade : resultado) {
			System.out.println("Codigo da cidade: " + cidade.getCondigo());
			System.out.println("Nome da cidade: " + cidade.getNome());
			System.out.println("Codigo da estado: " + cidade.getEstado().getCondigo());
			System.out.println("Sigla da estado: " + cidade.getEstado().getSigla().getClass());
			System.out.println("Nome da estado: " + cidade.getEstado().getNome());
			
		}
	}

}
