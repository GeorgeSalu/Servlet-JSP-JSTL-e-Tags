package br.edu.olamundo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.alomundo.exception.ValidationException;
import br.edu.alomundo.validator.DataValidator;
import br.edu.alomundo.validator.Validator;

@WebServlet("/formulario")
public class Formulario extends HttpServlet{


	private static final long serialVersionUID = -1870227999210896405L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		request.setAttribute("data", dateFormat.format(new Date()));
		
		Validator dataValidator = new DataValidator();
		String nasc = request.getParameter("nasc");
		
		String redirect = "servlet-example.jsp";
		try {
			if (validarCamposObg(request, response) && dataValidator.validar(nasc)) {
				redirect = "servlet-resultado.jsp";
			}
		} catch (ValidationException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
		dispatcher.forward(request, response);
	}
	
	private boolean validarCamposObg(HttpServletRequest request, HttpServletResponse response) {
		boolean retorno = true;
		String msgErro = "";
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");
		String nasc = request.getParameter("nasc");
		
		if (nome == null || "".equals(nome)) {
			retorno = false;
			msgErro += "Campo Nome obrigatório!<br/>";
		}
		if (endereco == null || "".equals(endereco)) {
			retorno = false;
			msgErro += "Campo Endereço obrigatório!<br/>";
		}
		if (cpf == null || "".equals(cpf)) {
			retorno = false;
			msgErro += "Campo CPF obrigatório!<br/>";
		}
		if (nasc == null || "".equals(nasc)) {
			retorno = false;
			msgErro += "Campo Dt. Nasc obrigatório!<br/>";
		}
		request.setAttribute("msgErro", msgErro);
		return retorno;
	}
	
}
