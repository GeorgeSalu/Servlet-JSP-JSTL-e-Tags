package br.edu.devmedia.crud.bo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import br.edu.devmedia.crud.dao.UsuarioDAO;
import br.edu.devmedia.crud.dto.UsuarioDTO;
import br.edu.devmedia.crud.exception.NegocioException;
import br.edu.devmedia.crud.exception.ValidationException;
import br.edu.devmedia.crud.util.Util;
import br.edu.devmedia.crud.validator.LoginValidator;

/**
 * Classe responsável por gerenciar os métodos de negócio do usuário
 * 
 * @author George
 * 
 */
public class UsuarioBO {

	/**
	 * Método resposável por validar o usuário
	 * 
	 * @param request
	 * @return
	 * @throws NegocioException 
	 */
	public boolean validarUsuario(HttpServletRequest request) throws NegocioException {
		boolean isValido = true;
		try {
			String usuario = request.getParameter("login");
			String senha = request.getParameter("senha");

			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setUsuario(usuario);
			usuarioDTO.setSenha(senha);

			// Valida campos obg
			Map<String, Object> valores = new HashMap<>();
			valores.put("Usuário", usuario);
			valores.put("Senha", senha);
			if (new LoginValidator().validar(valores)) {
				isValido = true;
			}
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			isValido = usuarioDAO.validarUsuario(usuarioDTO);
		} catch (ValidationException e) {
			request.setAttribute("msgErro", Util.concatenaMensagensRequest(request, e, "msgErro"));
			isValido = false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return isValido;
	}

}
