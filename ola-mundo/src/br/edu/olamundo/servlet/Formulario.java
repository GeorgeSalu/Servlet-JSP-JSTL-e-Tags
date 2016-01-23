package br.edu.olamundo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class Formulario extends HttpServlet{


	private static final long serialVersionUID = -1870227999210896405L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String redirect = "jsp/servlet-examplo.jsp";
		if (validarCamposObg(request, response)) {
			redirect = "jsp/servlet-resultado.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
		dispatcher.forward(request, response);
	}
	
	
	private boolean validarCamposObg(HttpServletRequest request, HttpServletResponse response) {
		boolean retorno = true;
		String msgErro = null;
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");
		String nasc = request.getParameter("nasc");
		
		if (nome == null) {
			retorno = false;
			msgErro = "Campo Nome obrigat�rio!";
		} else if (endereco == null) {
			retorno = false;
			msgErro = "Campo Endere�o obrigat�rio!";
		} else if (cpf == null) {
			retorno = false;
			msgErro = "Campo CPF obrigat�rio!";
		} else if (nasc == null) {
			retorno = false;
			msgErro = "Campo Dt. Nasc obrigat�rio!";
		}
		request.setAttribute("msgErro", msgErro);
		return retorno;
	}


	
}
