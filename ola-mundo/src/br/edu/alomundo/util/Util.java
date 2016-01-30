package br.edu.alomundo.util;

import javax.servlet.http.HttpServletRequest;

public class Util {
	
	public static String concatenaMensagensRequest(HttpServletRequest request, Exception e, String msg) {
		String msgErro = "";
		if (request.getAttribute(msg) != null) {
			msgErro = (String) request.getAttribute(msg);
		}
		msgErro += e.getMessage() + "<br/>" ;
		return msgErro;
	}

}
