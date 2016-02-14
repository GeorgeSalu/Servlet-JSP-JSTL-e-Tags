package br.edu.devmedia.crud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.devmedia.crud.bo.UsuarioBO;
import br.edu.devmedia.crud.exception.NegocioException;

@WebServlet("/main")
public class MainSevlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		String proxima = null;
		if ("sair".equals(acao)) {
			proxima = "logout.jsp";
		} else if ("login".equals(acao)) {
			try {
				new UsuarioBO().validarUsuario(request);
			} catch (NegocioException e) {
				request.setAttribute("msgErro", e.getMessage());
				proxima = "login.jsp";
			}
			proxima = "index.jsp";
		} else if ("consultas".equals(acao)) {
			proxima = "consultas.jsp";
		}
		request.getRequestDispatcher(proxima).forward(request, response);
	}

	
}
