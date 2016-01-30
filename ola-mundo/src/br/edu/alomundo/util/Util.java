package br.edu.alomundo.util;

import javax.servlet.http.HttpServletRequest;

public class Util {
	
	public static String concatenaMensagensRequest(HttpServletRequest request, Exception e) {
		String msgErro = "";
		if (request.getAttribute("msgErro") != null) {
			msgErro = (String) request.getAttribute("msgErro");
		}
		msgErro += e.getMessage() + "<br/>" ;
		return msgErro;
	}

}
