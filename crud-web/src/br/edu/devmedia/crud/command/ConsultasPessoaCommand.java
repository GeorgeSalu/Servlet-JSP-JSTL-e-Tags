package br.edu.devmedia.crud.command;

import javax.servlet.http.HttpServletRequest;

public class ConsultasPessoaCommand implements Command {

	private String proximo;

	public String execute(HttpServletRequest request) {
		proximo = "consultas.jsp";
		return proximo;
	}

}
