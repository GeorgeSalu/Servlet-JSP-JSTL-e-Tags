package br.edu.devmedia.crud.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.devmedia.crud.command.Command;
import br.edu.devmedia.crud.command.LoginCommand;
import br.edu.devmedia.crud.exception.NegocioException;

@WebServlet("/main")
public class MainSevlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Map<String, Command> comandos = new HashMap<String, Command>();

	@Override
	public void init() throws ServletException {
		comandos.put("login", new LoginCommand());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String proxima = null;
		try {
			Command comando = verificarComand(acao);
			proxima = comando.execute(request);
		} catch (NegocioException e) {
			request.setAttribute("msgErro", e.getMessage());
			proxima = "login.jsp";
		}
		request.getRequestDispatcher(proxima).forward(request, response);
	}
	
	private Command verificarComand(String acao) {
		Command comando = null;
		for (String key : comandos.keySet()) {
			if (key.equalsIgnoreCase(acao)) {
				comando = comandos.get(key);
			}
		}
		return comando;
	}
}
