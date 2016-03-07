package br.edu.devmedia.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.edu.devmedia.crud.dao.CadastroDAO;

public class CadastroPessoaCommand implements Command {
	
	private String proximo;
	
	private CadastroDAO cadastroDAO;
	
	public String execute(HttpServletRequest request) {
		cadastroDAO = new CadastroDAO();
		proximo = "cadastros.jsp";
		
		
		
//		try {
//			
//		} catch (PersistenciaException e) {
//			request.setAttribute("msgErro", e.getMessage());
//		}
//		
		return proximo;
	}
	
}
