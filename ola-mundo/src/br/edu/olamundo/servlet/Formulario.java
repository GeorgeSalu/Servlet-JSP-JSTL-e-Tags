package br.edu.olamundo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cpf = request.getParameter("cpf");
		String nascimentos = request.getParameter("nasc");
		
		PrintWriter writer = response.getWriter();
		writer.println(" nome "+nome);
		writer.println(" endereco "+endereco);
		writer.println(" cpf "+cpf);
		writer.println(" nascimento "+nascimentos);
		writer.flush();
	
	}
	
	
}
