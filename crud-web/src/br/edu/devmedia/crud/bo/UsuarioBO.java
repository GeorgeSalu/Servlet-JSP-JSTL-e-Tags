package br.edu.devmedia.crud.bo;

import javax.servlet.http.HttpServletRequest;

import br.edu.devmedia.crud.dao.UsuarioDAO;
import br.edu.devmedia.crud.dto.UsuarioDTO;
import br.edu.devmedia.crud.exception.NegocioException;
import br.edu.devmedia.crud.exception.PersistenciaException;

/**
 * Classe respons�vel por gerenciar os m�todos de neg�cio do usu�rio
 * 
 * @author George
 * 
 */
public class UsuarioBO {

	/**
	 * M�todo respos�vel por validar o usu�rio
	 * 
	 * @param request
	 * @return
	 * @throws NegocioException 
	 */
	public boolean validarUsuario(HttpServletRequest request) throws NegocioException {
		boolean isValido = true;
		try {
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");

			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setUsuario(usuario);
			usuarioDTO.setSenha(senha);

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			isValido = usuarioDAO.validarUsuario(usuarioDTO);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return isValido;
	}

}
