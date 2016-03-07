package br.edu.devmedia.crud.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.edu.devmedia.crud.dao.CadastroDAO;
import br.edu.devmedia.crud.dto.CidadeDTO;
import br.edu.devmedia.crud.dto.UfDTO;
import br.edu.devmedia.crud.exception.PersistenciaException;

public class MontagemCadastroCommand implements Command {
	
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
				
				List<CidadeDTO> listaCidades = cadastroDAO.consultarCidadesPorEstado(idEstado);
				request.setAttribute("listaCidades", listaCidades);
			} else {
				List<UfDTO> listaUFs = cadastroDAO.listarUFs();
				request.getSession().setAttribute("listaUF", listaUFs);
			}
		} catch (PersistenciaException e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proximo;
	}
	
}
