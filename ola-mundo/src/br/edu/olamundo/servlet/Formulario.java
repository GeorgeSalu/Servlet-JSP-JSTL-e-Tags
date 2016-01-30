package br.edu.olamundo.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.alomundo.exception.ValidationException;
import br.edu.alomundo.util.Util;
import br.edu.alomundo.validator.CPFValidator;
import br.edu.alomundo.validator.DataValidator;
import br.edu.alomundo.validator.Validator;

@WebServlet("/formulario")
public class Formulario extends HttpServlet{


	private static final long serialVersionUID = -1870227999210896405L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		request.setAttribute("data", dateFormat.format(new Date()));

		String redirect = "servlet-example.jsp";
		if (validarCamposObg(request, response) 
				& validarData(request) & validarCPF(request)) {
			redirect = "servlet-resultado.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
		dispatcher.forward(request, response);
	}

	private boolean validarData(HttpServletRequest request) {
		boolean retorno = false;
		try {
			Validator dataValidator = new DataValidator();
			String nasc = request.getParameter("nasc");
			String exped = request.getParameter("exped");

			Map<String, Object> valoresData = new HashMap<>();
			valoresData.put("Dt. Nasc", nasc);
			valoresData.put("Dt. Expedição", exped);

			if (dataValidator.validar(valoresData)) {
				retorno = true;
			}
		} catch (ValidationException e) {
			request.setAttribute("msgErro", Util.concatenaMensagensRequest(request, e, "msgErro"));
		}
		return retorno;
	}

	private boolean validarCPF(HttpServletRequest request) {
		boolean retorno = false;
		try {
			String cpf = request.getParameter("cpf");

			Map<String, Object> valoresCPF = new HashMap<>();
			valoresCPF.put("CPF", cpf);
			if (new CPFValidator().validar(valoresCPF)) {
				retorno = true;
			}
		} catch (ValidationException e) {
			request.setAttribute("msgErro", Util.concatenaMensagensRequest(request, e, "msgErro"));
		}
		return retorno;
	}

	private boolean validarCamposObg(HttpServletRequest request, HttpServletResponse response) {
		boolean retorno = true;
		String msgErro = "";
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");
		String nasc = request.getParameter("nasc");
		String exped = request.getParameter("exped");

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
		if (exped == null || "".equals(exped)) {
			retorno = false;
			msgErro += "Campo Dt. Expedição obrigatório!<br/>";
		}
		request.setAttribute("msgErro", msgErro);
		return retorno;
	}

}
