package br.edu.devmedia.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.edu.devmedia.crud.dao.CadastroDAO;
import br.edu.devmedia.crud.exception.PersistenciaException;

public class CadastroCommand implements Command {
	
private String proximo;
	
	private CadastroDAO cadastroDAO;
	
	public String execute(HttpServletRequest request) {
		cadastroDAO = new CadastroDAO();
		proximo = "cadastros.jsp";
		String getCidades = request.getParameter("getCidades");
		
		try {
			if (getCidades != null && !"".equals(getCidades)) {
				String id = request.getParameter("idEstado");
				int idEstado = Integer.parseInt(id);
				
			} else {
				request.getSession().setAttribute("listaUF", cadastroDAO.listarUFs());
			}
		} catch (PersistenciaException e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proximo;
	}
		
}
