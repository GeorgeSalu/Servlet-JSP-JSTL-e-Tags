package br.edu.olamundo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AloMundo2",urlPatterns={"/aloMundo"})
public class OlaMundoServlet2 extends HttpServlet{

	private static final long serialVersionUID = 8778446920638135317L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter writer = response.getWriter();
		
		writer.print("<h1>Ola Mundo Servlet</h1>");
		writer.flush();
		
	}
	
}
